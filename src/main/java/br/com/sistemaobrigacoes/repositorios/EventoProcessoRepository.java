package br.com.sistemaobrigacoes.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sistemaobrigacoes.modelo.EventoProcesso;

public interface EventoProcessoRepository extends JpaRepository<EventoProcesso, Integer>{
	
	//@EntityGraph(value = "EventoProcesso.eventos", type = EntityGraphType.LOAD)
	List<EventoProcesso> findByProcesso_ProcessoId(Integer processoId);

	List<EventoProcesso> findByEventoProcesso_EventoProcessoId(Integer eventoProcessoId);

}
