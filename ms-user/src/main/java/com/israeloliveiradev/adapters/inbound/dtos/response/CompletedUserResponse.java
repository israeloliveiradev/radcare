package com.israeloliveiradev.adapters.inbound.dtos.response;

import com.israeloliveiradev.application_core.domain.User;
import lombok.*;

import java.time.LocalDate;


@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompletedUserResponse {
    private Long id;
    private String name;
    private String email;
    private String gender;
    private String phoneNumber;
    private LocalDate birthDate;
    private String zipCode;
    private String documentId;
    private Boolean administrator;
    private String address;
    private String neighborhood;
    private String city;
    private String state;
}
