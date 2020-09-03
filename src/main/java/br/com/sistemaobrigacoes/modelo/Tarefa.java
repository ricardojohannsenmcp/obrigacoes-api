package br.com.sistemaobrigacoes.modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Table(name="tarefa")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
public class Tarefa {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer tarefaId;
	
	@ManyToOne
	@JoinColumn(name="tipo_tarefa_id")
	private TipoTarefa tipoTarefa;
	
	@ManyToOne
	@JoinColumn(name="tipo_vinculo_tarefa_id")
	private TipoVinculoTarefa tipoVinculoTarefa;
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_base")
	private Date dataBase;
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_prevista")
	private Date dataPrevista;
	
	@Temporal(TemporalType.TIME)
	@Column(name="hora_prevista")
	private Date horaPrevista;
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_fatal")
	private Date dataFatal;
	
	@Temporal(TemporalType.TIME)
	@Column(name="hora_fatal")
	private Date horaFatal;
	
	private String descricao;
	
	@Enumerated(EnumType.STRING)
	private SituacaoTarefa situacao;
	
	
	//responsavel
	

}
