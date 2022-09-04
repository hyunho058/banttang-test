package com.hproject.banttang.common.infra.file.repository.custom;

import com.hproject.banttang.common.entity.file.S3Image;

import java.util.List;

public interface FileRepositoryCustom {
    List<S3Image> findAllByImageUrl(List<String> imageUrls);
}
