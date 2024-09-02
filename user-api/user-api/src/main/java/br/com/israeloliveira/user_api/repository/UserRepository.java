package br.com.israeloliveira.user_api.repository;


import br.com.israeloliveira.user_api.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Patient, Long> {
}
