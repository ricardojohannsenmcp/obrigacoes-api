package br.com.sistemaobrigacoes.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sistemaobrigacoes.modelo.TipoTarefa;

public interface TipoTarefaRepository extends JpaRepository<TipoTarefa, Integer> {

}
