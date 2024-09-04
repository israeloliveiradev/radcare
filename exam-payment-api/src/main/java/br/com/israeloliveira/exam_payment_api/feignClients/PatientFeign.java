package br.com.israeloliveira.exam_payment_api.feignClients;


import br.com.israeloliveira.exam_payment_api.domain.Patient;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@FeignClient(name = "patient-api")
public interface PatientFeign {


    @LoadBalanced
    @GetMapping(value = "/api/patients/{id}")
    ResponseEntity<Patient> findById(@PathVariable Long id);

    @GetMapping
    ResponseEntity<List<Patient>> findAll();
}

