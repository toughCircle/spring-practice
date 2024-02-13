package hello.gradeservice.model;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class MetaData {

    private int resultCount;

    public MetaData(int resultCount) {
        this.resultCount = resultCount;
    }

    public MetaData() {
    }
}
