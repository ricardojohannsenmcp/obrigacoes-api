package br.com.sistemaobrigacoes.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="periodo")
@Data
public class Periodo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="periodo_id")
	private Integer periodoId;
	
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name="frequencia_id")
	private Frequencia frequencia;

}
