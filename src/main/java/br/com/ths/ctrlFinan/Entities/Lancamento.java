package br.com.ths.ctrlFinan.Entities;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table (name="ths_lancamentos")
public class Lancamento {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer ano;
	private Integer mes;
	@Column (name="dtlancamento")
	private Date dataLancamento;
	@Column (name="vllancamento")
	private Double valorLancamento;
	
	@ManyToOne
	@JoinColumn(name="id_itemlancamento")
	private ItensLancamento IdItemLancamento;
	
	@Column (name="dtcriacao", updatable = false)
	private LocalDate dataCriacao;
	@Column (name="dtalteracao")
	private LocalDate dataAlteracao;
	
	public Lancamento() {}

	public Lancamento(Long id, Integer ano, Integer mes, Date dataLancamento,
			Double valorLancamento,ItensLancamento idItemLancamento) {
		this.id = id;
		this.ano = ano;
		this.mes = mes;
		this.dataLancamento = dataLancamento;
		this.valorLancamento = valorLancamento;
		IdItemLancamento = idItemLancamento;
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

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}
	
	public LocalDate getDataAlteracao() {
		return dataAlteracao;
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
	
	@PrePersist
	public void obterDataAtualCriacao() {
		this.dataCriacao=LocalDate.now();
	}
	@PrePersist
	public void obterDataAtualAtualizacao() {
		this.dataCriacao=LocalDate.now();
	}

}
