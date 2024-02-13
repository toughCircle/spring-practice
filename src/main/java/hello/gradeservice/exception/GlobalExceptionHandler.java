package hello.gradeservice.exception;

import hello.gradeservice.model.ApiResponse;
import hello.gradeservice.model.Status;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    @ResponseBody
    public ApiResponse<Object> handlerCustomException(CustomException ex) {
        Status status = new Status(ex.getCode(), ex.getMessage());
        return new ApiResponse<>(status, ex.getData());
    }
}