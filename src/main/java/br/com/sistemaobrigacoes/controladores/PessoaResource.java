package br.com.sistemaobrigacoes.controladores;


import java.util.List;

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

import br.com.sistemaobrigacoes.modelo.Pessoa;
import br.com.sistemaobrigacoes.repositorios.PessoaRepository;



@RestController
@RequestMapping("/pessoas")
public class PessoaResource {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@PostMapping
	public ResponseEntity<Pessoa> salvar(@RequestBody Pessoa pessoa) {
		pessoa =  pessoaRepository.save(pessoa);
		return ResponseEntity.ok(pessoa);
	}
	
	@GetMapping("/{pessoaId}")
	public ResponseEntity<Pessoa> find(@PathVariable("pessoaId") Integer pessoaId){
		return ResponseEntity.ok(pessoaRepository.findById(pessoaId).orElse(null));
	}
	
	@GetMapping
	public ResponseEntity<List<Pessoa>> lista(){
		List<Pessoa> pessoas =  (List<Pessoa>) pessoaRepository.findAll();
		return ResponseEntity.ok(pessoas);
	}

	
	@ResponseStatus(value=HttpStatus.OK)
	@DeleteMapping("/{pessoaId}")
	public void remover(@PathVariable("pessoaId") Integer pessoaId) {
		pessoaRepository.deleteById(pessoaId);
	}
	
	@ResponseStatus(value=HttpStatus.OK)
	@PutMapping("/{pessoaId}")
	public void atualizar(@PathVariable("pessoaId") Integer pessoaId,@RequestBody Pessoa pessoa) {
		Pessoa pessoaToUpdate =  pessoaRepository.findById(pessoaId).orElse(null);
		BeanUtils.copyProperties(pessoa, pessoaToUpdate, "pessoaId");
		pessoaRepository.save(pessoaToUpdate);
	}
	
}
