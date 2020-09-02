package br.com.sistemaobrigacoes.modelo;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="arquivo_evento_processo")
@PrimaryKeyJoinColumn(name = "arquivo_id")
public class ArquivoEventoProcesso extends Arquivo {
	
	@ManyToOne(cascade= {CascadeType.REMOVE,CascadeType.PERSIST})
	@JoinColumn(name="evento_processo_id")
	private EventoProcesso eventoProcesso;

	public ArquivoEventoProcesso() {
	
	}
	
	public ArquivoEventoProcesso(EventoProcesso eventoProcesso,String nome, String descricao, Date dataEnvio, String extencao, String nomeOriginal,
			String contentType, long tamanho) {
		this.nome = nome;
		this.descricao = descricao;
		this.dataEnvio = dataEnvio;
		this.extencao = extencao;
		this.nomeOriginal = nomeOriginal;
		this.contentType = contentType;
		this.tamanho = tamanho;
		this.eventoProcesso =  eventoProcesso;
	}
	
}
