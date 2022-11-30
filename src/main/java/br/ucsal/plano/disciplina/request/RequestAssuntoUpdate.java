package br.ucsal.plano.disciplina.request;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class RequestAssuntoUpdate {

	@NotNull(message = "id não pode ser nulo")
	@JsonProperty("id")
	private Integer id;

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
