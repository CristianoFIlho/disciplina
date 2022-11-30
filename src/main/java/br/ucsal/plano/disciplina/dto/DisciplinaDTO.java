package br.ucsal.plano.disciplina.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "DISCIPLINA")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DisciplinaDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3502285466607563468L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "disciplina_id", unique = true, nullable = false)
	private Integer disciplinaId;

	@Column(name = "nome", nullable = false, length = 255)
	private String nome;
}
