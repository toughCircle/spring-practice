package hello.gradeservice.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Objects;

@Data
@RequiredArgsConstructor // 생성자 구현 --> 왜 적용 안되는 것..?
public class Student implements Comparable<Student> {

    private String name;
    private int grade;

    public Student(String name, int grade) {
        this.name = name;
        this.grade = grade;
    }

    @Override // 정렬 구현
    public int compareTo(Student o) {
        // 인자로 넘어온 같은 타입의 다른 객체와 대소 비교
        return this.grade - o.getGrade();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return grade == student.grade && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, grade);
    }
}
