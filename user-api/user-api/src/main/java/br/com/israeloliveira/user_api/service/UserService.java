package br.com.israeloliveira.user_api.service;


import br.com.israeloliveira.user_api.domain.Patient;

import java.util.List;
import java.util.UUID;


public interface UserService {

    Patient findById(Long id);
    List<Patient> findAll();
}
