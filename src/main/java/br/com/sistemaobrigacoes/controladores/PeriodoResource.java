package br.com.sistemaobrigacoes.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sistemaobrigacoes.modelo.Periodo;
import br.com.sistemaobrigacoes.repositorios.PeriodoRepository;

@RestController
@RequestMapping("/periodos")
public class PeriodoResource {

	@Autowired
	private PeriodoRepository periodoRepository;

	@GetMapping
	public ResponseEntity<Iterable<Periodo>> lista(){

		return ResponseEntity.ok(periodoRepository.findAll());
	}

	@GetMapping("/{periodoId}")
	public ResponseEntity<Periodo> find(@PathVariable("periodoId") Integer periodoId){

		return ResponseEntity.ok(periodoRepository.findById(periodoId).orElse(null));
	}




}
