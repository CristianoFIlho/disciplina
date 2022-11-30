package br.ucsal.plano.disciplina.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class RequestMonitorCreate {
	
	@JsonProperty("nome")
	private String nome;

	@JsonProperty("disciplina")
	private String disciplina;

	@JsonProperty("semestre")
	private String semestre;
}
