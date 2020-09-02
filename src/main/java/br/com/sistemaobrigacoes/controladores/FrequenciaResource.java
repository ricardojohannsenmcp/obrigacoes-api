package br.com.sistemaobrigacoes.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sistemaobrigacoes.modelo.Frequencia;
import br.com.sistemaobrigacoes.repositorios.FrequenciaRepository;

@RestController
@RequestMapping("/frequencias")
public class FrequenciaResource {

	@Autowired
	private FrequenciaRepository frequenciaRepository;

	@GetMapping
	public ResponseEntity<Iterable<Frequencia>> lista(){

		return ResponseEntity.ok(frequenciaRepository.findAll());
	}

	@GetMapping("/{frequenciaId}")
	public ResponseEntity<Frequencia> find(@PathVariable("frequenciaId") Integer frequenciaId){

		return ResponseEntity.ok(frequenciaRepository.findById(frequenciaId).orElse(null));
	}




}
