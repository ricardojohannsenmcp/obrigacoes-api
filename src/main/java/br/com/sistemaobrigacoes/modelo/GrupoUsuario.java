package br.com.sistemaobrigacoes.modelo;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="grupo_usuario")
@Data
public class GrupoUsuario {
	
	@Id
	@Column(name="grupo_usuario_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer grupoUsuarioId;
	
	private String nome;
	
	@ManyToMany
	@JoinTable(name="grupo_permissao",joinColumns= @JoinColumn(name="grupo_usuario_id"),
	inverseJoinColumns=@JoinColumn(name="permissao_id"))
	private Set<Permissao> permissoes;

}
