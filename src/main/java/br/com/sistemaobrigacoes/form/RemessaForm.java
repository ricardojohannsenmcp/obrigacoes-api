package br.com.sistemaobrigacoes.form;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import br.com.sistemaobrigacoes.modelo.Obrigacao;
import br.com.sistemaobrigacoes.modelo.Periodo;
import lombok.Data;

@Data
public class RemessaForm {
	
    @NotNull
	private Obrigacao obrigacao;
	
    @NotNull
	private Integer exercicio;
	
    @NotNull
    @Past
	private Date data;
	
    @NotNull
	private Periodo periodo;

}
