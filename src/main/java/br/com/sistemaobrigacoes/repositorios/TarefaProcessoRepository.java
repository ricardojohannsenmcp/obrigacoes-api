package br.com.sistemaobrigacoes.repositorios;

import java.util.List;

import br.com.sistemaobrigacoes.modelo.Tarefa;
import br.com.sistemaobrigacoes.modelo.TarefaProcesso;

public interface TarefaProcessoRepository extends TarefaBaseRepository<TarefaProcesso>{
	
	List<Tarefa> findByProcesso_ProcessoId(Integer processoId);

}
