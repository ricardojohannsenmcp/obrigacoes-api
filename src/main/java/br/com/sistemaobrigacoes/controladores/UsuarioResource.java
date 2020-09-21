package br.com.sistemaobrigacoes.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sistemaobrigacoes.modelo.Usuario;
import br.com.sistemaobrigacoes.repositorios.UsuarioRepository;

@RestController
@RequestMapping("/usuario")
public class UsuarioResource {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	
	@GetMapping
	public ResponseEntity<Usuario> find(){
		
		Usuario  usuario =  usuarioRepository.findByLogin("rjpereira");
		
		usuario.getUsuarioGrupos().forEach(ug -> System.out.println(ug.getGrupoUsuario().getNome()));
		
		return ResponseEntity.ok(usuario);
	}

}
