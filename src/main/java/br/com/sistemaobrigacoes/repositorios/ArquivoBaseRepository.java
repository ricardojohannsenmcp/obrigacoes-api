package br.com.sistemaobrigacoes.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import br.com.sistemaobrigacoes.modelo.Arquivo;

@NoRepositoryBean
public interface ArquivoBaseRepository<T extends Arquivo> extends CrudRepository<T, Integer>  {

}
