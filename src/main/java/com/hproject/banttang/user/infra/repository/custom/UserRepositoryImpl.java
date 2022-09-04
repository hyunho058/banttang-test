package com.hproject.banttang.user.infra.repository.custom;

import com.hproject.banttang.user.entity.Member;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;

import static com.hproject.banttang.user.entity.QMember.member;

public class UserRepositoryImpl implements UserRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public UserRepositoryImpl(EntityManager entityManager) {
        this.queryFactory = new JPAQueryFactory(entityManager);
    }

    @Override
    public Member findUserKey(String userKey) {
        return queryFactory
                .selectFrom(member)
                .where(userKeyEq(userKey))
                .fetchOne();
    }

    @Override
    public Member findByUserNickname(String nickname) {
        return queryFactory
                .selectFrom(member)
                .where(userNicknameEq(nickname))
                .fetchOne();
    }


    private BooleanExpression userIdEq(Long id) {
        return id != null ? member.id.eq(id) : null;
    }

    private BooleanExpression userKeyEq(String userKey){
        return userKey != null ? member.userKey.eq(userKey) : null;
    }

    public BooleanExpression userNicknameEq(String nickname){
        return StringUtils.hasText(nickname)? member.nickname.eq(nickname) : null;
    }
}
