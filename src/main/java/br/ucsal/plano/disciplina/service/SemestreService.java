package br.ucsal.plano.disciplina.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ucsal.plano.disciplina.dto.SemestreDTO;
import br.ucsal.plano.disciplina.exception.NoSuchElementException;
import br.ucsal.plano.disciplina.repository.SemestreRepository;

@Service
public class SemestreService {
	@Autowired
	SemestreRepository semestreRepository;

	public static final String SEMESTRE = "SEMESTRE";

	public List<SemestreDTO> getDisciplina() {
		return (List<SemestreDTO>) semestreRepository.findAll();

	}

	public SemestreDTO findByNome(String nome) {
		return semestreRepository.findByNome(nome).orElseThrow(() -> new NoSuchElementException(SEMESTRE));
	}

}
