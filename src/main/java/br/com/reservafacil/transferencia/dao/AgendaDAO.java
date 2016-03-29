package br.com.reservafacil.transferencia.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import br.com.reservafacil.transferencia.model.Agenda;


/**
 * AgendaDAO: Classe responsavel pela inclusao e lista dos agendamentos.
 * @author Rodrigo
 *
 */
public class AgendaDAO {

	private static Map<Long, Agenda> AGENDAMENTOS = new HashMap<Long, Agenda>();
	// As classes atômicas garantem que determinadas operações serão executadas
	// com segurança de encadeamento, como incrementar e decrementar um valor,
	// atualizar um valor e incluir em um valor.
	private static AtomicLong cont = new AtomicLong(1);
	
	public void adiciona(Agenda agendamento) {
		long id = cont.incrementAndGet();
		agendamento.setId(id);
		AGENDAMENTOS.put(id, agendamento);
	}
	
	public Collection<Agenda> buscaTodosAgendamentos() {
		
		List<Agenda> lista = new ArrayList<>();		
		for (Agenda ag : AGENDAMENTOS.values()) {
				lista.add(ag);
		}
		return lista;
	}

	
}
