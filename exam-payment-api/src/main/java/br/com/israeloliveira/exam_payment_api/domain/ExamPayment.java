package br.com.israeloliveira.exam_payment_api.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tb_exam_payments")
public class ExamPayment {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String PatientName;

    private Long patientId;

    private Long examId;

    private String examName;

    private Double totalPayment;

    private String paymentMethod;

    private LocalDateTime paymentDate;

    private String paymentStatus = "PENDING";


}
