package com.otavio.vendas.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.otavio.vendas.modelo.Processamento;
import com.otavio.vendas.modelo.Status;
import com.otavio.vendas.modelo.Venda;
import com.otavio.vendas.repositorio.Processamentos;
import com.otavio.vendas.repositorio.Vendas;

@Service
@Transactional(propagation=Propagation.REQUIRES_NEW)
public class ServicoInsereVenda {

	@Autowired
	private Vendas vendas;

	@Autowired
	private Processamentos processamentos;

	public void executaServico() {
		try {
			System.out.println("Processando venda na thread.");

			List<Venda> vendasNaoProcessadas = vendas.findByStatusOrderByData(Status.NAO_PROCESSADO);
			Venda venda = vendasNaoProcessadas.get(0);

			venda.setStatus(Status.OK);

			vendas.save(venda);

			Processamento processamento = new Processamento();

			processamento.setData(venda.getData());
			processamento.setLoja(venda.getLoja());
			processamento.setPdv(venda.getPdv());

			processamentos.save(processamento);	

			System.out.println("Venda processada na thread.");
		} catch (Exception ex) {
			System.err.println("Servico: " + ex.getMessage());
		}
	}
}
