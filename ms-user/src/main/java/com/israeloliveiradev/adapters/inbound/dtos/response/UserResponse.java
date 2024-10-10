package com.israeloliveiradev.adapters.inbound.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

    private Long id;

    private String name;

    private String email;

    private String gender;

    private String phoneNumber;

    private LocalDate birthDate;

    private String zipCode;

    private Boolean administrator;
}
