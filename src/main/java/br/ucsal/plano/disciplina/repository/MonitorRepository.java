package br.ucsal.plano.disciplina.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import br.ucsal.plano.disciplina.dto.DisciplinaDTO;
import br.ucsal.plano.disciplina.dto.MonitorDTO;
import br.ucsal.plano.disciplina.dto.SemestreDTO;

@Repository
public interface MonitorRepository extends JpaRepository<MonitorDTO, Integer>, JpaSpecificationExecutor<MonitorDTO> {

	Optional<List<MonitorDTO>> findByDisciplinaId(DisciplinaDTO findByNome);

	Optional<List<MonitorDTO>> findBySemestre(SemestreDTO findByNome);
}
