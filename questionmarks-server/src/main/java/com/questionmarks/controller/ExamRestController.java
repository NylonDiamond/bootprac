package com.questionmarks.controller;

import com.questionmarks.model.Exam;
import com.questionmarks.model.dto.ExamCreationDTO;
import com.questionmarks.model.dto.ExamUpdateDTO;
import com.questionmarks.persistence.ExamRepository;
import com.questionmarks.util.DTO;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/exams")
public class ExamRestController {

    private ExamRepository examRepository;

    public ExamRestController(ExamRepository examRepository) {//or use @Autowire above creation above
        this.examRepository = examRepository;
    }

    @GetMapping
//    public String getExams() {
//        return "It worked"
//    }

//    curl -H "Content-Type:application/json" -X POST -d '{"title": "test", "description": "test", "createdAt": "2016-11-09T11:44:44.797", "editedAt": "2016-11-09T11:44:44.797", "published": true}' http://localhost:8080/exams
//
    public List<Exam> getExams() {
        return examRepository.findAll();
    }

    @PostMapping
    public void newExam(@DTO(ExamCreationDTO.class) Exam exam) {
        examRepository.save(exam);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public void editExam(@DTO(ExamUpdateDTO.class) Exam exam) {
        examRepository.save(exam);
    }
}