package br.com.reservafacil.test.calculo;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import br.com.reservafacil.transferencia.calculo.TipoTaxa;
import br.com.reservafacil.transferencia.model.Agenda;

public class CalculoTaxaTipoBTest {
	
	AgendaTest agTeste = new AgendaTest();
	
	@Test
	public void TestaCalculoTaxaBDiferencaDeDiasMenorOuIgualATrintaEstaCorreto() {

		Agenda ag = agTeste.criaAgendamentoParaTesteDeTaxa(new BigDecimal("100.00"), 30);

		TipoTaxa tipoTaxa = TipoTaxa.TxB;
		BigDecimal valorTaxa = tipoTaxa.getTaxa().calculaTaxa(ag);
		Assert.assertTrue("Agendamento de Transferencia do Tipo: B com diferença de 30 ou menos dias da data de Cadastro",
				valorTaxa.compareTo(new BigDecimal("10.00")) == 0);

	}

	@Test
	public void TestaCalculoTaxaBDiferencaDeDiasMaiorQueTrintaEstaCorreto() {

		Agenda ag = agTeste.criaAgendamentoParaTesteDeTaxa(new BigDecimal("100.00"), 31);

		TipoTaxa tipoTaxa = TipoTaxa.TxB;
		BigDecimal valorTaxa = tipoTaxa.getTaxa().calculaTaxa(ag);
		Assert.assertTrue("Agendamento de Transferencia do Tipo: B com diferença de 30 ou mais dias da data de Cadastro",
				valorTaxa.compareTo(new BigDecimal("12.00")) == 0);

	}
}
