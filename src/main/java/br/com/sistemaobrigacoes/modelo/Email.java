package br.com.sistemaobrigacoes.modelo;

import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class Email {
	
	private String email;
	private boolean principal;

}
