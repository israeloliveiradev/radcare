package br.com.israeloliveira.exam_payment_api.resources.impl;

import br.com.israeloliveira.exam_payment_api.domain.ExamPayment;
import br.com.israeloliveira.exam_payment_api.resources.ExamPaymentResources;
import br.com.israeloliveira.exam_payment_api.service.ExamPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "/api/payments")
public class ExamPaymentResourcesImpl implements ExamPaymentResources {

    @Autowired
    ExamPaymentService examPaymentService;

    @Override
    public ResponseEntity<ExamPayment> createExamPayment(ExamPayment payment) {
        return ResponseEntity.ok().body(examPaymentService.createNewExamPayment(payment));
    }

    @Override
    public ResponseEntity<List<ExamPayment>> findAll() {
        return ResponseEntity.ok().body(examPaymentService.findAll());
    }

    @Override
    public ResponseEntity<ExamPayment> findById(Long id) {
        return ResponseEntity.ok().body(examPaymentService.findById(id));
    }

    @Override
    public ResponseEntity<ExamPayment> confirmPayment(Long id) {
        return ResponseEntity.ok().body(examPaymentService.confirmPayment(id));
    }
}
