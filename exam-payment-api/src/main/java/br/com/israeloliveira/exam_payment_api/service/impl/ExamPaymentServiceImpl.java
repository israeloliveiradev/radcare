package br.com.israeloliveira.exam_payment_api.service.impl;

import br.com.israeloliveira.exam_payment_api.domain.Exam;
import br.com.israeloliveira.exam_payment_api.domain.ExamPayment;
import br.com.israeloliveira.exam_payment_api.domain.Patient;
import br.com.israeloliveira.exam_payment_api.feignClients.ExamFeign;
import br.com.israeloliveira.exam_payment_api.feignClients.PatientFeign;
import br.com.israeloliveira.exam_payment_api.repository.ExamPaymentRepository;
import br.com.israeloliveira.exam_payment_api.service.ExamPaymentService;
import br.com.israeloliveira.exam_payment_api.service.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ExamPaymentServiceImpl implements ExamPaymentService {

    @Autowired
    ExamPaymentRepository examPaymentRepository;

    private final PatientFeign patientFeign;

    private final ExamFeign examFeign;

    private final Environment environment;

    @Override
    public ExamPayment findById(Long id) {
        log.info("PAYMENT-SERVICE ::: Get request on {} port", environment.getProperty("local.server.port"));

        return examPaymentRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object Not Found"));
    }

    @Override
    public List<ExamPayment> findAll() {
        return examPaymentRepository.findAll();
    }

    @Override
    public ExamPayment createNewExamPayment(ExamPayment examPayment) {

        Patient patient = patientFeign.findById(examPayment.getPatientId()).getBody();
        if (patient == null) {
            throw new ObjectNotFoundException("Patient not found");
        }

        Exam exam = examFeign.findById(examPayment.getExamId()).getBody();
        if (exam == null) {
            throw new ObjectNotFoundException("Exam not found");
        }

        examPayment.setPatientName(patient.getName());
        examPayment.setExamName(exam.getExamName());
        examPayment.setTotalPayment(exam.getPrice());


        return examPaymentRepository.save(examPayment);

    }

    @Override
    public ExamPayment confirmPayment(Long id) {
        ExamPayment paymentToConfirm = examPaymentRepository.findById(id).orElseThrow(() ->
                new ObjectNotFoundException("Exam payment not found"));

            paymentToConfirm.setPaymentStatus("PAID");
            paymentToConfirm.setPaymentDate(LocalDateTime.now());

            return examPaymentRepository.save(paymentToConfirm);

        }

    }

