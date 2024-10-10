package br.com.israeloliveira.ms_user.output.persistence;

import com.israeloliveiradev.core.domain.user;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepository extends JpaRepository<user, Long> {
}
