package hello.gradeservice.controller;

import hello.gradeservice.exception.CustomException;
import hello.gradeservice.model.*;
import hello.gradeservice.service.GradeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grades")
public class GradeController {

    private final GradeService gradeService;

    public GradeController(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    @PostMapping
    public ApiResponse<?> saveGrade(@RequestBody Grade grade) {
        if (grade.getScore() >= 6) {
            return ApiResponse.failure(500, "grade 는 6 이상 입력할 수 없습니다.", new InputRestriction(6));
        }
        Grade saveGrade = gradeService.saveGrade(grade);
        List<Grade> grades = gradeService.getAll();
        MetaData metaData = new MetaData(grades.size());
        return ApiResponse.success(200, "OK", metaData, saveGrade);
    }

    @GetMapping
    public ApiResponse<List<Grade>> getAll() {
        List<Grade> grades = gradeService.getAll();
        MetaData metaData = new MetaData(grades.size());

        return ApiResponse.success(200, "OK", metaData, grades);
    }

    @GetMapping("/{score}")
    public ApiResponse<List<Grade>> getGradeByScore(@PathVariable int score) {
        List<Grade> grades = gradeService.findByScore(score);
        MetaData metaData = new MetaData(grades.size());
        return ApiResponse.success(200, "OK", metaData, grades);
    }
}
