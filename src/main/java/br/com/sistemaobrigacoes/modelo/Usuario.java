package br.com.sistemaobrigacoes.modelo;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedSubgraph;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@NamedEntityGraph(
		  name = "grafo-usuario-com-grupos",
		  attributeNodes = {
				  @NamedAttributeNode("pessoa"),
		    @NamedAttributeNode(value = "usuarioGrupos", subgraph = "usuariogrupo-subgrafo")
		  },
		  subgraphs = {
		    @NamedSubgraph(
		      name = "usuariogrupo-subgrafo",
		      attributeNodes = {
		        @NamedAttributeNode("ente"),
		        @NamedAttributeNode("grupoUsuario")
		      }
		    )
		  }
		)

@Entity
@Table(name="usuario")
@Data
public class Usuario  implements UserDetails{
	
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="usuario_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer usuarioId;

    @OneToOne
    @JoinColumn(name="pessoa_id")
	private Pessoa pessoa;
	
	private String login;
	
	@JsonIgnore
	private String senha;
	
	@JsonIgnore
	@OneToMany(mappedBy="usuario",cascade=CascadeType.REMOVE,orphanRemoval=true)
	private Collection<UsuarioGrupo> usuarioGrupos;

	@JsonIgnore
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPassword() {
		return this.senha;
	}

	@Override
	public String getUsername() {
		return this.pessoa.getNome();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
