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
import br.com.sistemaobrigacoes.modelo.ArquivoRemessa;
import br.com.sistemaobrigacoes.modelo.Remessa;
import br.com.sistemaobrigacoes.repositorios.ArquivoRemessaRepository;
import br.com.sistemaobrigacoes.repositorios.RemessaRepository;

@RestController
@RequestMapping("/remessas")
public class RemessaResource {
	
	@Autowired
	private RemessaRepository remessaRepository;
	
	@Autowired
	private ArquivoRemessaRepository arquivoRemessaRepository;
	
	@PostMapping
	public ResponseEntity<Remessa> salvar(@RequestBody Remessa remessa) {
		Remessa remessaSalva = remessaRepository.save(remessa);
		return ResponseEntity.ok(remessaSalva);
	}
	
	@GetMapping("/{remessaId}")
	public ResponseEntity<Remessa> find(@PathVariable("remessaId") Integer remessaId){
		return ResponseEntity.ok(remessaRepository.findById(remessaId).orElse(null));
	}
	
	@GetMapping
	public ResponseEntity<List<Remessa>> lista(){
		List<Remessa> remessas =  (List<Remessa>) remessaRepository.findAll();
		return ResponseEntity.ok(remessas);
	}

	@GetMapping("/filtro")
	public ResponseEntity<List<Remessa>> lista(@RequestBody FiltroRemessa filtro){
		List<Remessa> remessas =  (List<Remessa>) remessaRepository.findyFiltro(filtro);
		return ResponseEntity.ok(remessas);
	}
	
	@ResponseStatus(value=HttpStatus.OK)
	@DeleteMapping("/{remessaId}")
	public void remover(@PathVariable("remessaId") Integer remessaId) {
		remessaRepository.deleteById(remessaId);
	}
	
	@ResponseStatus(value=HttpStatus.OK)
	@PutMapping("/{remessaId}")
	public void atualizar(@PathVariable("remessaId") Integer remessaId,@RequestBody Remessa remessa) {
		Remessa remessaToUpdate =  remessaRepository.findById(remessaId).orElse(null);
		BeanUtils.copyProperties(remessa, remessaToUpdate, "remessaId");
		remessaRepository.save(remessaToUpdate);
	}
	
	@ResponseStatus(value=HttpStatus.OK)
	@PostMapping("{remessaId}/upload")
	public void upload(@PathVariable("remessaId")Integer remessaId,@RequestParam("file") MultipartFile file,
		@RequestParam("descricao") String descricao) {
		try {
			String time = String.valueOf(new Date().getTime());
			byte[] bytes = file.getBytes();
            Path path = Paths.get("/FEMABA/"+time+"_"+file.getOriginalFilename());
			Files.write(path,bytes);
			String nomeOriginal =  file.getOriginalFilename();
			String contentType =  file.getContentType();
			long tamanho = file.getSize();
			Remessa remessa = remessaRepository.findById(remessaId).orElse(null);
			remessa.setRemessaId(remessaId);
			String extensao = Optional.ofNullable(file.getOriginalFilename())
		      .filter(f -> f.contains("."))
		      .map(f -> f.substring(file.getOriginalFilename().lastIndexOf(".") + 1)).get();
			String fileName =  time+"_"+file.getOriginalFilename();
			ArquivoRemessa arquivo =  new ArquivoRemessa(remessa, fileName, descricao, new Date(),
					extensao, nomeOriginal, contentType, tamanho);
			arquivoRemessaRepository.save(arquivo);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@GetMapping("/{remessaId}/arquivos")
	public ResponseEntity<List<Arquivo>> documentos(@PathVariable("remessaId") Integer remessaId){
		List<Arquivo> arquivos =  arquivoRemessaRepository.findByRemessa_RemessaId(remessaId);
		return ResponseEntity.ok(arquivos);
	}
	

}
