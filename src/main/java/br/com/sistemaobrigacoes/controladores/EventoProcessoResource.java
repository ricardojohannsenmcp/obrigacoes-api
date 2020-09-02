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
import br.com.sistemaobrigacoes.modelo.ArquivoEventoProcesso;
import br.com.sistemaobrigacoes.modelo.EventoProcesso;
import br.com.sistemaobrigacoes.repositorios.ArquivoEventoProcessoRepository;
import br.com.sistemaobrigacoes.repositorios.EventoProcessoRepository;

@RestController
@RequestMapping("/eventoProcessos")
public class EventoProcessoResource {
	
	@Autowired
	private EventoProcessoRepository eventoProcessoRepository;
	
	@Autowired
	private ArquivoEventoProcessoRepository arquivoEventoProcessoRepository;
	
	@PostMapping
	public ResponseEntity<EventoProcesso> salvar(@RequestBody EventoProcesso eventoProcesso) {
		eventoProcesso =  eventoProcessoRepository.save(eventoProcesso);
		return ResponseEntity.ok(eventoProcesso);
	}
	
	@GetMapping("/{eventoProcessoId}")
	public ResponseEntity<EventoProcesso> find(@PathVariable("eventoProcessoId") Integer eventoProcessoId){
		return ResponseEntity.ok(eventoProcessoRepository.findById(eventoProcessoId).orElse(null));
	}
	
	@GetMapping
	public ResponseEntity<List<EventoProcesso>> lista(){
		List<EventoProcesso> eventoProcessos =  (List<EventoProcesso>) eventoProcessoRepository.findAll();
		return ResponseEntity.ok(eventoProcessos);
	}
	
	@GetMapping("/{eventoProcessoId}")
	public ResponseEntity<EventoProcesso> editar(@PathVariable("eventoProcessoId") Integer eventoProcessoId) {
		EventoProcesso eventoProcesso = eventoProcessoRepository.findById(eventoProcessoId).orElse(null);
		return ResponseEntity.ok(eventoProcesso);
	}
	
	@ResponseStatus(value=HttpStatus.OK)
	@DeleteMapping("/{eventoProcessoId}")
	public void remover(@PathVariable("eventoProcessoId") Integer eventoProcessoId) {
		eventoProcessoRepository.deleteById(eventoProcessoId);
	}
	
	@ResponseStatus(value=HttpStatus.OK)
	@PutMapping("/{eventoProcessoId}")
	public void atualizar(@PathVariable("eventoProcessoId") Integer eventoProcessoId,@RequestBody EventoProcesso eventoProcesso) {
		EventoProcesso eventoProcessoToUpdate =  eventoProcessoRepository.findById(eventoProcessoId).orElse(null);
		BeanUtils.copyProperties(eventoProcesso, eventoProcessoToUpdate, "eventoProcessoId");
		eventoProcessoRepository.save(eventoProcessoToUpdate);
	}
	
	@ResponseStatus(value=HttpStatus.OK)
	@PostMapping("{eventoProcessoId}/upload")
	public void upload(@PathVariable("eventoProcessoId")Integer eventoProcessoId,@RequestParam("file") MultipartFile file,
		@RequestParam("descricao") String descricao) {
		try {
			String time = String.valueOf(new Date().getTime());
			byte[] bytes = file.getBytes();
            Path path = Paths.get("/FEMABA/"+time+"_"+file.getOriginalFilename());
			Files.write(path,bytes);
			String nomeOriginal =  file.getOriginalFilename();
			String contentType =  file.getContentType();
			long tamanho = file.getSize();
			EventoProcesso eventoProcesso = eventoProcessoRepository.findById(eventoProcessoId).orElse(null);
			eventoProcesso.setEventoProcessoId(eventoProcessoId);
			String extensao = Optional.ofNullable(file.getOriginalFilename())
		      .filter(f -> f.contains("."))
		      .map(f -> f.substring(file.getOriginalFilename().lastIndexOf(".") + 1)).get();
			String fileName =  time+"_"+file.getOriginalFilename();
			ArquivoEventoProcesso arquivo =  new ArquivoEventoProcesso(eventoProcesso, fileName, descricao, new Date(),
					extensao, nomeOriginal, contentType, tamanho);
			arquivoEventoProcessoRepository.save(arquivo);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@GetMapping("/{eventoProcessoId}/arquivos")
	public ResponseEntity<List<Arquivo>> documentos(@PathVariable("eventoProcessoId") Integer eventoProcessoId){
		List<Arquivo> arquivos =  arquivoEventoProcessoRepository.findByEventoProcesso_EventoProcessoId(eventoProcessoId);
		return ResponseEntity.ok(arquivos);
	}
	
	@PostMapping("/{eventoProcessoId}/adicionar-evento")
	public ResponseEntity<EventoProcesso> adicionarEvento(@PathVariable("eventoProcessoId") Integer eventoProcessoId, @RequestBody EventoProcesso eventoProcesso){
		EventoProcesso eventoPai = eventoProcessoRepository.findById(eventoProcessoId).orElse(null);
		eventoProcesso.setEventoProcesso(eventoPai);
		EventoProcesso eventoSalvo = eventoProcessoRepository.save(eventoProcesso);
		return ResponseEntity.ok(eventoSalvo);
	}
	
	@GetMapping("/{eventoProcessoId}/eventos")
	public ResponseEntity<List<EventoProcesso>> eventos(@PathVariable("eventoProcessoId") Integer eventoProcessoId){
		List<EventoProcesso> eventos = eventoProcessoRepository.findByEventoProcesso_EventoProcessoId(eventoProcessoId);
		return ResponseEntity.ok(eventos);
	}
	

}
