package br.com.sistemaobrigacoes.repositorios;

import java.util.List;

import br.com.sistemaobrigacoes.modelo.Arquivo;
import br.com.sistemaobrigacoes.modelo.ArquivoEventoProcesso;

public interface ArquivoEventoProcessoRepository extends ArquivoBaseRepository<ArquivoEventoProcesso>{
	
	List<Arquivo> findByEventoProcesso_EventoProcessoId(Integer remessaId);

}
