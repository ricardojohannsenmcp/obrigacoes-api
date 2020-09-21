package br.com.sistemaobrigacoes.controladores;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.sistemaobrigacoes.modelo.Ente;
import br.com.sistemaobrigacoes.repositorios.EnteRepository;

@RestController
@RequestMapping("/entes")
public class EnteResource {

	@Autowired
	private EnteRepository enteRepository;

	@GetMapping
	public ResponseEntity<Iterable<Ente>> lista(){
		return ResponseEntity.ok(enteRepository.findAll());
	}

	@GetMapping("/{enteId}")
	public ResponseEntity<Ente> find(@PathVariable("enteId") Integer enteId){
		return ResponseEntity.ok(enteRepository.findById(enteId).orElse(null));
	}
	
	
	@PostMapping
	public ResponseEntity<Ente> salvar(@RequestBody Ente ente) {
		ente =  enteRepository.save(ente);
		return ResponseEntity.ok(ente);
	}
	
	@ResponseStatus(value=HttpStatus.OK)
	@DeleteMapping("/{enteId}")
	public void remover(@PathVariable("enteId") Integer enteId) {
		enteRepository.deleteById(enteId);
	}
	
	@ResponseStatus(value=HttpStatus.OK)
	@PutMapping("/{enteId}")
	public void atualizar(@PathVariable("enteId") Integer enteId,@RequestBody Ente ente) {
		Ente enteToUpdate =  enteRepository.findById(enteId).orElse(null);
		BeanUtils.copyProperties(ente, enteToUpdate, "enteId");
		enteRepository.save(enteToUpdate);
	}



}
