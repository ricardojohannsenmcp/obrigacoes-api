package br.com.sistemaobrigacoes.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="especie")
@Data
public class Especie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer especieId;
	
	private String nome;

}
