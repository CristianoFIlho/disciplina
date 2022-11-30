package br.ucsal.plano.disciplina.controller;

import java.util.List;

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

import br.ucsal.plano.disciplina.dto.MonitorDTO;
import br.ucsal.plano.disciplina.request.RequestMonitorCreate;
import br.ucsal.plano.disciplina.request.RequestMonitorUpdate;
import br.ucsal.plano.disciplina.response.ResponseMonitor;
import br.ucsal.plano.disciplina.response.ResponseTodosMonitores;
import br.ucsal.plano.disciplina.service.MonitorService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Validated
@RestController
public class MonitorController {
	@Autowired
	private MonitorService monitorService;

	@GetMapping(path = "/monitores", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseTodosMonitores> getAllDisciplinas() {
		try {

			return ResponseEntity.ok().body(monitorService.getMonitores());
		} catch (Exception e) {
			log.error("{}", e);
			throw e;
		}
	}

	@GetMapping(path = "/monitores/disciplina", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<ResponseMonitor>> getMonitoresByDisciplina(@RequestParam String nome) {
		try {

			return ResponseEntity.ok().body(monitorService.getMonitoresByDisciplina(nome));
		} catch (Exception e) {
			log.error("{}", e);
			throw e;
		}
	}

	@GetMapping(path = "/monitores/semestre", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<ResponseMonitor>> getMonitoresBySemestre(@RequestParam String nome) {
		try {

			return ResponseEntity.ok().body(monitorService.getMonitoresBySemestre(nome));
		} catch (Exception e) {
			log.error("{}", e);
			throw e;
		}
	}

	@PostMapping(path = "/monitores/save", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<MonitorDTO> saveMonitor(@Valid @RequestBody RequestMonitorCreate requestMonitorCreate) {
		try {

			return ResponseEntity.ok().body(monitorService.saveMonitor(requestMonitorCreate));
		} catch (Exception e) {
			log.error("{}", e);
			throw e;
		}
	}

	@PutMapping(path = "/monitores/atualizar", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<MonitorDTO> updateMonitor(@Valid @RequestBody RequestMonitorUpdate requestMonitorUpdate) {
		try {

			return ResponseEntity.ok().body(monitorService.updateMonitor(requestMonitorUpdate));
		} catch (Exception e) {
			log.error("{}", e);
			throw e;
		}
	}

}
