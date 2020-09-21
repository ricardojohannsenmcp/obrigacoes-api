package br.com.sistemaobrigacoes.modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Table(name="remessa")
@Data
public class Remessa {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="remessa_id")
	private Integer remessaId;
	
	@ManyToOne
	@JoinColumn(name="ente_id")
	private Ente ente;

	@ManyToOne
	@JoinColumn(name="obrigacao_id")
	private Obrigacao obrigacao;

	@ManyToOne
	@JoinColumn(name="periodo_id")
	private Periodo periodo;

	private Integer exercicio;

	@Temporal(TemporalType.DATE)
	private Date prazo;



}
