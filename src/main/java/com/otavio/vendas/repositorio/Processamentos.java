package com.otavio.vendas.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.otavio.vendas.modelo.Processamento;
import com.otavio.vendas.modelo.Status;

public interface Processamentos extends JpaRepository<Processamento, Long> {

	public List<Processamento> findByStatusOrderByData(Status status);

}
