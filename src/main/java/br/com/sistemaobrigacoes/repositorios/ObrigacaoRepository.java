package br.com.sistemaobrigacoes.repositorios;

import org.springframework.data.repository.CrudRepository;

import br.com.sistemaobrigacoes.modelo.Obrigacao;

public interface ObrigacaoRepository extends CrudRepository<Obrigacao, Integer>{
	

}
