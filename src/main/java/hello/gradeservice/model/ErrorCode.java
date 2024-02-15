package hello.gradeservice.model;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public enum ErrorCode {
    OK(2000, "OK", HttpStatus.OK),
    BAD_REQUEST(5000, "BAD REQUEST", HttpStatus.BAD_REQUEST)
    ;

    @Getter
    private final int code;

    @Getter
    private final String message;

    @Getter
    private final HttpStatus httpStatus;

    ErrorCode(int code, String message, HttpStatus httpStatus) {
        this.code = code;
        this.message = message;
        this.httpStatus = httpStatus;
    }
}
