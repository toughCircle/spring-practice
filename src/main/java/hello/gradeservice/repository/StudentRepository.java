package hello.gradeservice.repository;

import hello.gradeservice.model.Student;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class StudentRepository {

    Set<Student> students = new HashSet<>();

    // 저장
    public void add(Student student) {
        students.add(student);
    }

    // 저장된 모든 이름과 성적 오름차순으로 조회
    public List<Student> getAll() {
        return students.stream().sorted()
            .collect(Collectors.toList());
    }

    // 특정 성적 조회
    public List<Student> findByGrade(int grade) {
        return students.stream()
            .filter(student -> student.getGrade() == grade)
            .collect(Collectors.toList());
    }
}
