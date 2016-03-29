package br.com.reservafacil.transferencia.taxa;

import java.math.BigDecimal;

import br.com.reservafacil.transferencia.calculo.ITaxa;
import br.com.reservafacil.transferencia.model.Agenda;


/**
 * Classe responsavel pelo calculo da Taxa do TipoB
 * @author Rodrigo
 *
 */
public class TaxaB implements ITaxa {

	 /*
	   Regra de Calculo
	   B: Operações do Tipo B tem uma taxa de: 
	   $10 para pedidos com agendamento até 30 dias da data de cadastro. 
	   $8 para os demais.
	 */
	public BigDecimal calculaTaxa(Agenda agendamento) {

		int dias = agendamento.quantidadeDiasCadastroTransferencia();

		if (dias <= 30)
			return new BigDecimal("10.00");
		else
			return new BigDecimal("8.00");

	}



}
