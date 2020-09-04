package br.com.sistemaobrigacoes.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sistemaobrigacoes.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	
	Usuario findByLogin(String login);

}
