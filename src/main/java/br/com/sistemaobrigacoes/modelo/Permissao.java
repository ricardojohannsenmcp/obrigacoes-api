package br.com.sistemaobrigacoes.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="permissao")
@Data
public class Permissao {
	
	@Id
	@Column(name="permissao_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer permissaoId;
	private String descricao;

}
