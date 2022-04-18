package br.com.zup.edu.nossosistemadebares.bar;

import java.util.Optional;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

public interface MesaRepository extends JpaRepository<Mesa,Long> {
	@Lock(LockModeType.PESSIMISTIC_WRITE)
	Optional<Mesa> findById(Long id);
}
