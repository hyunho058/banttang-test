package com.hproject.banttang.common.infra.file.repository;

import com.hproject.banttang.common.entity.file.S3Image;
import com.hproject.banttang.common.infra.file.repository.custom.FileRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FileRepository extends JpaRepository<S3Image, Long>, FileRepositoryCustom {
    Optional<S3Image> findByImageUrl(String imageUrl);
}
