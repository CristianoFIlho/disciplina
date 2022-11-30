package br.ucsal.plano.disciplina.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import br.ucsal.plano.disciplina.dto.SemestreDTO;

@Repository
public interface SemestreRepository extends JpaRepository<SemestreDTO, Integer>, JpaSpecificationExecutor<SemestreDTO> {

	Optional<SemestreDTO> findByNome(String nome);
}
