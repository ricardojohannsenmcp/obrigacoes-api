package br.com.sistemaobrigacoes.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="obrigacao")
@Data
public class Obrigacao {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="obrigacao_id")
	private Integer obrigacaoId;
	
	@ManyToOne
	@JoinColumn(name="grupo_obrigacao_id")
	private GrupoObrigacao grupoObrigacao;
	
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name="sistema_id")
	private Sistema sistema;
	
	@ManyToOne
	@JoinColumn(name="frequencia_id")
	private Frequencia frequencia;

}
