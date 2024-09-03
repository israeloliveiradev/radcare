package br.com.israeloliveira.exam_payment_api.resources;

import br.com.israeloliveira.exam_payment_api.domain.ExamPayment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

public interface ExamPaymentResources {

    @PostMapping
    ResponseEntity<ExamPayment> createExamPayment(@RequestBody ExamPayment payment);

    @GetMapping
    ResponseEntity<List<ExamPayment>> findAll();

    @GetMapping(value = "/{id}")
    ResponseEntity<ExamPayment> findById(@PathVariable Long id);

    @PutMapping(value = "/{id}/confirm")
    ResponseEntity<ExamPayment> confirmPayment(@PathVariable Long id);

}
