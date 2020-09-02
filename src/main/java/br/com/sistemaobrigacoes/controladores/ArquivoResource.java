package br.com.sistemaobrigacoes.controladores;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.sistemaobrigacoes.repositorios.ArquivoRepository;

@RestController
@RequestMapping("/arquivo")
public class ArquivoResource {
	
	@Autowired
	private ArquivoRepository arquivoRepository;
	
	@ResponseStatus(value=HttpStatus.OK)
	@DeleteMapping("/{arquivoId}")
	public void remove(@PathVariable("arquivoId") Integer arquivoId) {
		arquivoRepository.deleteById(arquivoId);
	}
	
	@ResponseStatus(code=HttpStatus.OK)
	@GetMapping("/download/{fileName:.+}")
	public void download(HttpServletRequest request, HttpServletResponse response,@PathVariable("fileName") String fileName) {
		File file = new File("/FEMABA/" + fileName);
		if (file.exists()) {
			String mimeType = URLConnection.guessContentTypeFromName(file.getName());
			if (mimeType == null) {
				mimeType = "application/octet-stream";
			}
			response.setContentType(mimeType);
			response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() + "\""));
			response.setContentLength((int) file.length());
				try {
					InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
					FileCopyUtils.copy(inputStream, response.getOutputStream());
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
		
	}
	
	
}
