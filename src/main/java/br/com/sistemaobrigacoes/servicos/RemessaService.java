package br.com.sistemaobrigacoes.servicos;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.sistemaobrigacoes.form.RemessaForm;
import br.com.sistemaobrigacoes.modelo.Ente;
import br.com.sistemaobrigacoes.modelo.Remessa;
import br.com.sistemaobrigacoes.repositorios.EnteRepository;
import br.com.sistemaobrigacoes.repositorios.RemessaRepository;

@Service
public class RemessaService {
	
	
	@Autowired
	private RemessaRepository remessaRepository;
	
	@Autowired
	private EnteRepository enteRepository;
	
	@Transactional
	public void cadastrar(RemessaForm form) {
		List<Remessa> remessas =  new ArrayList<Remessa>();
		List<Ente> entes =  (List<Ente>) enteRepository.findAll();
		for(Ente ente : entes) {
			Remessa remessa =  new Remessa();
			remessa.setObrigacao(form.getObrigacao());
			remessa.setPeriodo(form.getPeriodo());
			remessa.setExercicio(form.getExercicio());
			remessa.setPrazo(form.getData());
			remessa.setEnte(ente);
			remessas.add(remessa);
		}
		remessaRepository.saveAll(remessas);
	}
	
	
	

}
