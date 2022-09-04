package com.hproject.banttang.common.service.file.exception;

import com.hproject.banttang.common.exception.ErrorCodeException;

public class FileConvertException extends ErrorCodeException {
    public FileConvertException() {
        super(ErrorCode.FILE_CONVERT_ERROR);
    }

    public FileConvertException(Throwable cause) {
        super(ErrorCode.FILE_CONVERT_ERROR, cause);
    }
}
