package br.com.supplyme.SuppleMe.precificacao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
public class Precificacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore(value = true)
	private Integer id;
	@JsonProperty(value = "preco_inicial")
	private Double precoInicial;
	@JsonProperty(value = "qtd_produto")
	private Integer qtdProduto;
	@JsonProperty(value = "porcentagem_produto")
	private Double porcentagemProduto;
	@JsonProperty(value = "total_desconto", access = Access.READ_ONLY)
	private Double valorTotalDesconto;
	@JsonProperty(value = "porcentagem_total", access = Access.READ_ONLY)
	private Double porcentagemTotal;
	@JsonProperty(value = "preco_final", access = Access.READ_ONLY)
	private Double precoFinal;
	
	public Precificacao(Integer id, Double precoInicial, Integer qtdProduto, Double porcentagemProduto,
			Double valorTotalDesconto, Double porcentagemTotal, Double precoFinal) {
		super();
		this.id = id;
		this.precoInicial = precoInicial;
		this.qtdProduto = qtdProduto;
		this.porcentagemProduto = porcentagemProduto;
		this.valorTotalDesconto = valorTotalDesconto;
		this.porcentagemTotal = porcentagemTotal;
		this.precoFinal = precoFinal;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getPrecoInicial() {
		return precoInicial;
	}

	public void setPrecoInicial(Double precoInicial) {
		this.precoInicial = precoInicial;
	}

	public Integer getQtdProduto() {
		return qtdProduto;
	}

	public void setQtdProduto(Integer qtdProduto) {
		this.qtdProduto = qtdProduto;
	}

	public Double getPorcentagemProduto() {
		return porcentagemProduto;
	}

	public void setPorcentagemProduto(Double porcentagemProduto) {
		this.porcentagemProduto = porcentagemProduto;
	}

	public Double getValorTotalDesconto() {
		return valorTotalDesconto;
	}

	public void setValorTotalDesconto(Double valorTotalDesconto) {
		this.valorTotalDesconto = valorTotalDesconto;
	}

	public Double getPorcentagemTotal() {
		return porcentagemTotal;
	}

	public void setPorcentagemTotal(Double porcentagemTotal) {
		this.porcentagemTotal = porcentagemTotal;
	}

	public Double getPrecoFinal() {
		return precoFinal;
	}

	public void setPrecoFinal(Double precoFinal) {
		this.precoFinal = precoFinal;
	}
}
