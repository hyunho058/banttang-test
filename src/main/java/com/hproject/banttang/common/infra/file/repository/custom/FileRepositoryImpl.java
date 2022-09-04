package com.hproject.banttang.common.infra.file.repository.custom;

import com.hproject.banttang.common.entity.file.S3Image;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;

import javax.persistence.EntityManager;
import java.util.List;

import static com.hproject.banttang.common.entity.file.QS3Image.s3Image;

public class FileRepositoryImpl implements FileRepositoryCustom {
    private final JPAQueryFactory queryFactory;

    public FileRepositoryImpl(EntityManager entityManager) {
        queryFactory = new JPAQueryFactory(entityManager);
    }

    @Override
    public List<S3Image> findAllByImageUrl(List<String> imageUrls) {
        return queryFactory.selectFrom(s3Image)
                .where(
                        s3Image.deletedAt.isNull(),
                        findImageUrls(imageUrls))
                .fetch();
    }

    private BooleanBuilder findImageUrls(List<String> imageUrls) {
        BooleanBuilder builder = new BooleanBuilder();
        if (imageUrls != null) {
            for (String imageUrl : imageUrls) {
                builder.or(s3Image.imageUrl.eq(imageUrl));
            }
        }
        return builder;
    }
}
