package br.com.israeloliveira.ms_user.input;

import com.israeloliveiradev.dtos.userDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

public interface userResources {

    @PostMapping
    ResponseEntity<userDTO> createuser(@RequestBody userDTO userDTO);

    @PutMapping(value = "/{id}")
    ResponseEntity<userDTO> updateuser(@PathVariable Long id, @RequestBody userDTO userDTO);

    @GetMapping(value = "/{id}")
    ResponseEntity<userDTO> findById(@PathVariable Long id);

    @GetMapping
    ResponseEntity<List<userDTO>> findAll();

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    ResponseEntity<Void> deleteuser(@PathVariable Long id);
}

