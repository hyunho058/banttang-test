package com.hproject.banttang.common.controller.request.file;

import lombok.Getter;

import javax.validation.constraints.Size;
import java.util.List;

@Getter
public class FileDeleteRequest {
    @Size(min = 1, max = 5)
    private List<String> imageUrls;
}
