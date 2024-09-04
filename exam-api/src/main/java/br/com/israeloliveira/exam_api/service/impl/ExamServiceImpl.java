package br.com.israeloliveira.exam_api.service.impl;

import br.com.israeloliveira.exam_api.domain.Exam;
import br.com.israeloliveira.exam_api.repository.ExamRepository;
import br.com.israeloliveira.exam_api.service.ExamService;
import br.com.israeloliveira.exam_api.service.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ExamServiceImpl implements ExamService {

    @Autowired
    ExamRepository examRepository;

    private final Environment environment;

    @Override
    public Exam findById(Long id) {
        log.info("EXAM-SERVICE ::: Get request on {} port", environment.getProperty("local.server.port"));
        return examRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object not Found"));
    }

    @Override
    public List<Exam> findAll() {return examRepository.findAll();}

    @Override
    public void deleteById(Long id) {
        if (!examRepository.existsById(id)) {
            throw new ObjectNotFoundException("Object not found");
        }
        examRepository.deleteById(id);
    }

    @Override
    public Exam createExam(Exam exam) {
        return examRepository.save(exam);
    }

    @Override
    public Exam updateExam(Long id, Exam exam) {
        Exam examToUpdate = examRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object not found"));

        examToUpdate.setExamName(exam.getExamName());
        examToUpdate.setDescription(exam.getDescription());
        examToUpdate.setRecommendations(exam.getRecommendations());
        examToUpdate.setPrice(exam.getPrice());

        return examRepository.save(examToUpdate);
    }
}
