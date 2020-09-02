package br.com.sistemaobrigacoes.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sistemaobrigacoes.modelo.GrupoObrigacao;
import br.com.sistemaobrigacoes.repositorios.GrupoObrigacaoRepository;

@RestController
@RequestMapping("/gruposObrigacao")
public class GrupoObrigacaoResource {

	@Autowired
	private GrupoObrigacaoRepository grupoObrigacaoRepository;

	@GetMapping
	public ResponseEntity<Iterable<GrupoObrigacao>> lista(){

		return ResponseEntity.ok(grupoObrigacaoRepository.findAll());
	}

	@GetMapping("/{grupoObrigacaoId}")
	public ResponseEntity<GrupoObrigacao> find(@PathVariable("grupoObrigacaoId") Integer grupoObrigacaoId){

		return ResponseEntity.ok(grupoObrigacaoRepository.findById(grupoObrigacaoId).orElse(null));
	}




}
