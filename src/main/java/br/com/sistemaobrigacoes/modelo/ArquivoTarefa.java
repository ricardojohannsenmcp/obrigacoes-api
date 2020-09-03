package br.com.sistemaobrigacoes.modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name="arquivo_tarefa")
@PrimaryKeyJoinColumn(name = "arquivo_id")
public class ArquivoTarefa extends Arquivo{
	
@ManyToOne
@JoinColumn(name="tarefa_id")
private Tarefa tarefa;

public ArquivoTarefa(Tarefa tarefa,String nome, String descricao, Date dataEnvio, String extencao, String nomeOriginal,
		String contentType, long tamanho) {
	this.nome = nome;
	this.descricao = descricao;
	this.dataEnvio = dataEnvio;
	this.extencao = extencao;
	this.nomeOriginal = nomeOriginal;
	this.contentType = contentType;
	this.tamanho = tamanho;
	this.tarefa = tarefa;
}

		
}
