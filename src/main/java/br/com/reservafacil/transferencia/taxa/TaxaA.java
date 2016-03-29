package br.com.reservafacil.transferencia.taxa;

import java.math.BigDecimal;

import br.com.reservafacil.transferencia.calculo.ITaxa;
import br.com.reservafacil.transferencia.model.Agenda;


/**
 * Classe responsavel pelo calculo da Taxa do TipoA
 * @author Rodrigo
 *
 */
public class TaxaA implements ITaxa{

	/* Regra de Calculo
	  A: Opera��es do tipo A tem uma taxa de $2 mais 3% do valor da transfer�ncia.
	*/
	@Override
	public BigDecimal calculaTaxa(Agenda agendamento) {
		
		BigDecimal valorTaxaFixo = new BigDecimal("2.00");
		BigDecimal valorTransferencia = agendamento.getValorTransferencia().divide(new BigDecimal("100"));
		
		return (valorTransferencia.multiply(new BigDecimal("3"))).add(valorTaxaFixo);
	}

}
