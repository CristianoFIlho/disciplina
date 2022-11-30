package br.ucsal.plano.disciplina.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseMonitor {
	@JsonProperty("id")
	private Integer id;

	@JsonProperty("nome")
	private String nome;
}
