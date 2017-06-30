package com.otavio.vendas.agendamento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.otavio.vendas.modelo.Processamento;
import com.otavio.vendas.modelo.Status;
import com.otavio.vendas.repositorio.Processamentos;
import com.otavio.vendas.servico.IncrementadorArquivo;

@Component
public class ProcessamentoArquivo {
	
	@Autowired
	private Processamentos processamentos;
	
	@Scheduled(fixedDelay = 60000)
	public void escreveProcessamentoNoArquivo() {
		System.out.println("Gravando Processamentos");

		List<Processamento> processamentosParaSalvar = processamentos.findByStatusOrderByData(Status.PENDENTE);
		
		for (Processamento processamento : processamentosParaSalvar) {
			processamento.setStatus(Status.OK);
			processamento.setNomeArquivo(new IncrementadorArquivo().incrementaArquivo(processamento));
			
			processamentos.save(processamento);
		}
	}
}
