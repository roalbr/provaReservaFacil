package br.com.reservafacil.test.calculo;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Test;

import br.com.reservafacil.transferencia.calculo.TipoTaxa;
import br.com.reservafacil.transferencia.model.Agenda;


public class CalculoTaxaTipoCTest {

	AgendaTest agTeste = new AgendaTest();

	@Test
	public void TestaCalculoTaxaCDiferencaDeDiasMenorOuIgualACincoEstaCorreto() {

		Agenda ag = agTeste.criaAgendamentoParaTesteDeTaxa(new BigDecimal("100.00"), 5);

		TipoTaxa tipoTaxa = TipoTaxa.TxC;
		BigDecimal valorTaxa = tipoTaxa.getTaxa().calculaTaxa(ag);
		Assert.assertTrue("Agendamento de Transferencia do Tipo: C com diferença de 5 ou menos dias da data de Cadastro",
				valorTaxa.compareTo(new BigDecimal("8.30")) == 0);

	}
	
	@Test
	public void TestaCalculoTaxaCDiferencaDeDiasDeSeisADezEstaCorreto() {

		Agenda ag = agTeste.criaAgendamentoParaTesteDeTaxa(new BigDecimal("100.00"), 10);

		TipoTaxa tipoTaxa = TipoTaxa.TxC;
		BigDecimal valorTaxa = tipoTaxa.getTaxa().calculaTaxa(ag);
		Assert.assertTrue("Agendamento de Transferencia do Tipo: C com diferença de 6 a 10 dias da data de Cadastro",
				valorTaxa.compareTo(new BigDecimal("7.40")) == 0);

	}
	
	@Test
	public void TestaCalculoTaxaCDiferencaDeDiasDeOnzeAQuinzeEstaCorreto() {

		Agenda ag = agTeste.criaAgendamentoParaTesteDeTaxa(new BigDecimal("100.00"), 15);

		TipoTaxa tipoTaxa =TipoTaxa.TxC;
		BigDecimal valorTaxa = tipoTaxa.getTaxa().calculaTaxa(ag);
		Assert.assertTrue("Agendamento de Transferencia do Tipo: C com diferença de 11 a 15 dias da data de Cadastro",
				valorTaxa.compareTo(new BigDecimal("6.70")) == 0);

	}
	
	@Test
	public void TestaCalculoTaxaCDiferencaDeDiasDeDezesseisAVinteEstaCorreto() {

		Agenda ag = agTeste.criaAgendamentoParaTesteDeTaxa(new BigDecimal("100.00"), 20);

		TipoTaxa tipoTaxa = TipoTaxa.TxC;
		BigDecimal valorTaxa = tipoTaxa.getTaxa().calculaTaxa(ag);
		Assert.assertTrue("Agendamento de Transferencia do Tipo: C  com diferença de 16 a 20 dias da data de Cadastro",
				valorTaxa.compareTo(new BigDecimal("5.40")) == 0);

	}
	@Test
	public void TestaCalculoTaxaCDiferencaDeDiasDeVinteEUmAVinteECincoEstaCorreto() {

		Agenda ag = agTeste.criaAgendamentoParaTesteDeTaxa(new BigDecimal("100.00"), 25);

		TipoTaxa tipoTaxa = TipoTaxa.TxC;
		BigDecimal valorTaxa = tipoTaxa.getTaxa().calculaTaxa(ag);
		Assert.assertTrue("Agendamento de Transferencia do Tipo: C com diferença de 21 a 25 dias da data de Cadastro",
				valorTaxa.compareTo(new BigDecimal("4.30")) == 0);

	}
	
	@Test
	public void TestaCalculoTaxaCDiferencaDeDiasDeVinteESeisATrintaEstaCorreto() {

		Agenda ag = agTeste.criaAgendamentoParaTesteDeTaxa(new BigDecimal("100.00"), 30);

		TipoTaxa tipoTaxa = TipoTaxa.TxC;
		BigDecimal valorTaxa = tipoTaxa.getTaxa().calculaTaxa(ag);
		Assert.assertTrue("Agendamento de Transferencia do Tipo: C com diferença de 26 a 30 dias da data de Cadastro",
				valorTaxa.compareTo(new BigDecimal("2.10")) == 0);

	}

	@Test
	public void TestaCalculoTaxaCDiferencaMaiorQueTrintaDias() {

		Agenda ag = agTeste.criaAgendamentoParaTesteDeTaxa(new BigDecimal("100.00"), 31);

		TipoTaxa tipoTaxa = TipoTaxa.TxC;
		BigDecimal valorTaxa = tipoTaxa.getTaxa().calculaTaxa(ag);
		Assert.assertTrue("Agendamento de Transferencia do Tipo: C com diferença maior que dias da data de Cadastro",
				valorTaxa.compareTo(new BigDecimal("1.20")) == 0);

	}

}
