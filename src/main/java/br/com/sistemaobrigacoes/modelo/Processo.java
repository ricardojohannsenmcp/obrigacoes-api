package br.com.sistemaobrigacoes.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="processo")
@Data
public class Processo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="processo_id")
	private Integer processoId;
	
	private Integer numero;
	
	private Integer ano;
	
	
	private String unidade;
	
	private String relator;
	
	private String assunto;
	
	
	
	
	

}
