package br.com.israeloliveira.exam_payment_api.repository;

import br.com.israeloliveira.exam_payment_api.domain.ExamPayment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamPaymentRepository extends JpaRepository<ExamPayment, Long> {
}
