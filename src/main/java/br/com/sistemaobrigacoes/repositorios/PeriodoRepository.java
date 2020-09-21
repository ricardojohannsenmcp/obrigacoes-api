package br.com.sistemaobrigacoes.repositorios;

import org.springframework.data.repository.CrudRepository;

import br.com.sistemaobrigacoes.modelo.Periodo;

public interface PeriodoRepository extends CrudRepository<Periodo,Integer>{

    @Query("SELECT * FROM Periodo WHERE frequencia.frenquenciaId := frequenciaId")
    public List<Periodo> findByFrequenciaId(Integer frequenciaId);

}
