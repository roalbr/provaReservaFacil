package br.com.reservafacil.test.calculo;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import br.com.reservafacil.transferencia.calculo.TipoTaxa;
import br.com.reservafacil.transferencia.model.Agenda;


public class CalculoTaxaTipoDTest {

	AgendaTest agTeste = new AgendaTest();

	@Test
	public void TestaCalculoTaxaDValorAteVinteECincoMil() {

		Agenda ag = agTeste.criaAgendamentoParaTesteDeTaxa(new BigDecimal("25000.00"), 0);
		
		TipoTaxa tipoTaxa = TipoTaxa.TxD;
		BigDecimal valorTaxa = tipoTaxa.getTaxa().calculaTaxa(ag);
		Assert.assertTrue("Agendamento de Transferencia do Tipo: D com valor ate 25.000",
				valorTaxa.compareTo(new BigDecimal("752.00")) == 0);

	}
	
	@Test
	public void TestaCalculoTaxaDValorMaiorQueVinteECincoMilEMenorQueCentoEVinteMil() {

		Agenda ag = agTeste.criaAgendamentoParaTesteDeTaxa(new BigDecimal("50000.00"), 0);

		TipoTaxa tipoTaxa = TipoTaxa.TxD;
		BigDecimal valorTaxa = tipoTaxa.getTaxa().calculaTaxa(ag);
		Assert.assertTrue("Agendamento de Transferencia do Tipo: D com valor maior que 25.000 e menor que 120.000",
				valorTaxa.compareTo(new BigDecimal("10.00")) == 0);

	}
	
	@Test
	public void TestaCalculoTaxaDValorMaiorQueCentoEVinteMil() {

		Agenda ag = agTeste.criaAgendamentoParaTesteDeTaxa(new BigDecimal("125000.00"), 0);

		TipoTaxa tipoTaxa = TipoTaxa.TxD;
		BigDecimal valorTaxa = tipoTaxa.getTaxa().calculaTaxa(ag);
		Assert.assertTrue("Agendamento de Transferencia do Tipo: D com valor maior que 120.000",
				valorTaxa.compareTo(new BigDecimal("10375.00")) == 0);

	}
	
	
}
