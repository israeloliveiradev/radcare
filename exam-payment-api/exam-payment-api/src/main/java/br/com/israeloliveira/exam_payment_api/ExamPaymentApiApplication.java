package br.com.israeloliveira.exam_payment_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ExamPaymentApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamPaymentApiApplication.class, args);
	}


}
