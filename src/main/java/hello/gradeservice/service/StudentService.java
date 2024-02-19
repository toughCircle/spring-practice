package hello.gradeservice.service;

import hello.gradeservice.exception.CustomException;
import hello.gradeservice.exception.InputRestriction;
import hello.gradeservice.model.ErrorCode;
import hello.gradeservice.model.Student;
import hello.gradeservice.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public Student addStudent(String name, int grade) {

        if (grade >= 6) {
            throw new CustomException(ErrorCode.BAD_REQUEST, "grade 는 6 이상을 입력할 수 없습니다.", new InputRestriction(6));
        }
        Student student = new Student(name, grade);
        studentRepository.add(student);

        return student;
    }

    public List<Student> getAll() {
        return studentRepository.getAll();
    }

    public List<Student> findByGrade(int grade) {
        return studentRepository.findByGrade(grade);
    }
}
