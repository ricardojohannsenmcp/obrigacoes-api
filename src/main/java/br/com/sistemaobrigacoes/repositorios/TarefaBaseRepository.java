package br.com.sistemaobrigacoes.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import br.com.sistemaobrigacoes.modelo.Tarefa;

@NoRepositoryBean
public interface TarefaBaseRepository <T extends Tarefa> extends JpaRepository<T,Integer> {

}
