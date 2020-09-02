package br.com.sistemaobrigacoes.modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name="arquivo_processo")
@PrimaryKeyJoinColumn(name = "arquivo_id")
public class ArquivoProcesso extends Arquivo{
	
@ManyToOne
@JoinColumn(name="processo_id")
private Processo processo;

public ArquivoProcesso(Processo processo,String nome, String descricao, Date dataEnvio, String extencao, String nomeOriginal,
		String contentType, long tamanho) {
	this.nome = nome;
	this.descricao = descricao;
	this.dataEnvio = dataEnvio;
	this.extencao = extencao;
	this.nomeOriginal = nomeOriginal;
	this.contentType = contentType;
	this.tamanho = tamanho;
	this.processo =  processo;
}

		
}
