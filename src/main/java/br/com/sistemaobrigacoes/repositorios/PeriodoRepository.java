package br.com.sistemaobrigacoes.repositorios;

import org.springframework.data.repository.CrudRepository;

import br.com.sistemaobrigacoes.modelo.Periodo;
import br.com.sistemaobrigacoes.modelo.Frequencia;
import java.util.List;

public interface PeriodoRepository extends CrudRepository<Periodo,Integer>{
	
	
	List<Periodo> findByFrequencia(Frequencia frequencia);

}
