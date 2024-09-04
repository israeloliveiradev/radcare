package br.com.israeloliveira.exam_api.resources.impl;

import br.com.israeloliveira.exam_api.domain.Exam;
import br.com.israeloliveira.exam_api.resources.ExamResources;
import br.com.israeloliveira.exam_api.service.ExamService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/exams")
public class ExamResourcesImpl implements ExamResources {


    @Autowired
    ExamService examService;


    @Override
    public ResponseEntity<Exam> createExam(Exam exam) {
        return ResponseEntity.ok().body(examService.createExam(exam));
    }

    @Override
    public ResponseEntity<Exam> updateExam(Long id, Exam exam) {
        return ResponseEntity.ok().body(examService.updateExam(id , exam));
    }

    @Override
    public ResponseEntity<Void> deleteExam(Long id) {
        examService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<List<Exam>> findAll() {
        return ResponseEntity.ok().body(examService.findAll());
    }

    @Override
    public ResponseEntity<Exam> findById(Long id) {
        return ResponseEntity.ok().body(examService.findById(id));
    }
}
