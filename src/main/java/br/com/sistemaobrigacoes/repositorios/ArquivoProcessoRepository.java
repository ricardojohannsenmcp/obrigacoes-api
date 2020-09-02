package br.com.sistemaobrigacoes.repositorios;

import java.util.List;

import br.com.sistemaobrigacoes.modelo.Arquivo;
import br.com.sistemaobrigacoes.modelo.ArquivoProcesso;

public interface ArquivoProcessoRepository extends ArquivoBaseRepository<ArquivoProcesso> {
	
	List<Arquivo> findByProcesso_ProcessoId(Integer remessaId);

}
