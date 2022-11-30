package br.ucsal.plano.disciplina.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import br.ucsal.plano.disciplina.dto.DisciplinaDTO;

@Repository
public interface DisciplinaRepository
		extends JpaRepository<DisciplinaDTO, Integer>, JpaSpecificationExecutor<DisciplinaDTO> {

	Optional<DisciplinaDTO> findByNome(String nome);
}
