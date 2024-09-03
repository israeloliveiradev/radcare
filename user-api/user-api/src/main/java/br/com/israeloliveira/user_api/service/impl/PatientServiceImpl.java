package br.com.israeloliveira.user_api.service.impl;

import br.com.israeloliveira.user_api.domain.Patient;
import br.com.israeloliveira.user_api.repository.PatientRepository;
import br.com.israeloliveira.user_api.service.PatientService;
import br.com.israeloliveira.user_api.service.exceptions.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    @Autowired
    PatientRepository patientRepository;

    @Override
    public Patient findById(Long id) {
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
        Patient patientToUpdate = patientRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Object not found"));


        if (patient.getName() != null) {
            patientToUpdate.setName(patient.getName());
        }
        if (patient.getEmail() != null) {
            patientToUpdate.setEmail(patient.getEmail());
        }
        if (patient.getPassword() != null) {
            patientToUpdate.setPassword(patient.getPassword());
        }
        if (patient.getGender() != null) {
            patientToUpdate.setGender(patient.getGender());
        }
        if (patient.getBirthDate() != null) {
            patientToUpdate.setBirthDate(patient.getBirthDate());
        }
        if (patient.getPhoneNumber() != null) {
            patientToUpdate.setPhoneNumber(patient.getPhoneNumber());
        }
        if (patient.getDocumentId() != null) {
            patientToUpdate.setDocumentId(patient.getDocumentId());
        }
        if (patient.getZipCode() != null) {
            patientToUpdate.setZipCode(patient.getZipCode());
        }

        return patientRepository.save(patientToUpdate);
    }

}

