package br.com.ths.ctrlFinan.dtos;

import java.util.Date;

import br.com.ths.ctrlFinan.Entities.ItensLancamento;
import br.com.ths.ctrlFinan.Entities.SubItemLancamento;
import org.springframework.beans.BeanUtils;

public class SubItemLancamentoDTO {

	
	private Long id;
	private ItensLancamento idItensLancamento;
	private String descricaoSub;
	private Date dataLancada;
	private Double valorLancada;
	
	public SubItemLancamentoDTO() {}
	
	public SubItemLancamentoDTO(Long id, ItensLancamento idItensLancamento, String descricaoSub, Date dataLancada,
			Double valorLancada) {
		this.id = id;
		this.idItensLancamento = idItensLancamento;
		this.descricaoSub = descricaoSub;
		this.dataLancada = dataLancada;
		this.valorLancada = valorLancada;
	}
	public SubItemLancamentoDTO(SubItemLancamento entity) {
		BeanUtils.copyProperties(entity,this);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ItensLancamento getIdItensLancamento() {
		return idItensLancamento;
	}

	public void setIdItensLancamento(ItensLancamento idItensLancamento) {
		this.idItensLancamento = idItensLancamento;
	}

	public String getDescricaoSub() {
		return descricaoSub;
	}

	public void setDescricaoSub(String descricaoSub) {
		this.descricaoSub = descricaoSub;
	}

	public Date getDataLancada() {
		return dataLancada;
	}

	public void setDataLancada(Date dataLancada) {
		this.dataLancada = dataLancada;
	}

	public Double getValorLancada() {
		return valorLancada;
	}

	public void setValorLancada(Double valorLancada) {
		this.valorLancada = valorLancada;
	}
}
