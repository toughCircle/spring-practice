package hello.gradeservice.controller;

import hello.gradeservice.exception.CustomException;
import hello.gradeservice.exception.InputRestriction;
import hello.gradeservice.model.*;
import hello.gradeservice.service.StudentService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/grades")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ApiResponse add(
        @RequestParam("name") String name,
        @RequestParam("grade") int grade
    ) {
        return makeResponse(studentService.addStudent(name, grade));
    }

    public <T> ApiResponse<T> makeResponse(List<T> result) {
        return new ApiResponse<>(result);
    }

    public <T> ApiResponse<T> makeResponse(T result) {
        return makeResponse(Collections.singletonList(result));
    }

    @GetMapping
    public  ApiResponse getAll() {
        return makeResponse(studentService.getAll());
    }

    @GetMapping("/{score}")
    public ApiResponse getGradeByScore(@PathVariable int grade) {
        return makeResponse(studentService.findByGrade(grade));
    }

    @ExceptionHandler(CustomException.class)
    public ApiResponse customExceptionHandler(CustomException customException, HttpServletResponse response) {
        response.setStatus(customException.getErrorCode().getHttpStatus().value());
        return new ApiResponse(customException.getErrorCode().getCode(), customException.getMessage(), customException.getData());
    }
}
