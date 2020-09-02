package br.com.sistemaobrigacoes.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.sistemaobrigacoes.modelo.Arquivo;
import br.com.sistemaobrigacoes.modelo.ArquivoRemessa;

public interface ArquivoRemessaRepository extends CrudRepository<ArquivoRemessa, Integer>{
	
	List<Arquivo> findByRemessa_RemessaId(Integer remessaId);

}
