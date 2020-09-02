package br.com.sistemaobrigacoes.controladores;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.sistemaobrigacoes.modelo.Obrigacao;
import br.com.sistemaobrigacoes.repositorios.ObrigacaoRepository;

@RestController
@RequestMapping("/obrigacoes")
public class ObrigacaoResource {
	
	
	@Autowired
	private ObrigacaoRepository obrigacaoRepository;
	
	

	@GetMapping
	public ResponseEntity<Iterable<Obrigacao>> lista(){

		return ResponseEntity.ok(obrigacaoRepository.findAll());
	}

	@GetMapping("/{obrigacaoId}")
	public ResponseEntity<Obrigacao> find(@PathVariable("obrigacaoId") Integer obrigacaoId){

		return ResponseEntity.ok(obrigacaoRepository.findById(obrigacaoId).orElse(null));
	}
	

	
	@GetMapping("/{obrigacaoId}")
	public ResponseEntity<Obrigacao> editar(@PathVariable("obrigacaoId") Integer obrigacaoId) {
		Obrigacao obrigacao = obrigacaoRepository.findById(obrigacaoId).orElse(null);
		return ResponseEntity.ok(obrigacao);
	}
	
	
	
	
	@ResponseStatus(value=HttpStatus.OK)
	@DeleteMapping("/{obrigacaoId}")
	public void remover(@PathVariable("obrigacaoId") Integer obrigacaoId) {
		obrigacaoRepository.deleteById(obrigacaoId);
	}
	
	

	@ResponseStatus(value=HttpStatus.OK)
	@PutMapping("/{obrigacaoId}")
	public void atualizar(@PathVariable("obrigacaoId") Integer obrigacaoId,@RequestBody Obrigacao obrigacao) {
		Obrigacao obrigacaoToUpdate =  obrigacaoRepository.findById(obrigacaoId).orElse(null);
		BeanUtils.copyProperties(obrigacao, obrigacaoToUpdate, "obrigacaoId");
		obrigacaoRepository.save(obrigacaoToUpdate);
	}
	

}
