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
import br.com.sistemaobrigacoes.modelo.ArquivoProcesso;
import br.com.sistemaobrigacoes.modelo.EventoProcesso;
import br.com.sistemaobrigacoes.modelo.Processo;
import br.com.sistemaobrigacoes.modelo.Tarefa;
import br.com.sistemaobrigacoes.modelo.TarefaProcesso;
import br.com.sistemaobrigacoes.repositorios.ArquivoProcessoRepository;
import br.com.sistemaobrigacoes.repositorios.EventoProcessoRepository;
import br.com.sistemaobrigacoes.repositorios.ProcessoRepository;
import br.com.sistemaobrigacoes.repositorios.TarefaProcessoRepository;

@RestController
@RequestMapping("/processos")
public class ProcessoResource {
	
	@Autowired
	private ProcessoRepository processoRepository;
	
	@Autowired
	private ArquivoProcessoRepository arquivoProcessoRepository;
	
	@Autowired
	private EventoProcessoRepository eventoProcessoRepository;
	
	@Autowired
	private TarefaProcessoRepository tarefaProcessoRepository;
	
	@PostMapping
	public ResponseEntity<Processo> salvar(@RequestBody Processo processo) {
		processo =  processoRepository.save(processo);
		return ResponseEntity.ok(processo);
	}
	
	@GetMapping("/{processoId}")
	public ResponseEntity<Processo> find(@PathVariable("processoId") Integer processoId){
		return ResponseEntity.ok(processoRepository.findById(processoId).orElse(null));
	}
	
	@GetMapping
	public ResponseEntity<List<Processo>> lista(){
		List<Processo> processos =  (List<Processo>) processoRepository.findAll();
		return ResponseEntity.ok(processos);
	}
	
	@ResponseStatus(value=HttpStatus.OK)
	@DeleteMapping("/{processoId}")
	public void remover(@PathVariable("processoId") Integer processoId) {
		processoRepository.deleteById(processoId);
	}
	
	@ResponseStatus(value=HttpStatus.OK)
	@PutMapping("/{processoId}")
	public void atualizar(@PathVariable("processoId") Integer processoId,@RequestBody Processo processo) {
		Processo processoToUpdate =  processoRepository.findById(processoId).orElse(null);
		BeanUtils.copyProperties(processo, processoToUpdate, "processoId");
		processoRepository.save(processoToUpdate);
	}
	
	@ResponseStatus(value=HttpStatus.OK)
	@PostMapping("{processoId}/upload")
	public void upload(@PathVariable("processoId")Integer processoId,@RequestParam("file") MultipartFile file,
		@RequestParam("descricao") String descricao) {
		try {
			String time = String.valueOf(new Date().getTime());
			byte[] bytes = file.getBytes();
            Path path = Paths.get("/FEMABA/"+time+"_"+file.getOriginalFilename());
			Files.write(path,bytes);
			String nomeOriginal =  file.getOriginalFilename();
			String contentType =  file.getContentType();
			long tamanho = file.getSize();
			Processo processo = processoRepository.findById(processoId).orElse(null);
			processo.setProcessoId(processoId);
			String extensao = Optional.ofNullable(file.getOriginalFilename())
		      .filter(f -> f.contains("."))
		      .map(f -> f.substring(file.getOriginalFilename().lastIndexOf(".") + 1)).get();
			String fileName =  time+"_"+file.getOriginalFilename();
			ArquivoProcesso arquivo =  new ArquivoProcesso(processo, fileName, descricao, new Date(),
					extensao, nomeOriginal, contentType, tamanho);
			arquivoProcessoRepository.save(arquivo);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@GetMapping("/{processoId}/arquivos")
	public ResponseEntity<List<Arquivo>> documentos(@PathVariable("processoId") Integer processoId){
		List<Arquivo> arquivos =  arquivoProcessoRepository.findByProcesso_ProcessoId(processoId);
		return ResponseEntity.ok(arquivos);
	}
	
	@GetMapping("/{processoId}/eventos")
	public ResponseEntity<List<EventoProcesso>> eventos(@PathVariable("processoId") Integer processoId){
		List<EventoProcesso> eventos = eventoProcessoRepository.findByProcesso_ProcessoId(processoId);
		return ResponseEntity.ok(eventos);
	}
	
	@PostMapping("/{processoId}/adicionar-tarefa")
	public ResponseEntity<TarefaProcesso> adicionarTarefa(@PathVariable("processoId") Integer processoId, @RequestBody TarefaProcesso tarefaProcesso){
		Processo processo = processoRepository.findById(processoId).orElse(null);
		tarefaProcesso.setProcesso(processo);
		TarefaProcesso tarefaSalva = tarefaProcessoRepository.save(tarefaProcesso);
		return ResponseEntity.ok(tarefaSalva);
	}

	@GetMapping("/{processoId}/tarefas")
	public ResponseEntity<List<Tarefa>> tarefas(@PathVariable("processoId") Integer processoId){
		List<Tarefa> tarefas = tarefaProcessoRepository.findByProcesso_ProcessoId(processoId);
		return ResponseEntity.ok(tarefas);
	}
	
}
