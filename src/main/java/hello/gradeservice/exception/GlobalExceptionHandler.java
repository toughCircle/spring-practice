package hello.gradeservice.exception;

import hello.gradeservice.model.ApiResponse;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CustomException.class)
    public ApiResponse customExceptionHandler(CustomException customException, HttpServletResponse response) {
        response.setStatus(customException.getErrorCode().getHttpStatus().value());
        return new ApiResponse(customException.getErrorCode().getCode(), customException.getMessage(), customException.getData());
    }
}
