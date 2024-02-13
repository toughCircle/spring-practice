package hello.gradeservice.exception;

import lombok.Getter;

@Getter
public class CustomException extends RuntimeException{

    private final int code;
    private final Object data;

    public CustomException(int code, String message, Object data) {
        super(message);
        this.code = code;
        this.data = data;
    }
}
