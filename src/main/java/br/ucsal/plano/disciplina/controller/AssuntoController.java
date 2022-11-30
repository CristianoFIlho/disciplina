package br.ucsal.plano.disciplina.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.ucsal.plano.disciplina.dto.AssuntoDTO;
import br.ucsal.plano.disciplina.request.RequestAssuntoCreate;
import br.ucsal.plano.disciplina.request.RequestAssuntoUpdate;
import br.ucsal.plano.disciplina.response.ResponseAssuntoList;
import br.ucsal.plano.disciplina.service.AssuntoService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Validated
@RestController
public class AssuntoController {
	@Autowired
	private AssuntoService assuntoService;

	@GetMapping(path = "/assuntoByDisciplinaAndSemestre", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseAssuntoList> assuntoByDisciplinaAndSemestre(@RequestParam String disciplina,
			@RequestParam String semestre) {
		try {

			return ResponseEntity.ok().body(assuntoService.getAssuntoByDisciplinaAndSemestre(disciplina, semestre));
		} catch (Exception e) {
			log.error("{}", e);
			throw e;
		}
	}

	@GetMapping(path = "/assuntoByDisciplinaAndPeriodo", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseAssuntoList> assuntoByDisciplinaAndPeriodo(@RequestParam String disciplina,
			@RequestParam String periodo) {
		try {
			return ResponseEntity.ok().body(assuntoService.getAssuntoByDisciplinaAndPeriodo(disciplina, periodo));
		} catch (Exception e) {
			log.error("{}", e);
			throw e;
		}
	}

	@GetMapping(path = "/assuntoByDisciplinaAndData", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseAssuntoList> getAssuntoByDisciplinaAndData(@RequestParam String disciplina,
			@RequestParam String dataAssunto) {
		try {
			return ResponseEntity.ok().body(assuntoService.getAssuntoByDisciplinaAndData(disciplina, dataAssunto));
		} catch (Exception e) {
			log.error("{}", e);
			throw e;
		}
	}

	@PostMapping(path = "/assunto/save", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<AssuntoDTO> saveAssunto(@Valid @RequestBody RequestAssuntoCreate requestAssuntoCreate) {
		try {
			return ResponseEntity.ok().body(assuntoService.saveAssunto(requestAssuntoCreate));
		} catch (Exception e) {
			log.error("{}", e);
			throw e;
		}
	}

	@PutMapping(path = "/assunto/atualizar", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<AssuntoDTO> updateAssunto(@Valid @RequestBody RequestAssuntoUpdate requestAssuntoUpdate) {
		try {

			return ResponseEntity.ok().body(assuntoService.updateAssunto(requestAssuntoUpdate));
		} catch (Exception e) {
			log.error("{}", e);
			throw e;
		}
	}
}
