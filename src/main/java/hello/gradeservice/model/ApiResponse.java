package hello.gradeservice.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponse<T> {

    private Status status; // 코드, 메시지
    private T data;
    private MetaData metaData;

    public ApiResponse() {
    }

    public ApiResponse(Status status, MetaData metaData, T data) {
        this.status = status;
        this.metaData = metaData;
        this.data = data;
    }

    public ApiResponse(Status status, T data) {
        this.status = status;
        this.data = data;
    }

    // 성공 응답 생성 메소드
    public static <T> ApiResponse<T> success(int code, String message, MetaData metaData, T data) {
        Status status = new Status(code, message);
        return new ApiResponse<>(status, metaData, data);
    }

    // 실패 응답 생성 메소드
    public static <T> ApiResponse<T> failure(int code, String errorMessage, T data) {
        Status status = new Status(code, errorMessage);
        return new ApiResponse<>(status, data);
    }
}