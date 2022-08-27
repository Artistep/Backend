package artistep.version1.global.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

@Getter
@AllArgsConstructor
public enum ErrorCode {


    /**
     400 Error - BAD_REQUEST
     */
    INVALID_REQUEST(BAD_REQUEST, "요청이 올바르지 않습니다."),
    OVERLAP_EMAIL(BAD_REQUEST, "이미 존재하는 이메일 입니다."),
    OVERLAP_WORKING_NAME(BAD_REQUEST, "이미 존재하는 활동명 입니다."),
    JWT_SIGNATURE_EXCEPTION(BAD_REQUEST, "토큰 서명이 올바르지 않습니다."),
    JWT_MALFORMED_EXCEPTION(BAD_REQUEST, "토큰이 올바르지 않습니다."),
    JWT_UNSUPPORTED_EXCEPTION(BAD_REQUEST, "지원하지 않는 토큰 형식입니다."),
    JWT_IllegalARGUMENT_EXCEPTION(BAD_REQUEST, "허용하지 않는 토큰입니다."),


    /**
     401 Error - UNAUTHORIZED
     */
    INVALID_AUTH(UNAUTHORIZED, "검증되지 않은 사용자 입니다."),
    JWT_EXPIRED_EXCEPTION(UNAUTHORIZED, "토큰이 만료되었습니다."),


    /**
     403 Error - RESTRICTED
     */
    INVALID_RESTRICTED(FORBIDDEN, "접근 권한이 없습니다."),

    /**
     404 Error - NOT_FOUND
     */
    INVALID_FOUND(NOT_FOUND, "요청을 찾을 수 없습니다."),



    ;



    private final HttpStatus httpStatus;
    private final String detail;
}
