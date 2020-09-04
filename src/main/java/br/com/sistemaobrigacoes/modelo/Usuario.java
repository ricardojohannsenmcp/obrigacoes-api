package br.com.sistemaobrigacoes.modelo;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Entity
@Table(name="usuario")
@Data
public class Usuario  implements UserDetails{
	
	
	private static final long serialVersionUID = 1L;

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
    @JoinColumn(name="pessoa_id")
	private Pessoa pessoa;
	
	private String login;
	
	private String senha;

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
