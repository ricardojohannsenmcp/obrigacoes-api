package br.com.sistemaobrigacoes.modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="arquivo")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@EqualsAndHashCode
public class Arquivo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="arquivo_id")
	protected Integer arquivoId;
	
	protected String nome;
	
	protected String descricao;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_envio")
	protected Date dataEnvio;
	
	protected String extencao;
	
	protected String nomeOriginal;
	
	@Column(name="content_type")
	protected String contentType;
	
	protected long tamanho;
	
	public Arquivo() {
	}


	
}
