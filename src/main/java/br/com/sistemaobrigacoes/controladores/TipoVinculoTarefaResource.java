package br.com.sistemaobrigacoes.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sistemaobrigacoes.modelo.TipoVinculoTarefa;
import br.com.sistemaobrigacoes.repositorios.TipoVinculoTarefaRepository;

@RestController
@RequestMapping("/tiposVinculoTarefa")
public class TipoVinculoTarefaResource {

@Autowired	
private TipoVinculoTarefaRepository tipoVinculoTarefaRepository;

@GetMapping
private ResponseEntity<List<TipoVinculoTarefa>> buscar(){
	List<TipoVinculoTarefa> tipos = tipoVinculoTarefaRepository.findAll();
	return ResponseEntity.ok(tipos);
}	
	
}
