package br.com.sistemaobrigacoes;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.sistemaobrigacoes.modelo.Ente;
import br.com.sistemaobrigacoes.repositorios.EnteRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
class ObrigacaoRepositoryTest {
	
	@Autowired
	private EnteRepository enteRepository;

	@Test
	void test() {
		List<Ente> entes = (List<Ente>) enteRepository.findAll();
		assertTrue(entes.size() > 0);
	}

}
