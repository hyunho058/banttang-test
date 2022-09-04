package com.hproject.banttang.deal.infra.repository.custom;

import com.hproject.banttang.deal.controller.request.DealFilterRequest;
import com.hproject.banttang.deal.entity.Deal;
import com.hproject.banttang.deal.entity.value.Category;
import com.hproject.banttang.deal.entity.value.CategoryDetail;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

import static com.hproject.banttang.deal.entity.QDeal.deal;
import static com.hproject.banttang.dealparticipant.entity.QDealParticipant.dealParticipant;
import static com.hproject.banttang.location.entity.QLocation.location;
import static com.hproject.banttang.user.entity.QMember.member;

public class DealRepositoryImpl implements DealRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public DealRepositoryImpl(EntityManager entityManager) {
        this.queryFactory = new JPAQueryFactory(entityManager);
    }

    @Override
    public Page<Deal> findDeals(Pageable pageable, DealFilterRequest dealFilterRequest) {
        List<Deal> content = queryFactory
            .selectFrom(deal)
            .join(deal.member, member).fetchJoin()
            .join(deal.location, location).fetchJoin()
            .where(
                categoryEq(dealFilterRequest.getCategory()),
                categoryDetailEq(dealFilterRequest.getCategoryDetail()),
                deal.deletedAt.isNull(),
                titleContains(dealFilterRequest.getTitleKeyword())
            )
            .limit(pageable.getPageSize())
            .offset(pageable.getOffset())
            .orderBy(Expressions.stringTemplate("ST_Distance_Sphere({0}, {1})",
                    Expressions.stringTemplate("POINT({0}, {1})",
                        dealFilterRequest.getCurrentLongitude(),
                        dealFilterRequest.getCurrentLatitude()

                    ),
                    Expressions.stringTemplate("POINT({0}, {1})",
                        deal.tradeLongitude,
                        deal.tradeLatitude
                    )
                ).asc(),
                deal.createdAt.desc())
            .fetch();

        JPAQuery<Long> countQuery = queryFactory
            .select(deal.count())
            .from(deal)
            .where(
                categoryEq(dealFilterRequest.getCategory()),
                categoryDetailEq(dealFilterRequest.getCategoryDetail()),
                deal.deletedAt.isNull(),
                titleContains(dealFilterRequest.getTitleKeyword())
            )
            .orderBy(deal.createdAt.desc());

        return PageableExecutionUtils.getPage(content, pageable, countQuery::fetchOne);
    }

    @Override
    public Optional<Deal> findDealAndUser(Long id) {
        return Optional.ofNullable(queryFactory
                .selectFrom(deal)
                .join(deal.member, member).fetchJoin()
                .join(deal.location, location).fetchJoin()
                .where(
                        deal.id.eq(id),
                        deal.deletedAt.isNull()
                )
                .fetchOne());
    }

    @Override
    public Page<Deal> findUserDeals(Pageable pageable, long id) {
        List<Deal> content = queryFactory
                .selectFrom(deal)
                .where(
                        deal.deletedAt.isNull(),
                        userIdEq(id)
                )
                .join(deal.member, member).fetchJoin()
                .limit(pageable.getPageSize())
                .offset(pageable.getOffset())
                .orderBy(deal.createdAt.asc())
                .fetch();

        JPAQuery<Long> countQuery = queryFactory
                .select(deal.count())
                .from(deal)
                .where(
                        deal.deletedAt.isNull(),
                        userIdEq(id)
                )
                .orderBy(deal.createdAt.asc());

        return PageableExecutionUtils.getPage(content, pageable, countQuery::fetchOne);
    }

    @Override
    public Page<Deal> findUserParticipates(Pageable pageable, Long id) {
        List<Deal> content = queryFactory
                .select(deal)
                .from(deal)
                .join(dealParticipant).on(deal.id.eq(dealParticipant.deal.id))
                .join(deal.member, member).fetchJoin()
                .join(deal.location, location).fetchJoin()
                .where(
                        deal.deletedAt.isNull(),
                        dealParticipant.member.id.eq(id)
                )
                .limit(pageable.getPageSize())
                .offset(pageable.getOffset())
                .orderBy(deal.createdAt.desc())
                .fetch();

        JPAQuery<Long> countQuery = queryFactory
                .select(deal.count())
                .from(dealParticipant)
                .join(dealParticipant).on(deal.id.eq(dealParticipant.deal.id))
                .join(deal.member, member).fetchJoin()
                .join(deal.location, location).fetchJoin()
                .where(
                        deal.deletedAt.isNull(),
                        dealParticipant.member.id.eq(id)
                );

        return PageableExecutionUtils.getPage(content, pageable, countQuery::fetchOne);
    }

    private BooleanExpression categoryEq(Category category) {
        return StringUtils.hasText(category.toString()) ? deal.category.eq(category) : null;
    }

    private BooleanExpression categoryDetailEq(CategoryDetail categoryDetail) {
        return categoryDetail != null ? deal.categoryDetail.eq(categoryDetail) : null;
    }

    private BooleanExpression userIdEq(long id) {
        return deal.member.id.eq(id);
    }

    private BooleanExpression titleContains(String keyword) {
        return StringUtils.hasText(keyword) ? deal.title.contains(keyword) : null;
    }

}
