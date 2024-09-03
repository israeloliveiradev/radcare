package br.com.israeloliveira.exam_payment_api.resources.impl;


import br.com.israeloliveira.exam_payment_api.domain.ExamPayment;
import br.com.israeloliveira.exam_payment_api.resources.ExamPaymentResources;
import br.com.israeloliveira.exam_payment_api.service.ExamPaymentService;
import br.com.israeloliveira.user_api.domain.Patient;
import br.com.israeloliveira.user_api.resources.PatientResources;
import br.com.israeloliveira.user_api.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/payments")
public class ExamPaymentResourcesImpl implements  {


    @Autowired
    ExamPaymentService examPaymentService;

    @Override
    public ResponseEntity<ExamPayment> findById(Long id) {
        return ResponseEntity.ok().body(examPaymentService.findById(id));
    }

    @Override
    public ResponseEntity<List<ExamPayment>> findAll() {
        return ResponseEntity.ok().body(examPaymentService.findAll());
    }
}
