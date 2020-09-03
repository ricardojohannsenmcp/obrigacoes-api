package br.com.sistemaobrigacoes.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="tipo_vinculo_tarefa")
@Data
public class TipoVinculoTarefa {
	
	@Id
	@Column(name="tipo_vinculo_tarefa_id")
	private Integer tipoVinculoTarefaId;
	
	private String descricao;

}
