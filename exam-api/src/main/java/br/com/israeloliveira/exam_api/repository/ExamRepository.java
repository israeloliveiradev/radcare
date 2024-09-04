package br.com.israeloliveira.exam_api.repository;

import br.com.israeloliveira.exam_api.domain.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamRepository extends JpaRepository<Exam, Long> {

}
