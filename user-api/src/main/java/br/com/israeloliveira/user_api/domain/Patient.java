package br.com.israeloliveira.user_api.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

import static jakarta.persistence.GenerationType.AUTO;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "tb_users")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Patient {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = AUTO)
    private Long id;

    private String name;

    private String email;

    private String password;

    private String gender;

    private String phoneNumber;

    private LocalDate birthDate;

    private String zipCode;

    private String documentId;
}
