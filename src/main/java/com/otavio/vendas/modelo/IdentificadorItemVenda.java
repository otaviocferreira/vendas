package com.otavio.vendas.modelo;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Embeddable
public class IdentificadorItemVenda implements Serializable {

	private static final long serialVersionUID = -30028065234474437L;

	@JsonProperty(value = "id_item_venda")
	@JsonIgnore
	private Long idItemVenda;

	@JsonProperty(value = "id_venda")
	@JsonIgnore
	@ManyToOne
    @JoinColumn(name="id_venda")
	private Venda idVenda;

	public Long getIdItemVenda() {
		return idItemVenda;
	}

	public void setIdItemVenda(Long idItemVenda) {
		this.idItemVenda = idItemVenda;
	}

	public Venda getIdVenda() {
		return idVenda;
	}

	public void setIdVenda(Venda idVenda) {
		this.idVenda = idVenda;
	}
	
}
