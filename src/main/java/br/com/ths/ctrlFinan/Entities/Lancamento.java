package br.com.ths.ctrlFinan.Entities;

import java.util.Date;
import java.util.Objects;

public class Lancamento {
	
	private Long id;
	private ItensLancamento IdItemLancamento;
	private Integer ano;
	private Integer mes;
	private Date dataLancamento;
	private Double valorLancamento;
	private Date dataCriacao;
	private Date dataAlteracao;
	
	public Lancamento() {}

	public Lancamento(Long id, ItensLancamento idItemLancamento, Integer ano, Integer mes, Date dataLancamento,
			Double valorLancamento, Date dataCriacao, Date dataAlteracao) {
		this.id = id;
		IdItemLancamento = idItemLancamento;
		this.ano = ano;
		this.mes = mes;
		this.dataLancamento = dataLancamento;
		this.valorLancamento = valorLancamento;
		this.dataCriacao = dataCriacao;
		this.dataAlteracao = dataAlteracao;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ItensLancamento getIdItemLancamento() {
		return IdItemLancamento;
	}

	public void setIdItemLancamento(ItensLancamento idItemLancamento) {
		IdItemLancamento = idItemLancamento;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public Integer getMes() {
		return mes;
	}

	public void setMes(Integer mes) {
		this.mes = mes;
	}

	public Date getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(Date dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public Double getValorLancamento() {
		return valorLancamento;
	}

	public void setValorLancamento(Double valorLancamento) {
		this.valorLancamento = valorLancamento;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Date getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(Date dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lancamento other = (Lancamento) obj;
		return Objects.equals(id, other.id);
	}
	
	

}
