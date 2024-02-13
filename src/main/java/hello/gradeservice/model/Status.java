package hello.gradeservice.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Status {
    private int code;
    private String message;

    public Status() {
    }

    public Status(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
