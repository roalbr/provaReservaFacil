package br.com.reservafacil.transferencia.model;

import java.math.BigDecimal;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.springframework.format.annotation.DateTimeFormat;

import br.com.reservafacil.transferencia.calculo.TipoTaxa;


public class Agenda {

	private long id;
	private String contaOrigem;
	private String contaDestino;
	private BigDecimal valorTransferencia;
	private BigDecimal taxa;

	@DateTimeFormat(pattern="dd/MM/yyyy")
	private DateTime dataCadastro = new DateTime();
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private DateTime dataAgendada;

	private TipoTaxa tipoTaxa;

	public Agenda(String contaOrigem, String contaDestino, BigDecimal valorTransferencia, BigDecimal taxa,
			DateTime dataCadastro, DateTime dataAgendada, TipoTaxa tipoTaxa) {
		this.contaOrigem = contaOrigem;
		this.contaDestino = contaDestino;
		this.valorTransferencia = valorTransferencia;
		this.taxa = taxa;
		this.dataCadastro = dataCadastro;
		this.dataAgendada = dataAgendada;
		this.tipoTaxa = tipoTaxa;
	}

	public Agenda() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getContaOrigem() {
		return contaOrigem;
	}

	public void setContaOrigem(String contaOrigem) {
		this.contaOrigem = contaOrigem;
	}

	public String getContaDestino() {
		return contaDestino;
	}

	public void setContaDestino(String contaDestino) {
		this.contaDestino = contaDestino;
	}

	public BigDecimal getValorTransferencia() {
		return valorTransferencia;
	}

	public void setValorTransferencia(BigDecimal valorTransferencia) {
		this.valorTransferencia = valorTransferencia;
	}

	public BigDecimal getTaxa() {
		return taxa;
	}

	public void setTaxa(BigDecimal taxa) {
		this.taxa = taxa;
	}

	public TipoTaxa getTipoTaxa() {
		return tipoTaxa;
	}

	public void setTipoTaxa(TipoTaxa tipoTaxa) {
		this.tipoTaxa = tipoTaxa;
	}

	public DateTime getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(DateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public DateTime getDataAgendada() {
		return dataAgendada;
	}

	public void setDataAgendada(DateTime dataAgendada) {
		this.dataAgendada = dataAgendada;
	}

	public int quantidadeDiasCadastroTransferencia() {
		return Days.daysBetween(this.dataCadastro, this.dataAgendada).getDays();
	}

}
