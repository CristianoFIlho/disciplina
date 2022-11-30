package br.ucsal.plano.disciplina.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import br.ucsal.plano.disciplina.dto.AssuntoDTO;
import br.ucsal.plano.disciplina.dto.DisciplinaDTO;
import br.ucsal.plano.disciplina.dto.SemestreDTO;

@Repository
public interface AssuntoRepository extends JpaRepository<AssuntoDTO, Integer>, JpaSpecificationExecutor<AssuntoDTO> {

	Optional<List<AssuntoDTO>> findByDisciplinaIdAndSemestreId(DisciplinaDTO disciplinaDTO, SemestreDTO semestreDTO);

	Optional<List<AssuntoDTO>> findByDisciplinaIdAndPeriodo(DisciplinaDTO disciplinaDTO, String periodoFormatado);

	Optional<List<AssuntoDTO>> findByDisciplinaIdAndDateAssunto(DisciplinaDTO disciplinaDTO, Date date);
}
