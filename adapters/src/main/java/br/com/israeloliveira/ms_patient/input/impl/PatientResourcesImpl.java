package br.com.israeloliveira.ms_user.input.impl;

import br.com.israeloliveira.ms_user.input.userResources;
import com.israeloliveiradev.dtos.userDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/users")
public class userResourcesImpl implements userResources {



    @Override
    public ResponseEntity<userDTO> createuser(userDTO userDTO) {
        return null;
    }

    @Override
    public ResponseEntity<userDTO> updateuser(Long id, userDTO userDTO) {
        return null;
    }

    @Override
    public ResponseEntity<userDTO> findById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<List<userDTO>> findAll() {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteuser(Long id) {
        return null;
    }
}
