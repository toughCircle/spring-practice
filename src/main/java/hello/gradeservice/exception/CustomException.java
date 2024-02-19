package hello.gradeservice.exception;

import hello.gradeservice.model.ErrorCode;
import lombok.Getter;
import org.springframework.util.StringUtils;

import java.util.AbstractMap;
import java.util.Map;

public class CustomException extends RuntimeException{

    @Getter
    private final ErrorCode errorCode;

    private final String message;

    @Getter
    private final Map.Entry<String, Object> data;

    public CustomException(ErrorCode errorCode, String message, Object data) {
        this.errorCode = errorCode;
        this.message = message;
        this.data = new AbstractMap.SimpleEntry<>(data.getClass().getSimpleName(), data);
    }


    public String getMessage() {
        if (StringUtils.hasLength(this.message)) {
            return this.message;
        }
        return errorCode.getMessage();
    }

}
