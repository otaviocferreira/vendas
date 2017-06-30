package com.otavio.vendas.agendamento;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.otavio.vendas.modelo.ItemVenda;
import com.otavio.vendas.modelo.Venda;
import com.otavio.vendas.repositorio.Vendas;

@Component
public class InsereVendaAgendamento {
	
	@Autowired
	private Vendas vendas;

	@Scheduled(fixedDelay = 20000)
	public void insereVenda() {		
		System.out.println("Inserindo nova venda");
		
		Random gerador = new Random();
		
		Integer itens = gerador.nextInt(9) + 1;
		Integer loja = gerador.nextInt(999) + 1;
		Integer pdv = gerador.nextInt(9) + 1;		
		
		Venda venda = new Venda();
		
		venda.setData(new Date());
		venda.setLoja(loja);
		venda.setPdv(pdv);
		
		for (int i = 0; i < itens; i++) {
			String produto = "" + 999999 + gerador.nextInt(9000000);
			BigDecimal precoUnitario = new BigDecimal(Math.random() + gerador.nextInt(100));
			BigDecimal desconto = new BigDecimal(Math.random());
			
			ItemVenda itemVenda = new ItemVenda();
			
			itemVenda.getIdentificador().setIdItemVenda(new Long(i + 1));
			itemVenda.setProduto(produto);
			itemVenda.setPrecoUnitario(precoUnitario);
			itemVenda.setDesconto(desconto);
			itemVenda.getIdentificador().setIdVenda(venda);
			
			venda.getItens().add(itemVenda);
		}
		
		vendas.save(venda);
	}
}
