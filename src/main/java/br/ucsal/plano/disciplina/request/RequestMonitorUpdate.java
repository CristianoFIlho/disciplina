package br.ucsal.plano.disciplina.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class RequestMonitorUpdate {

	@NotNull(message = "id não pode ser nulo")
	@JsonProperty("id")
	private Integer id;

	@JsonProperty("nome")
	private String nome;

	@JsonProperty("disciplina")
	private String disciplina;

	@JsonProperty("semestre")
	private String semestre;
}
