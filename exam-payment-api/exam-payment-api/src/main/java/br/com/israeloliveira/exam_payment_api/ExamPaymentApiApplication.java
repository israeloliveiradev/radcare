package br.com.israeloliveira.exam_payment_api;

import br.com.israeloliveira.exam_payment_api.domain.ExamPayment;
import br.com.israeloliveira.exam_payment_api.repository.ExamPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cglib.core.Local;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
@EnableFeignClients
public class ExamPaymentApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamPaymentApiApplication.class, args);
	}

	}

