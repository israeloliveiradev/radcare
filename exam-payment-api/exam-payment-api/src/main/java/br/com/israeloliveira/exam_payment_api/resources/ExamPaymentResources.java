package br.com.israeloliveira.exam_payment_api.resources;

import br.com.israeloliveira.exam_payment_api.domain.ExamPayment;
import br.com.israeloliveira.exam_payment_api.domain.Patient;
import br.com.israeloliveira.exam_payment_api.feignClients.PatientFeign;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/payments")
public class ExamPaymentResources {


    private final PatientFeign patientFeign;

    @GetMapping(value = "/{patientId}")
    public ResponseEntity<ExamPayment> getPayment(@PathVariable Long patientId, @RequestBody ExamPayment payment) {

        Patient patient = patientFeign.findById(patientId).getBody();

        return ResponseEntity.ok().body(
                new ExamPayment(
                        null,
                        patient.getName(),
                        1L,
                        payment.getTotalPayment(),
                        payment.getPaymentMethod(),
                        LocalDateTime.now()
                ));



   }
}
