package br.com.israeloliveira.user_api.resources.impl;



import br.com.israeloliveira.user_api.domain.Patient;
import br.com.israeloliveira.user_api.resources.UserResources;
import br.com.israeloliveira.user_api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/patients")
public class UserResourcesImpl implements UserResources {


    @Autowired
    UserService userService;

    @Override
    public ResponseEntity<Patient> findById(Long id) {
        return ResponseEntity.ok().body(userService.findById(id));
    }

    @Override
    public ResponseEntity<List<Patient>> findAll() {
        return ResponseEntity.ok().body(userService.findAll());
    }
}
