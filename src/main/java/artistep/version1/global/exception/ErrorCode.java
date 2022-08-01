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

    /**
     401 Error - UNAUTHORIZED
     */
    INVALID_AUTH(UNAUTHORIZED, "검증되지 않은 사용자 입니다."),

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
