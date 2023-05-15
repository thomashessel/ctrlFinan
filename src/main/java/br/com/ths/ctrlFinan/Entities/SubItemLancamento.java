package br.com.ths.ctrlFinan.Entities;

import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name="ths_subitemlancamento")
public class SubItemLancamento {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="id_itemlancamento")
	private ItensLancamento idItensLancamento;
	
	@Column (name="descricaosub")
	private String descricaoSub;
	
	@Column (name="dt_lancada")
	private Date dataLancada;
	
	@Column (name="vl_lancada")
	private Double valorLancada;
	
	public SubItemLancamento() {}

	public SubItemLancamento(Long id, ItensLancamento idItensLancamento, String descricaoSub, Date dataLancada,
			Double valorLancada) {
		this.id = id;
		this.idItensLancamento = idItensLancamento;
		this.descricaoSub = descricaoSub;
		this.dataLancada = dataLancada;
		this.valorLancada = valorLancada;
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
		SubItemLancamento other = (SubItemLancamento) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
