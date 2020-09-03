package br.com.sistemaobrigacoes.modelo;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import lombok.Data;

@Embeddable
@Data
public class Telefone {
	
	
	
	private String numero;
	private boolean principal;
	@Enumerated(EnumType.STRING)
	private TipoTelefone tipoTelefone;
	

}
