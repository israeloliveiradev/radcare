package br.com.israeloliveira.exam_payment_api.feignClients;

import br.com.israeloliveira.exam_payment_api.domain.Exam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "exam-api", url= "http://localhost:8200")
public interface ExamFeign {

    @GetMapping(value = "/api/exams/{id}")
    ResponseEntity<Exam> findById(@PathVariable Long id);

    @GetMapping
    ResponseEntity<List<Exam>> findAll();
}
