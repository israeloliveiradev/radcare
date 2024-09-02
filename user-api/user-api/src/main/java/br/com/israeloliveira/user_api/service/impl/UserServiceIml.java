package br.com.israeloliveira.user_api.service.impl;

import br.com.israeloliveira.user_api.domain.Patient;
import br.com.israeloliveira.user_api.repository.UserRepository;
import br.com.israeloliveira.user_api.service.UserService;
import br.com.israeloliveira.user_api.service.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceIml implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public Patient findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object Not Found"));
    }

    @Override
    public List<Patient> findAll() {
        return userRepository.findAll();
    }
}
