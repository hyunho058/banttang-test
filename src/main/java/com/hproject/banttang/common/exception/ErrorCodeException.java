package com.hproject.banttang.common.exception;

public abstract class ErrorCodeException extends RuntimeException {
    private final ErrorCode errorCode;

    public ErrorCodeException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public ErrorCodeException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public ErrorCodeException(ErrorCode errorCode, Throwable cause) {
        super(cause);
        this.errorCode = errorCode;
    }

    public String getKey() {
        return errorCode.getKey();
    }

    public String getMessage() {
        return errorCode.getMessage();
    }

    protected enum ErrorCode {
        DEAL_NOT_FOUND("거래글 정보가 존재하지 않습니다."),
        USER_NOT_FOUND("사용자 정보가 존재하지 않습니다."),
        FAQ_NOT_FOUND("FAQ 정보가 존재하지 않습니다."),
        FAQ_EXISTENCE_DELETE_AT("FAQ DeleteAt 값이 존재합니다."),
        JSON_CONVERT_ERROR("이미지 리스트를 변경하는 데 실패하였습니다."),
        JWT_VALIDATION_ERROR("토큰이 유효하지 않습니다."),
        JWT_AUTH_DENY_ERROR("승인되지 않은 접근입니다."),
        FILE_CONVERT_ERROR("이미지를 변경하는 데 실패하였습니다."),
        FCM_SEND_FAIL("메시지 전송에 실패하였습니다"),
        DUPLICATED_DEAL_PARTICIPANT_ERROR("중복된 거래글 참여자입니다."),
        DEAL_PARTICIPANT_CANCEL_COUNT_OVER_ERROR("Cancel_count 횟수 초과."),
        FCM_ACCOUNT_FILE_NOT_FOUND("FCM 서비스 인증 파일을 찾지 못했습니다"),
        DEAL_PARTICIPANT_NOT_FOUND("해당 거래에서는 검색한 유저를 찾을 수 없습니다."),
        NOTICE_NOT_FOUND("공지사항 정보가 존재하지 않습니다."),
        AUTHENTICATION_FAIL("인증이 실패했습니다."),
        DUPLICATED_JOINING("이미 가입된 사용자입니다."),
        INVALID_REQUEST("입력 데이터가 잘못되었습니다."),
        COMMENT_NOT_FOUND("댓글 정보가 존재하지 않습니다."),
        FORBIDDEN_ERROR("토큰 값이 일치하지 않습니다.");

        private final String message;

        ErrorCode(String message) {
            this.message = message;
        }

        public String getKey() {
            return name().replace("_", "-").toLowerCase();
        }

        public String getMessage() {
            return message;
        }
    }
}
