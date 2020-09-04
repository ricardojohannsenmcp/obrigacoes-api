package br.com.sistemaobrigacoes.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

import lombok.Data;

@Entity
@Table(name="permissao")
@Data
public class Permissao implements GrantedAuthority{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="permissao_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer permissaoId;
	
	private String descricao;
	
	@Override
	public String getAuthority() {
		return descricao.toUpperCase();
	}

}
