package br.com.sistemaobrigacoes.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="tipo_evento_processo")
@Data
public class TipoEventoProcesso {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="tipo_evento_processo_id")
	private Integer tipoEventoProcessoId;
	
	private String descricao;

}
