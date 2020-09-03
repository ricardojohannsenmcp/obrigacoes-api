package br.com.sistemaobrigacoes.repositorios;

import org.springframework.data.repository.CrudRepository;

import br.com.sistemaobrigacoes.modelo.Pessoa;

public interface PessoaRepository extends CrudRepository<Pessoa, Integer>{

}
