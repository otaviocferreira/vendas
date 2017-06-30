package com.otavio.vendas.controle;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.otavio.vendas.modelo.Status;
import com.otavio.vendas.modelo.filtro.VendaFilter;
import com.otavio.vendas.repositorio.Vendas;

@Controller
@RequestMapping("/vendas")
public class VendasControle {

	@Autowired
	private Vendas vendas;

	@GetMapping("/lista")
	public ModelAndView findAll() {
		ModelAndView mv = new ModelAndView("vendas/lista");
		mv.addObject("vendas", vendas.findAll());
		mv.addObject("listaStatus", Status.values());
		return mv;
	}

	public ModelAndView pesquisar(VendaFilter vendaFilter) {
		ModelAndView mv = new ModelAndView("vendas/lista");
		mv.addObject("vendas",
				vendas.findByDataBetweenAndStatus(Optional.ofNullable(vendaFilter.getDataInicial()).orElse(new Date(0)),
						Optional.ofNullable(vendaFilter.getDataFinal()).orElse(new Date()),
						Optional.ofNullable(vendaFilter.getStatus()).orElse(Status.OK)));
		mv.addObject("listaStatus", Status.values());
		return mv;
	}
}
