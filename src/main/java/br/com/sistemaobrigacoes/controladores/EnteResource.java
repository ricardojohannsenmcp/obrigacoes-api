package br.com.sistemaobrigacoes.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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




}
