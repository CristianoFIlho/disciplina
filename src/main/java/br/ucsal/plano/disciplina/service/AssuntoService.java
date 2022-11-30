package br.ucsal.plano.disciplina.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ucsal.plano.disciplina.constantes.ConstantesDisciplinas;
import br.ucsal.plano.disciplina.dto.AssuntoDTO;
import br.ucsal.plano.disciplina.dto.DisciplinaDTO;
import br.ucsal.plano.disciplina.dto.SemestreDTO;
import br.ucsal.plano.disciplina.exception.NoSuchElementException;
import br.ucsal.plano.disciplina.exception.ParseElementException;
import br.ucsal.plano.disciplina.repository.AssuntoRepository;
import br.ucsal.plano.disciplina.request.RequestAssuntoCreate;
import br.ucsal.plano.disciplina.request.RequestAssuntoUpdate;
import br.ucsal.plano.disciplina.response.ResponseAssunto;
import br.ucsal.plano.disciplina.response.ResponseAssuntoList;

@Service
public class AssuntoService {

	public static final String ASSUNTO = "ASSUNTO";

	@Autowired
	AssuntoRepository assuntoRepository;

	@Autowired
	SemestreService semestreService;

	@Autowired
	DisciplinaService disciplinaService;

	public ResponseAssuntoList getAssuntoByDisciplinaAndSemestre(String disciplina, String semestre) {
		SemestreDTO semestreDTO = semestreService.findByNome(semestre);
		DisciplinaDTO disciplinaDTO = disciplinaService.findByNome(disciplina);
		List<AssuntoDTO> assuntoList = assuntoRepository.findByDisciplinaIdAndSemestreId(disciplinaDTO, semestreDTO)
				.orElseThrow(() -> new NoSuchElementException(ASSUNTO));
		return ResponseAssuntoList.builder()
				.monitoresList(assuntoList.stream().map(this::convertToRequest).collect(Collectors.toList())).build();

	}

	private ResponseAssunto convertToRequest(AssuntoDTO assuntoDTO) {
		return ResponseAssunto.builder().dateAssunto(assuntoDTO.getDateAssunto()).id(assuntoDTO.getId())
				.nome(assuntoDTO.getNome()).periodo(assuntoDTO.getPeriodo()).build();
	}

	public ResponseAssuntoList getAssuntoByDisciplinaAndPeriodo(String disciplina, String periodo) {
		String periodoFormatado = null;
		for (int i = 0; i < ConstantesDisciplinas.Periodo.periodos.length; i++) {
			if (periodo != null && periodo.equalsIgnoreCase(ConstantesDisciplinas.Periodo.periodos[i])) {
				periodoFormatado = ConstantesDisciplinas.Periodo.periodos[i];
			}
		}
		if (periodoFormatado != null && !periodoFormatado.isBlank()) {
			DisciplinaDTO disciplinaDTO = disciplinaService.findByNome(disciplina);
			List<AssuntoDTO> assuntoList = assuntoRepository
					.findByDisciplinaIdAndPeriodo(disciplinaDTO, periodoFormatado)
					.orElseThrow(() -> new NoSuchElementException(ASSUNTO));
			return ResponseAssuntoList.builder()
					.monitoresList(assuntoList.stream().map(this::convertToRequest).collect(Collectors.toList()))
					.build();
		}
		throw new NoSuchElementException(ASSUNTO);

	}

	public ResponseAssuntoList getAssuntoByDisciplinaAndData(String disciplina, String dtAssunto) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		DisciplinaDTO disciplinaDTO = disciplinaService.findByNome(disciplina);
		List<AssuntoDTO> assuntoList;
		try {
			assuntoList = assuntoRepository.findByDisciplinaIdAndDateAssunto(disciplinaDTO, formatter.parse(dtAssunto))
					.orElseThrow(() -> new NoSuchElementException(ASSUNTO));
		} catch (ParseException e) {
			throw new ParseElementException(e.getMessage());
		}
		return ResponseAssuntoList.builder()
				.monitoresList(assuntoList.stream().map(this::convertToRequest).collect(Collectors.toList())).build();

	}

	public AssuntoDTO saveAssunto(RequestAssuntoCreate requestAssunto) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		AssuntoDTO assuntoDTO = new AssuntoDTO();
		assuntoDTO.setNome(requestAssunto.getNome());
		assuntoDTO.setDisciplinaId(disciplinaService.findByNome(requestAssunto.getDisciplina()));
		assuntoDTO.setSemestreId(semestreService.findByNome(requestAssunto.getSemestre()));
		try {
			assuntoDTO.setDateAssunto(formatter.parse(requestAssunto.getDateAssunto()));
		} catch (ParseException e) {
			throw new ParseElementException(e.getMessage());
		}
		String periodoFormatado = null;
		for (int i = 0; i < ConstantesDisciplinas.Periodo.periodos.length; i++) {
			if (requestAssunto.getPeriodo() != null
					&& requestAssunto.getPeriodo().equalsIgnoreCase(ConstantesDisciplinas.Periodo.periodos[i])) {
				periodoFormatado = ConstantesDisciplinas.Periodo.periodos[i];
			}
		}
		if (periodoFormatado != null && !periodoFormatado.isBlank()) {
			assuntoDTO.setPeriodo(periodoFormatado);
			return assuntoRepository.saveAndFlush(assuntoDTO);
		}
		throw new NoSuchElementException("PERIODO");

	}

	public AssuntoDTO updateAssunto(RequestAssuntoUpdate requestAssuntoUpdate) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		AssuntoDTO assuntoDTO = new AssuntoDTO();
		assuntoDTO.setId(requestAssuntoUpdate.getId());
		assuntoDTO.setNome(requestAssuntoUpdate.getNome());
		assuntoDTO.setDisciplinaId(disciplinaService.findByNome(requestAssuntoUpdate.getDisciplina()));
		assuntoDTO.setSemestreId(semestreService.findByNome(requestAssuntoUpdate.getSemestre()));
		try {
			assuntoDTO.setDateAssunto(formatter.parse(requestAssuntoUpdate.getDateAssunto()));
		} catch (ParseException e) {
			throw new ParseElementException(e.getMessage());
		}
		String periodoFormatado = null;
		for (int i = 0; i < ConstantesDisciplinas.Periodo.periodos.length; i++) {
			if (requestAssuntoUpdate.getPeriodo() != null
					&& requestAssuntoUpdate.getPeriodo().equalsIgnoreCase(ConstantesDisciplinas.Periodo.periodos[i])) {
				periodoFormatado = ConstantesDisciplinas.Periodo.periodos[i];
			}
		}
		if (periodoFormatado != null && !periodoFormatado.isBlank()) {
			assuntoDTO.setPeriodo(periodoFormatado);
			return assuntoRepository.saveAndFlush(assuntoDTO);
		}
		throw new NoSuchElementException("PERIODO");
	}

}
