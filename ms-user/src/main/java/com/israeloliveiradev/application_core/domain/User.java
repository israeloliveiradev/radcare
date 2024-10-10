package com.israeloliveiradev.application_core.domain;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @NotNull
    private String documentId;

    private Boolean administrator;


    public User() {
    }

    public User(Long id, String name, String email, String password, String gender, String phoneNumber, LocalDate birthDate, String zipCode, String documentId, Boolean administrator) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.zipCode = zipCode;
        this.documentId = documentId;
        this.administrator = administrator;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank(message = "This field cannot be empty. Please provide a valid value.") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "This field cannot be empty. Please provide a valid value.") String name) {
        this.name = name;
    }

    public @Email String getEmail() {
        return email;
    }

    public void setEmail(@Email String email) {
        this.email = email;
    }

    public @NotBlank @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*\\W).{8,}$", message = "Password must contain at least 8 characters, including uppercase, lowercase, number, and special character.") String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*\\W).{8,}$", message = "Password must contain at least 8 characters, including uppercase, lowercase, number, and special character.") String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getZipCode() {return zipCode;
    }
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public @NotNull String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(@NotNull String documentId) {
        this.documentId = documentId;
    }

    public Boolean getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Boolean administrator) {
        this.administrator = administrator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
