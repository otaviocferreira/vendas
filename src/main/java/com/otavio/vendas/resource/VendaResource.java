package com.otavio.vendas.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.otavio.vendas.modelo.ItemVenda;
import com.otavio.vendas.modelo.Processamento;
import com.otavio.vendas.modelo.Status;
import com.otavio.vendas.modelo.Venda;
import com.otavio.vendas.repositorio.Processamentos;
import com.otavio.vendas.repositorio.Vendas;

@RestController
@RequestMapping("/insereVenda")
public class VendaResource {
	
	@Autowired
	private Processamentos processamentos;
	
	@Autowired
	private Vendas vendas;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> insereVenda(@RequestBody Venda venda) {
		int identificador = 0;
		
		if (venda == null) {
		    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		  }
		
		System.out.println("Loja: " + venda.getLoja());
		
		for (ItemVenda item : venda.getItens()) {
			identificador++;
			item.getIdentificador().setIdItemVenda(new Long(identificador));
			item.getIdentificador().setIdVenda(venda);
		}
		
		vendas.save(venda);
		
		Processamento processamento = new Processamento();
		
		processamento.setData(venda.getData());
		processamento.setLoja(venda.getLoja());
		processamento.setPdv(venda.getPdv());
		
		processamentos.save(processamento);
		
		venda.setStatus(Status.OK);
		
		vendas.save(venda);
		
		return new ResponseEntity<String>("Venda salva com sucesso.", HttpStatus.OK);
	}
}
