package br.ucsal.plano.disciplina.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ucsal.plano.disciplina.dto.DisciplinaDTO;
import br.ucsal.plano.disciplina.exception.NoSuchElementException;
import br.ucsal.plano.disciplina.repository.DisciplinaRepository;
import br.ucsal.plano.disciplina.request.RequestDisciplinaCreate;

@Service
public class DisciplinaService {
	@Autowired
	DisciplinaRepository disciplinaRepository;

	public static final String DISCIPLINA = "DISCIPLINA";

	public List<DisciplinaDTO> getDisciplina() {
		return (List<DisciplinaDTO>) disciplinaRepository.findAll();

	}

	public DisciplinaDTO findByNome(String nome) {
		return disciplinaRepository.findByNome(nome).orElseThrow(() -> new NoSuchElementException(DISCIPLINA));
	}

	public String createDisciplina(RequestDisciplinaCreate requestDisciplinaCreate) {
		String mensagem = "criado com sucesso!";
		try {
			DisciplinaDTO disciplinaDTO = new DisciplinaDTO();
			disciplinaDTO.setNome(requestDisciplinaCreate.getNome());
			disciplinaRepository.save(disciplinaDTO);
		} catch (Exception e) {
			mensagem = "Nao foi possivel criar essa Disciplina!";
		}

		return mensagem;
	}
}
