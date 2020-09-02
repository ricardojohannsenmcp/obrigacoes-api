package br.com.sistemaobrigacoes.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="ente")
@Data
public class Ente {
	
	@Id
	@Column(name="ente_id")
	private Integer enteId;
	private String nome;

}
