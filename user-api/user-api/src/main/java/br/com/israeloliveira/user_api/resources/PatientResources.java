package br.com.israeloliveira.user_api.resources;


import br.com.israeloliveira.user_api.domain.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

public interface PatientResources {

    @PostMapping
    ResponseEntity<Patient> createPatient(@RequestBody Patient patient);

    @PutMapping(value = "/{id}")
    ResponseEntity<Patient> updatePatient(@PathVariable Long id, @RequestBody Patient patient);

    @GetMapping(value = "/{id}")
    ResponseEntity<Patient> findById(@PathVariable Long id);

    @GetMapping
    ResponseEntity<List<Patient>> findAll();

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    ResponseEntity<Void> deletePatient(@PathVariable Long id);
}





