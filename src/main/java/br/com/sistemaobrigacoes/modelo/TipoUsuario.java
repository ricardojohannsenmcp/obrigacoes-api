package br.com.sistemaobrigacoes.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="tipo_usuario")
@Data
public class TipoUsuario {
	
	@Id
	@Column(name="tipo_usuario_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer tipoUsuarioId;
	
	private String nome;

}
