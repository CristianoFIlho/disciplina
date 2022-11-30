package br.ucsal.plano.disciplina.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ucsal.plano.disciplina.dto.MonitorDTO;
import br.ucsal.plano.disciplina.exception.NoSuchElementException;
import br.ucsal.plano.disciplina.repository.MonitorRepository;
import br.ucsal.plano.disciplina.request.RequestMonitorCreate;
import br.ucsal.plano.disciplina.request.RequestMonitorUpdate;
import br.ucsal.plano.disciplina.response.ResponseMonitor;
import br.ucsal.plano.disciplina.response.ResponseTodosMonitores;

@Service
public class MonitorService {
	@Autowired
	MonitorRepository monitorRepository;

	@Autowired
	DisciplinaService disciplinaService;

	@Autowired
	SemestreService semestreService;

	public static final String MONITOR = "MONITOR";

	public ResponseTodosMonitores getMonitores() {
		List<MonitorDTO> monitorDTOList = (List<MonitorDTO>) monitorRepository.findAll();
		ResponseTodosMonitores responseMonitores = ResponseTodosMonitores.builder()
				.monitoresList(
						monitorDTOList.stream().map(this::convertToResponseMonitores).collect(Collectors.toList()))
				.build();
		return responseMonitores;

	}

	private ResponseMonitor convertToResponseMonitores(MonitorDTO monitorDTO) {
		return ResponseMonitor.builder().id(monitorDTO.getId()).nome(monitorDTO.getNome()).build();
	}

	public List<ResponseMonitor> getMonitoresByDisciplina(String disciplina) {
		List<MonitorDTO> monitor = monitorRepository.findByDisciplinaId(disciplinaService.findByNome(disciplina))
				.orElseThrow(() -> new NoSuchElementException(MONITOR));
		return monitor.stream().map(this::convertToResponseMonitores).collect(Collectors.toList());
	}

	public List<ResponseMonitor> getMonitoresBySemestre(String semestre) {
		List<MonitorDTO> monitor = monitorRepository.findBySemestre(semestreService.findByNome(semestre))
				.orElseThrow(() -> new NoSuchElementException(MONITOR));
		return monitor.stream().map(this::convertToResponseMonitores).collect(Collectors.toList());
	}

	public MonitorDTO saveMonitor(RequestMonitorCreate requestMonitor) {
		MonitorDTO monitorDTO = new MonitorDTO();
		monitorDTO.setDisciplinaId(disciplinaService.findByNome(requestMonitor.getDisciplina()));
		monitorDTO.setSemestre(semestreService.findByNome(requestMonitor.getSemestre()));
		monitorDTO.setNome(requestMonitor.getNome());
		return monitorRepository.saveAndFlush(monitorDTO);
	}

	public MonitorDTO updateMonitor(RequestMonitorUpdate requestMonitor) {
		MonitorDTO monitorDTO = new MonitorDTO();
		monitorDTO.setId(requestMonitor.getId());
		monitorDTO.setDisciplinaId(disciplinaService.findByNome(requestMonitor.getDisciplina()));
		monitorDTO.setSemestre(semestreService.findByNome(requestMonitor.getSemestre()));
		monitorDTO.setNome(requestMonitor.getNome());
		return monitorRepository.saveAndFlush(monitorDTO);
	}
}
