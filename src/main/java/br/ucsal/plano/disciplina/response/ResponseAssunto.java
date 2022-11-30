package br.ucsal.plano.disciplina.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseAssunto {
	@JsonProperty("id")
	private Integer id;

	@JsonProperty("nome")
	private String nome;

	@JsonProperty("periodo")
	private String periodo;

	@JsonProperty("dt_assunto")
	private Date dateAssunto;

}
