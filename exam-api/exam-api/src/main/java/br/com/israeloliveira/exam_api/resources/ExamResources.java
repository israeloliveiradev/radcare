package br.com.israeloliveira.exam_api.resources;

import br.com.israeloliveira.exam_api.domain.Exam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface ExamResources {

    @PostMapping
    ResponseEntity<Exam> createExam(@RequestBody Exam exam);

    @PutMapping(value = "/{id}")
    ResponseEntity<Exam> updateExam(@PathVariable Long id, @RequestBody Exam exam);

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    ResponseEntity<Void> deleteExam(@PathVariable Long id);

    @GetMapping
    ResponseEntity<List<Exam>> findAll();

    @GetMapping(value = "/{id}")
    ResponseEntity<Exam> findById(@PathVariable Long id);




}
