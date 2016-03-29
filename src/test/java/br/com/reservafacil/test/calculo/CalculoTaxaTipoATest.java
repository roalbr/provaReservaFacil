package br.com.reservafacil.test.calculo;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import br.com.reservafacil.transferencia.calculo.TipoTaxa;
import br.com.reservafacil.transferencia.model.Agenda;

public class CalculoTaxaTipoATest {

	AgendaTest agTeste = new AgendaTest();
	
	@Test
	public void TestaCalculoTaxaAEstaCorreto(){
		
		Agenda ag = agTeste.criaAgendamentoParaTesteDeTaxa(new BigDecimal("100.00"), 0);
		
		TipoTaxa tipoTaxa = TipoTaxa.TxA;
		BigDecimal valorTaxa = tipoTaxa.getTaxa().calculaTaxa(ag);		
		Assert.assertTrue("Agendamento de Transferencia do Tipo: Taxa A", valorTaxa.compareTo(new BigDecimal("3.00")) == 0);
		
	}
	
}
