package br.com.ths.ctrlFinan.Entities;

import java.util.Objects;

import br.com.ths.ctrlFinan.enums.TpLancamento;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="ths_itensLancamento")
public class ItensLancamento {

	@Id 
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	private String descricao;
	@Column (name="tp_lancamento")
	private TpLancamento tpLancamento;
	
	@Column (name="st_vlFixo")
	private Boolean statusValorFixo;
	
	@Column (name="vlFixo")
	private Double valorFixo;
	
	@Column (name="vlPrevisto")
	private Double valorPrevisto;
	
	@Column (name="vlReal")
	private Double valorReal;
	
	@Column (name="st_dtFixa")
	private Boolean statusDataFixa;
	
	private Integer diaFixo;
	
	public ItensLancamento() {}
	public ItensLancamento(Long id, String descricao, TpLancamento tpLancamento, Boolean statusValorFixo,
			Double valorFixo, Double valorPrevisto, Double valorReal, Boolean statusDataFixa, Integer diaFixo) {
		this.id = id;
		this.descricao = descricao;
		this.tpLancamento = tpLancamento;
		this.statusValorFixo = statusValorFixo;
		this.valorFixo = valorFixo;
		this.valorPrevisto = valorPrevisto;
		this.valorReal = valorReal;
		this.statusDataFixa = statusDataFixa;
		this.diaFixo = diaFixo;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public TpLancamento getTpLancamento() {
		return tpLancamento;
	}
	public void setTpLancamento(TpLancamento tpLancamento) {
		this.tpLancamento = tpLancamento;
	}
	public Boolean getStatusValorFixo() {
		return statusValorFixo;
	}
	public void setStatusValorFixo(Boolean statusValorFixo) {
		this.statusValorFixo = statusValorFixo;
	}
	public Double getValorFixo() {
		return valorFixo;
	}
	public void setValorFixo(Double valorFixo) {
		this.valorFixo = valorFixo;
	}
	public Double getValorPrevisto() {
		return valorPrevisto;
	}
	public void setValorPrevisto(Double valorPrevisto) {
		this.valorPrevisto = valorPrevisto;
	}
	public Double getValorReal() {
		return valorReal;
	}
	public void setValorReal(Double valorReal) {
		this.valorReal = valorReal;
	}
	public Boolean getStatusDataFixa() {
		return statusDataFixa;
	}
	public void setStatusDataFixa(Boolean statusDataFixa) {
		this.statusDataFixa = statusDataFixa;
	}
	public Integer getDiaFixo() {
		return diaFixo;
	}
	public void setDiaFixo(Integer diaFixo) {
		this.diaFixo = diaFixo;
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
		ItensLancamento other = (ItensLancamento) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
}
