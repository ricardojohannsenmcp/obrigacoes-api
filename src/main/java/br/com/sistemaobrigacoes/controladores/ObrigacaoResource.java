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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.sistemaobrigacoes.modelo.Frequencia;
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
	@GetMapping("/por/frequencia")
	public ResponseEntity<Iterable<Obrigacao>> listaPorFrequencia(@RequestParam("frequenciaId") Frequencia frequencia){
		return ResponseEntity.ok(obrigacaoRepository.findByFrequencia(frequencia));
	}

	@GetMapping("/{obrigacaoId}")
	public ResponseEntity<Obrigacao> find(@PathVariable("obrigacaoId") Integer obrigacaoId){
		return ResponseEntity.ok(obrigacaoRepository.findById(obrigacaoId).orElse(null));
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
