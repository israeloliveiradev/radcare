package br.com.israeloliveira.exam_payment_api.service;


import br.com.israeloliveira.user_api.domain.Patient;

import java.util.List;


public interface ExamPaymentService {

    Patient findById(Long id);
    List<Patient> findAll();
}
