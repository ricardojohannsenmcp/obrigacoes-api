package br.com.sistemaobrigacoes.modelo;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Table(name="evento_processo")
@Data
//@NamedEntityGraph(name = "EventoProcesso.eventos",
//attributeNodes = @NamedAttributeNode("eventos"))
public class EventoProcesso {
	
	@Id
	@Column(name="evento_processo_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer eventoProcessoId;
	
	@ManyToOne
	@JoinColumn(name="tipo_evento_processo_id")
	private TipoEventoProcesso tipoEventoProcesso;
	
	@Temporal(TemporalType.DATE)
	private Date data;
	
	@ManyToOne
	@JoinColumn(name="processo_id")
	private Processo processo;
	
	
	private String observacao;
	
	@ManyToOne
	@JoinColumn(name="evento_pai_id",nullable=true)
	private EventoProcesso eventoProcesso;
	
	@OneToMany(mappedBy="eventoProcesso")
	private Collection<EventoProcesso> eventos;
	
	
	
	

}
