package br.com.israeloliveira.exam_api.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.AUTO;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tb_exams")
public class Exam {


    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;

    private String examName;

    private String description;

    private String recommendations;

    private String modality;

    private String medicalInstructions;

    private Double price;





}
