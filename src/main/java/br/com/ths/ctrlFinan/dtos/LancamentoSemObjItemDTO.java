package br.com.ths.ctrlFinan.dtos;

import java.util.Date;
import java.util.Objects;

import br.com.ths.ctrlFinan.Entities.Lancamento;

public class LancamentoSemObjItemDTO {

	
	private Long id;
	private Integer ano;
	private Integer mes;
	private Date dataLancamento;
	private Double valorLancamento;
	private Long idItemLancamento;
	
	public LancamentoSemObjItemDTO() {}
	
	public LancamentoSemObjItemDTO( Integer ano, Integer mes, Date dataLancamento,
			Double valorLancamento, Long idItemLancamento) {
		this.ano = ano;
		this.mes = mes;
		this.dataLancamento = dataLancamento;
		this.valorLancamento = valorLancamento;
		this.idItemLancamento = idItemLancamento;
	}

	public LancamentoSemObjItemDTO(Lancamento entity) {
		this.id = entity.getId();
		this.ano = entity.getAno();
		this.mes = entity.getMes();
		this.dataLancamento = entity.getDataLancamento();
		this.valorLancamento = entity.getValorLancamento();
		this.idItemLancamento = entity.getIdItemLancamento().getId();
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Long getIdItemLancamento() {
		return idItemLancamento;
	}

	public void setIdItemLancamento(Long idItemLancamento) {
		this.idItemLancamento = idItemLancamento;
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
		LancamentoSemObjItemDTO other = (LancamentoSemObjItemDTO) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
	
	
}
