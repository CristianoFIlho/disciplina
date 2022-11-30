package br.ucsal.plano.disciplina.dto;

import java.io.Serializable;

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
@Table(name = "MONITOR")
@Data
public class MonitorDTO implements Serializable {

	private static final long serialVersionUID = 3199569625518606903L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;

	@Column(name = "nome", nullable = false, length = 255)
	private String nome;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private SemestreDTO semestre;

	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private DisciplinaDTO disciplinaId;

}
