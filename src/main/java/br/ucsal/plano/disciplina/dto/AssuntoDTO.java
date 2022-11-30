package br.ucsal.plano.disciplina.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "ASSUNTO")
@Data
public class AssuntoDTO {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "assunto_id", unique = true, nullable = false)
	private Integer id;

	@Column(name = "nome", nullable = false, length = 255)
	private String nome;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private SemestreDTO semestreId;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private DisciplinaDTO disciplinaId;

	@Column(name = "periodo", nullable = false, length = 255)
	private String periodo;

	@Column(name = "dt_assunto")
	private Date dateAssunto;

}
