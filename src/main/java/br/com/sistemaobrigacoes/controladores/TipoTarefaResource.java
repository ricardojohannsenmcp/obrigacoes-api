package br.com.sistemaobrigacoes.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sistemaobrigacoes.modelo.TipoTarefa;
import br.com.sistemaobrigacoes.repositorios.TipoTarefaRepository;

@RestController
@RequestMapping("/tiposTarefa")
public class TipoTarefaResource {

@Autowired	
private TipoTarefaRepository tipoTarefaRepository;

@GetMapping
private ResponseEntity<List<TipoTarefa>> buscar(){
	List<TipoTarefa> tipos = tipoTarefaRepository.findAll();
	return ResponseEntity.ok(tipos);
}	
	
}
