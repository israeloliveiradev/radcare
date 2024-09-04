package br.com.israeloliveira.user_api.resources.impl;



import br.com.israeloliveira.user_api.domain.Patient;
import br.com.israeloliveira.user_api.resources.PatientResources;
import br.com.israeloliveira.user_api.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/patients")
public class PatientResourcesImpl implements PatientResources {



    private final PatientService patientService;

    @Override
    public ResponseEntity<Patient> createPatient(@RequestBody Patient patient) {
        Patient createdPatient = patientService.createNewPatient(patient);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPatient);
    }

    @Override
    public ResponseEntity<Patient> updatePatient(Long id, Patient patient) {
        return ResponseEntity.ok().body(patientService.updatePatient(id, patient));
    }

    @Override
    public ResponseEntity<Patient> findById(Long id) {
        return ResponseEntity.ok().body(patientService.findById(id));
    }

    @Override
    public ResponseEntity<List<Patient>> findAll() {
        return ResponseEntity.ok().body(patientService.findAll());
    }

    @Override
    public ResponseEntity<Void> deletePatient(Long id) {
        patientService.deletePatient(id);
        return ResponseEntity.noContent().build();
    }


}
