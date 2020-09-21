package br.com.sistemaobrigacoes.repositorios;

import org.springframework.data.repository.CrudRepository;

import br.com.sistemaobrigacoes.modelo.Obrigacao;
import br.com.sistemaobrigacoes.modelo.Frequencia;
import java.util.List;

public interface ObrigacaoRepository extends CrudRepository<Obrigacao, Integer>{
	

	List<Obrigacao> findByFrequencia(Frequencia frequencia);
}
