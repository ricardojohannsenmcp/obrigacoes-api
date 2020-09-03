package br.com.sistemaobrigacoes.modelo;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="tarefa_evento_processo")
@PrimaryKeyJoinColumn(name = "tarefa_id")
public class TarefaProcesso extends Tarefa{
	
	@Getter @Setter
	@ManyToOne
	@JoinColumn(name="processo_id")
	private Processo processo;

}
