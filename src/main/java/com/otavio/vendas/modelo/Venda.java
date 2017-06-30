package com.otavio.vendas.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.otavio.vendas.servico.DataDeserializer;
import com.otavio.vendas.servico.DataSerializer;

@Entity
@Table(name = "tb_venda")
public class Venda implements Serializable {

	private static final long serialVersionUID = -7473387073641423946L;

	@JsonProperty(value = "id_venda")
	@JsonIgnore
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idVenda;
	
	@JsonDeserialize(using = DataDeserializer.class)
	@JsonSerialize(using = DataSerializer.class)
	@JsonProperty(value = "data")
	@Temporal(TemporalType.TIMESTAMP)
	private Date data;
	
	@JsonProperty(value = "status")
	@JsonIgnore
	@Enumerated(EnumType.STRING)
	private Status status = Status.NAO_PROCESSADO;
	
	@JsonProperty(value = "itens")
	@OneToMany(mappedBy = "identificador.idVenda", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<ItemVenda> itens = new ArrayList<>();
	
	@JsonProperty(value = "loja")
	private Integer loja;
	@JsonProperty(value = "pdv")
	private Integer pdv;

	public Long getIdVenda() {
		return idVenda;
	}

	public void setIdVenda(Long idVenda) {
		this.idVenda = idVenda;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public List<ItemVenda> getItens() {
		return itens;
	}

	public void setItens(List<ItemVenda> itens) {
		this.itens = itens;
	}

	public Integer getLoja() {
		return loja;
	}

	public void setLoja(Integer loja) {
		this.loja = loja;
	}

	public Integer getPdv() {
		return pdv;
	}

	public void setPdv(Integer pdv) {
		this.pdv = pdv;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idVenda == null) ? 0 : idVenda.hashCode());
		result = prime * result + ((loja == null) ? 0 : loja.hashCode());
		result = prime * result + ((pdv == null) ? 0 : pdv.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Venda other = (Venda) obj;
		if (idVenda == null) {
			if (other.idVenda != null)
				return false;
		} else if (!idVenda.equals(other.idVenda))
			return false;
		if (loja == null) {
			if (other.loja != null)
				return false;
		} else if (!loja.equals(other.loja))
			return false;
		if (pdv == null) {
			if (other.pdv != null)
				return false;
		} else if (!pdv.equals(other.pdv))
			return false;
		return true;
	}
	
	
}
