package br.com.sistemaobrigacoes.modelo;

import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="pessoa")
@Data
public class Pessoa {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="pessoa_id")
	private Integer pessoaId;
	
	private String nome;
	
    @ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(name = "pessoa_telefone", joinColumns = @JoinColumn(name = "pessoa_id"))
	private Set<Telefone> telefones;
	
	
    @ElementCollection(fetch = FetchType.LAZY)
   	@CollectionTable(name = "pessoa_email", joinColumns = @JoinColumn(name = "pessoa_id"))
   	private Set<Email> emails;
	
	


}
