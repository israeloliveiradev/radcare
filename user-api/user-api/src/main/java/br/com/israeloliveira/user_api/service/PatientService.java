package br.com.israeloliveira.user_api.service;


import br.com.israeloliveira.user_api.domain.Patient;

import java.util.List;


public interface PatientService {

    Patient findById(Long id);
    List<Patient> findAll();
    Patient createNewPatient(Patient patient);
    void deletePatient(Long id);
    Patient updatePatient(Long id, Patient patient);
}
