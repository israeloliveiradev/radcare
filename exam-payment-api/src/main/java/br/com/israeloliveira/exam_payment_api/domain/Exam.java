package br.com.israeloliveira.exam_payment_api.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static jakarta.persistence.GenerationType.AUTO;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Exam {

    private Long id;

    private String examName;

    private String description;

    private String recommendations;

    private String modality;

    private String medicalInstructions;

    private Double price;





}
