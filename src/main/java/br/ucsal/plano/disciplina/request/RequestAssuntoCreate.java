package br.ucsal.plano.disciplina.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class RequestAssuntoCreate {

	@JsonProperty("nome")
	private String nome;

	@JsonProperty("semestre")
	private String semestre;

	@JsonProperty("disciplina")
	private String disciplina;

	@JsonProperty("periodo")
	private String periodo;

	@JsonProperty("dateAssunto")
	private String dateAssunto;
}
