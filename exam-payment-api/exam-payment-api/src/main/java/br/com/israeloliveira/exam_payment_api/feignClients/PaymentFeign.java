package br.com.israeloliveira.exam_payment_api.feignClients;


import br.com.israeloliveira.exam_payment_api.domain.ExamPayment;
import br.com.israeloliveira.exam_payment_api.domain.Patient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "patient-api", url = "http://localhost:8000")
public interface PaymentFeign {

    @GetMapping(value = "/api/payments/{id}")
    ResponseEntity<Patient> findById(@PathVariable Long id);

    @GetMapping
    ResponseEntity<List<Patient>> findAll();
}

