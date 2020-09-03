package br.com.sistemaobrigacoes.repositorios;

import java.util.List;

import br.com.sistemaobrigacoes.modelo.Arquivo;
import br.com.sistemaobrigacoes.modelo.ArquivoTarefa;

public interface ArquivoTarefaRepository extends ArquivoBaseRepository<ArquivoTarefa> {
	
	List<Arquivo> findByTarefa_TarefaId(Integer tarefaId);

}
