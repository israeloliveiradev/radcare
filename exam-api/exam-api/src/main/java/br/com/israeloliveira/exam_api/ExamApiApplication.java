package br.com.israeloliveira.exam_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
public class ExamApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExamApiApplication.class, args);
	}

}
