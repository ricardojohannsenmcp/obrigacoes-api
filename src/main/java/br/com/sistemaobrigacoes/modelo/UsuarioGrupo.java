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
@Table(name="usuario_grupo")
@Data
public class UsuarioGrupo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="usuario_grupo_id")
	private Integer usuarioGrupoId;
	
	@ManyToOne
	@JoinColumn(name= "usuario_id")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name= "usuario_id")
	private GrupoUsuario grupoUsuario;
	
	@ManyToOne
	@JoinColumn(name= "ente_id")
	private Ente ente;
	
	private boolean inativo;

}
