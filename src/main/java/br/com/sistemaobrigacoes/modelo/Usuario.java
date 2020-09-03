package br.com.sistemaobrigacoes.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="usuario")
@Data
public class Usuario {
	
	@Id
	@Column(name="usuario_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer usuarioId;
	
	@ManyToOne
	@JoinColumn(name="tipo_usuario_id")
	private GrupoUsuario tipoUsuario;
	
	@ManyToOne
	@JoinColumn(name="ente")
	private Ente ente;
	
    @OneToOne
    @JoinColumn(name="pessoa")
	private Pessoa pessoa;
	
	private String login;
	
	private String senha;

}
