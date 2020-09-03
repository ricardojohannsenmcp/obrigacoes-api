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

import br.com.sistemaobrigacoes.modelo.Sistema;
import br.com.sistemaobrigacoes.repositorios.SistemaRepository;

@RestController
@RequestMapping("/sistemas")
public class SistemaResource {
	
	@Autowired
	private SistemaRepository sistemaRepository;
	
	@PostMapping
	public ResponseEntity<Sistema> salvar(@RequestBody Sistema sistema) {
		sistema =  sistemaRepository.save(sistema);
		return ResponseEntity.ok(sistema);
	}
	
	@GetMapping("/{sistemaId}")
	public ResponseEntity<Sistema> find(@PathVariable("sistemaId") Integer sistemaId){
		return ResponseEntity.ok(sistemaRepository.findById(sistemaId).orElse(null));
	}
	
	@GetMapping
	public ResponseEntity<List<Sistema>> lista(){
		List<Sistema> sistemas =  (List<Sistema>) sistemaRepository.findAll();
		return ResponseEntity.ok(sistemas);
	}

	
	@ResponseStatus(value=HttpStatus.OK)
	@DeleteMapping("/{sistemaId}")
	public void remover(@PathVariable("sistemaId") Integer sistemaId) {
		sistemaRepository.deleteById(sistemaId);
	}
	
	@ResponseStatus(value=HttpStatus.OK)
	@PutMapping("/{sistemaId}")
	public void atualizar(@PathVariable("sistemaId") Integer sistemaId,@RequestBody Sistema sistema) {
		Sistema sistemaToUpdate =  sistemaRepository.findById(sistemaId).orElse(null);
		BeanUtils.copyProperties(sistema, sistemaToUpdate, "sistemaId");
		sistemaRepository.save(sistemaToUpdate);
	}
	
}
