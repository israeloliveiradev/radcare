package com.israeloliveiradev.adapters.inbound.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserRequest {

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

    @NotNull(message = "This field cannot be empty. Please provide a valid value.")
    private String documentId;

    private Boolean administrator;
}
