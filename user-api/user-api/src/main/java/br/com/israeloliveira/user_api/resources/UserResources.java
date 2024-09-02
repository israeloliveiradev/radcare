package br.com.israeloliveira.user_api.resources;


import br.com.israeloliveira.user_api.domain.Patient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

public interface UserResources {

    @GetMapping(value = "/{id}")
    ResponseEntity<Patient> findById(@PathVariable Long id);

    @GetMapping
    ResponseEntity<List<Patient>> findAll();
}

