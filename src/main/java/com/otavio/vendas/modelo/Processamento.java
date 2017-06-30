package com.otavio.vendas.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tb_processamento")
public class Processamento implements Serializable {

	private static final long serialVersionUID = -523778276305938606L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProcessamento;

	@Temporal(TemporalType.TIMESTAMP)
	private Date data;

	@Enumerated(EnumType.STRING)
	private Status status = Status.PENDENTE;

	private Integer loja;
	private Integer pdv;
    private String nomeArquivo;

	public Long getIdProcessamento() {
		return idProcessamento;
	}

	public void setIdProcessamento(Long idProcessamento) {
		this.idProcessamento = idProcessamento;
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

	public String getNomeArquivo() {
		return nomeArquivo;
	}

	public void setNomeArquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idProcessamento == null) ? 0 : idProcessamento.hashCode());
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
		Processamento other = (Processamento) obj;
		if (idProcessamento == null) {
			if (other.idProcessamento != null)
				return false;
		} else if (!idProcessamento.equals(other.idProcessamento))
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
