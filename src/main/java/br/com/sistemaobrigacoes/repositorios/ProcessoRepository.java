package br.com.sistemaobrigacoes.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.sistemaobrigacoes.modelo.Processo;

public interface ProcessoRepository extends JpaRepository<Processo, Integer>{

}
