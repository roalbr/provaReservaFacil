package br.com.reservafacil.test.calculo;

import java.math.BigDecimal;

import org.joda.time.DateTime;

import br.com.reservafacil.transferencia.model.Agenda;


public class AgendaTest {

	public Agenda criaAgendamentoParaTesteDeTaxa(BigDecimal valorTransferencia, int diasEntreCadastroAgendamento) {
		
		DateTime dataAtual = new DateTime();
		DateTime dataAgendada = new DateTime();
		dataAgendada = dataAgendada.plusDays(diasEntreCadastroAgendamento);		
		
		Agenda ag = new Agenda();
		ag.setContaOrigem("20595-67");
		ag.setContaDestino("20595-68");
		ag.setDataCadastro(dataAtual.toDateTime());
		ag.setDataAgendada(dataAgendada.toDateTime());
		ag.setValorTransferencia(valorTransferencia);

		return ag;
	}

}
