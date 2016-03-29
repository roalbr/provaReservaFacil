package br.com.reservafacil.test.agenda;

import java.math.BigDecimal;

import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.reservafacil.transferencia.calculo.TipoTaxa;
import br.com.reservafacil.transferencia.dao.AgendaDAO;
import br.com.reservafacil.transferencia.model.Agenda;


public class AgendaTest {

	Agenda ag;
	AgendaDAO dao = new AgendaDAO();
	
	@Before
	public void CriarUmAgendamento(){
		
		ag = new Agenda();
		ag.setContaOrigem("20595-67");
		ag.setContaDestino("20595-68");
		ag.setValorTransferencia(new BigDecimal("150.00"));
		ag.setDataCadastro(new DateTime());
		ag.setDataAgendada(new DateTime());
		ag.setTaxa(new BigDecimal("2.00"));
		ag.setTipoTaxa(TipoTaxa.TxA);
		
	}
	
	@Test
	public void DeveIncluirOAgendamentoEmUmaListaERetornarOIdGerado(){
		
		dao.adiciona(ag);
		Assert.assertFalse("Incluido Lista de Agendamentos.", dao.buscaTodosAgendamentos().isEmpty());
		
		Long id = null;		
		for(Agenda ag : dao.buscaTodosAgendamentos()){
			id = ag.getId();
			break;
		}
		Assert.assertNotNull("Agendamento efetuado possui oId", id);
		
	}
	
}
