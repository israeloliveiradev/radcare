package br.com.israeloliveira.user_api.service.impl;

import br.com.israeloliveira.user_api.domain.Patient;
import br.com.israeloliveira.user_api.repository.PatientRepository;
import br.com.israeloliveira.user_api.service.PatientService;
import br.com.israeloliveira.user_api.service.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    @Autowired
    PatientRepository userRepository;

    @Override
    public Patient findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object Not Found"));
    }

    @Override
    public List<Patient> findAll() {
        return userRepository.findAll();
    }
}
