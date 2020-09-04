package br.com.sistemaobrigacoes.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sistemaobrigacoes.TokenDto;
import br.com.sistemaobrigacoes.form.LoginForm;
import br.com.sistemaobrigacoes.servicos.TokenService;

@RestController
@RequestMapping("/autenticacao")
public class AutenticacaoResource {
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private TokenService tokenService;
	
	@PostMapping
	public ResponseEntity<TokenDto> logar(@RequestBody LoginForm form){
		try {
			UsernamePasswordAuthenticationToken credenciais = 
					new UsernamePasswordAuthenticationToken(form.getLogin(),form.getSenha());
			Authentication authenticate = authManager.authenticate(credenciais);
			String token = tokenService.gerarToken(authenticate);
			return ResponseEntity.ok(new TokenDto(token,"Bearer"));
		} catch (AuthenticationException e) {
			return ResponseEntity.badRequest().build();
		}
	}

}
