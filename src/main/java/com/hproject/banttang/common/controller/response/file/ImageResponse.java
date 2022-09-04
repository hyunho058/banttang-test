package com.hproject.banttang.common.controller.response.file;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
@Builder
public class ImageResponse {
    private final List<String> images;

}
