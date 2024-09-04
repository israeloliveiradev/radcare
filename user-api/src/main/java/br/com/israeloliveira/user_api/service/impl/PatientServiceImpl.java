package br.com.israeloliveira.user_api.service.impl;

import br.com.israeloliveira.user_api.domain.Patient;
import br.com.israeloliveira.user_api.repository.PatientRepository;
import br.com.israeloliveira.user_api.service.PatientService;
import br.com.israeloliveira.user_api.service.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    @Autowired
    PatientRepository patientRepository;

    private final Environment environment;

    @Override
    public Patient findById(Long id) {
        log.info("USER-SERVICE ::: Get request on {} port", environment.getProperty("local.server.port"));
        return patientRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object Not Found"));
    }

    @Override
    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    @Override
    public Patient createNewPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public void deletePatient(Long id) {
        if (!patientRepository.existsById(id)) {
            throw new ObjectNotFoundException("Object not found");
        }
        patientRepository.deleteById(id);
    }

    @Override
    public Patient updatePatient(Long id, Patient patient) {
        Patient patientToUpdate = patientRepository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Object not found"));

        patientToUpdate.setName(patient.getName());
        patientToUpdate.setEmail(patient.getEmail());
        patientToUpdate.setPassword(patient.getPassword());
        patientToUpdate.setGender(patient.getGender());
        patientToUpdate.setBirthDate(patient.getBirthDate());
        patientToUpdate.setPhoneNumber(patient.getPhoneNumber());
        patientToUpdate.setDocumentId(patient.getDocumentId());
        patientToUpdate.setZipCode(patient.getZipCode());

        return patientRepository.save(patientToUpdate);

    }

}

