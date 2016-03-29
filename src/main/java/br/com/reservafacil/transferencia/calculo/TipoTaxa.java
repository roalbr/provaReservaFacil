package br.com.reservafacil.transferencia.calculo;

import br.com.reservafacil.transferencia.taxa.TaxaA;
import br.com.reservafacil.transferencia.taxa.TaxaB;
import br.com.reservafacil.transferencia.taxa.TaxaC;
import br.com.reservafacil.transferencia.taxa.TaxaD;

/**
 * Enum Tipotaxa: Nesse enum consta os tipos de taxa proposto pela Prova Reserva Fácil.
 * @author Rodrigo
 *
 */
public enum TipoTaxa {

	TxA(new TaxaA()), 
	TxB(new TaxaB()), 
	TxC(new TaxaC()), 
	TxD(new TaxaD());

	private ITaxa taxa;

	TipoTaxa(ITaxa taxa) {
		this.taxa = taxa;
	}

	public ITaxa getTaxa() {
		return taxa;
	}

}
