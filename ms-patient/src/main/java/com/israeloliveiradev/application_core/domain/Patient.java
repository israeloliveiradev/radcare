package com.israeloliveiradev.application_core.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.time.LocalDate;
import static javax.persistence.GenerationType.AUTO;

public class user {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = AUTO)
    private Long id;

    @NotBlank(message = "This field cannot be empty. Please provide a valid value.")
    private String name;

    @Email
    private String email;

    @NotBlank
    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*\\W).{8,}$", message = "Password must contain at least 8 characters, including uppercase, lowercase, number, and special character.")
    private String password;

    private String gender;

    private String phoneNumber;

    private LocalDate birthDate;

    private String zipCode;

    private String documentId;

}
