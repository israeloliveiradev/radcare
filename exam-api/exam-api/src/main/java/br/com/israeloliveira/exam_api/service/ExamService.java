package br.com.israeloliveira.exam_api.service;

import br.com.israeloliveira.exam_api.domain.Exam;

import java.util.List;

public interface ExamService {

    Exam findById(Long id);

    List<Exam> findAll();

    void deleteById(Long id);

    Exam createExam(Exam exam);

    Exam updateExam(Long id, Exam exam);
}
