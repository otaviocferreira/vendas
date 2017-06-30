package com.otavio.vendas.repositorio;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.otavio.vendas.modelo.Status;
import com.otavio.vendas.modelo.Venda;

public interface Vendas extends JpaRepository<Venda, Long> {

	public List<Venda> findByStatusOrderByData(Status status);
	
	@Query("select distinct status from Venda")
	List<Status> findDistinctStatus();
	
	@Query("select venda from Venda venda"
			+ " where venda.data between ?1 and ?2"
			+ " and venda.status = ?3")
	List<Venda> findByDataBetweenAndStatus(Date dataInicial, Date dataFinal, Status status);
}
