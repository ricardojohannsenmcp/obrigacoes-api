package br.com.sistemaobrigacoes.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="grupo_obrigacao")
@Data
public class GrupoObrigacao {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="grupo_obrigacao_id")
	private Integer grupoObrigacaoId;
	
	private String codigo;
	
	private String descricao;
	
	

}
