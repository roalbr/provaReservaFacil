package br.com.reservafacil.transferencia.calculo;

import java.math.BigDecimal;

import br.com.reservafacil.transferencia.model.Agenda;
/**
 * Inteface ITaxa
 */
public interface ITaxa {

	public BigDecimal calculaTaxa(Agenda agendamento);

}
