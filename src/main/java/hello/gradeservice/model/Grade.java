package hello.gradeservice.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Getter @Setter
public class Grade {

    private Long id;

    private String name;
    private int score;
}
