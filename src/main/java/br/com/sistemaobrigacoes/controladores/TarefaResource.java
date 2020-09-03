package br.com.sistemaobrigacoes.controladores;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.sistemaobrigacoes.modelo.Arquivo;
import br.com.sistemaobrigacoes.modelo.ArquivoTarefa;
import br.com.sistemaobrigacoes.modelo.Tarefa;
import br.com.sistemaobrigacoes.repositorios.ArquivoTarefaRepository;
import br.com.sistemaobrigacoes.repositorios.TarefaRepository;

@RestController
@RequestMapping("/tarefas")
public class TarefaResource {
	
	@Autowired
	private TarefaRepository tarefaRepository;
	
	@Autowired
	private ArquivoTarefaRepository arquivoTarefaRepository;
	
	@PostMapping
	public ResponseEntity<Tarefa> salvar(@RequestBody Tarefa tarefa) {
		tarefa =  tarefaRepository.save(tarefa);
		return ResponseEntity.ok(tarefa);
	}
	
	@GetMapping("/{tarefaId}")
	public ResponseEntity<Tarefa> find(@PathVariable("tarefaId") Integer tarefaId){
		return ResponseEntity.ok(tarefaRepository.findById(tarefaId).orElse(null));
	}
	
	@GetMapping
	public ResponseEntity<List<Tarefa>> lista(){
		List<Tarefa> tarefas =  (List<Tarefa>) tarefaRepository.findAll();
		return ResponseEntity.ok(tarefas);
	}
	
	@ResponseStatus(value=HttpStatus.OK)
	@DeleteMapping("/{tarefaId}")
	public void remover(@PathVariable("tarefaId") Integer tarefaId) {
		tarefaRepository.deleteById(tarefaId);
	}
	
	@ResponseStatus(value=HttpStatus.OK)
	@PutMapping("/{tarefaId}")
	public void atualizar(@PathVariable("tarefaId") Integer tarefaId,@RequestBody Tarefa tarefa) {
		Tarefa tarefaToUpdate =  tarefaRepository.findById(tarefaId).orElse(null);
		BeanUtils.copyProperties(tarefa, tarefaToUpdate, "tarefaId");
		tarefaRepository.save(tarefaToUpdate);
	}
	
	@ResponseStatus(value=HttpStatus.OK)
	@PostMapping("{tarefaId}/upload")
	public void upload(@PathVariable("tarefaId")Integer tarefaId,@RequestParam("file") MultipartFile file,
		@RequestParam("descricao") String descricao) {
		try {
			String time = String.valueOf(new Date().getTime());
			byte[] bytes = file.getBytes();
            Path path = Paths.get("/FEMABA/"+time+"_"+file.getOriginalFilename());
			Files.write(path,bytes);
			String nomeOriginal =  file.getOriginalFilename();
			String contentType =  file.getContentType();
			long tamanho = file.getSize();
			Tarefa tarefa = tarefaRepository.findById(tarefaId).orElse(null);
			tarefa.setTarefaId(tarefaId);
			String extensao = Optional.ofNullable(file.getOriginalFilename())
		      .filter(f -> f.contains("."))
		      .map(f -> f.substring(file.getOriginalFilename().lastIndexOf(".") + 1)).get();
			String fileName =  time+"_"+file.getOriginalFilename();
			ArquivoTarefa arquivo =  new ArquivoTarefa(tarefa, fileName, descricao, new Date(),
					extensao, nomeOriginal, contentType, tamanho);
			arquivoTarefaRepository.save(arquivo);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@GetMapping("/{tarefaId}/arquivos")
	public ResponseEntity<List<Arquivo>> documentos(@PathVariable("tarefaId") Integer tarefaId){
		List<Arquivo> arquivos =  arquivoTarefaRepository.findByTarefa_TarefaId(tarefaId);
		return ResponseEntity.ok(arquivos);
	}
	

}
