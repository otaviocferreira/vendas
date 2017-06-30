package com.otavio.vendas.modelo.filtro;

import java.util.Date;

import com.otavio.vendas.modelo.Status;

public class VendaFilter {

	private Status status;
	private Date dataInicial;
	private Date dataFinal;

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Date getDataInicial() {
		return dataInicial;
	}

	public void setDataInicial(Date dataInicial) {
		this.dataInicial = dataInicial;
	}

	public Date getDataFinal() {
		return dataFinal;
	}

	public void setDataFinal(Date dataFinal) {
		this.dataFinal = dataFinal;
	}
}
