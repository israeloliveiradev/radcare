package br.com.israeloliveira.exam_payment_api.service;


import br.com.israeloliveira.exam_payment_api.domain.ExamPayment;

import java.util.List;


public interface ExamPaymentService {

    ExamPayment findById(Long id);
    List<ExamPayment> findAll();
    ExamPayment createNewExamPayment(ExamPayment examPayment);
    ExamPayment confirmPayment(Long id);

}
