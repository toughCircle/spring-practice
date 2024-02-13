package hello.gradeservice.service;

import hello.gradeservice.model.ApiResponse;
import hello.gradeservice.model.Grade;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Service
public class GradeService {
    private final Map<Long, Grade> grades = new HashMap<>();
    private final AtomicLong counter = new AtomicLong();

    public List<Grade> getAll() {
        List<Grade> gradesList = new ArrayList<>(grades.values())
            .stream()
            .sorted(Comparator.comparingInt(Grade::getScore))
            .collect(Collectors.toList());
        return gradesList;
    }

    public Grade saveGrade(Grade grade) {

        long id = counter.incrementAndGet();
        grade.setId(id);
        grades.put(id, grade);

        return grade;
    }

    public List<Grade> findByScore(int score) {
        return grades.values()
            .stream()
            .filter(grade -> grade.getScore() == score)
            .sorted(Comparator.comparingInt(Grade::getScore))
            .collect(Collectors.toList());
    }
}
