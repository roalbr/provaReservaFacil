package br.com.reservafacil.transferencia.taxa;

import java.math.BigDecimal;

import br.com.reservafacil.transferencia.calculo.ITaxa;
import br.com.reservafacil.transferencia.model.Agenda;

/**
 * Classe responsavel pelo calculo da Taxa do TipoC
 * @author Rodrigo
 *
 */
public class TaxaC implements ITaxa {

	/*
	  Regra de Calculo:
	  Operações do tipo C tem uma taxa regressiva conforme a
	  data de agendamento: 
	  maior que 30  dias da data de cadastro 1.2% 
	  até 30 dias da data de cadastro 2.1% 
	  até 25 dias da data de cadastro 4.3% 
	  até 20 dias da data de cadastro 5.4% 
	  até 15 dias da data de cadastro 6.7% 
	  até 10 dias da data de cadastro 7.4% 
	  até 5 dias da data de cadastro 8.3%
	 */
	@Override
	public BigDecimal calculaTaxa(Agenda agendamento) {
		
		int dias = agendamento.quantidadeDiasCadastroTransferencia();
		BigDecimal valorTransferencia = agendamento.getValorTransferencia().divide(new BigDecimal("100"));
		
		if(dias <= 5)
			return valorTransferencia.multiply(new BigDecimal("8.3"));
		else if(dias <= 10)
			return valorTransferencia.multiply(new BigDecimal("7.4"));
		else if(dias <= 15)
			return valorTransferencia.multiply(new BigDecimal("6.7"));
		else if(dias <= 20)
			return valorTransferencia.multiply(new BigDecimal("5.4"));
		else if(dias <= 25)
			return valorTransferencia.multiply(new BigDecimal("4.3"));
		else if(dias <= 30)
			return valorTransferencia.multiply(new BigDecimal("2.1"));
		else
			return valorTransferencia.multiply(new BigDecimal("1.2"));
			
	}

}
