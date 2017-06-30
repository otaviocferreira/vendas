package com.otavio.vendas.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.otavio.vendas.modelo.IdentificadorItemVenda;
import com.otavio.vendas.modelo.ItemVenda;

public interface ItensVenda extends JpaRepository<ItemVenda, IdentificadorItemVenda> {

}
