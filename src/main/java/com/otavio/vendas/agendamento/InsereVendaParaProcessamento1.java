package com.otavio.vendas.agendamento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.otavio.vendas.servico.ServicoInsereVenda;

@Component
public class InsereVendaParaProcessamento1 {

	@Autowired
	ServicoInsereVenda servico;
	
	@Scheduled(cron = "0 * * * * *")
	public void insereVendaParaProcessamento() {
		servico.executaServico();
	}
}
