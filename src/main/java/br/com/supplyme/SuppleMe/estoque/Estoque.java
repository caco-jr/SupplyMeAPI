package br.com.supplyme.SuppleMe.estoque;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import br.com.supplyme.SuppleMe.produto.Produto;

@Entity
public class Estoque {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer quantidade;
	@JoinColumn(name = "id_produto")
	private Produto produto;

	public Estoque() {

	}

	public Estoque(Integer id, Integer quantidade, Produto produto) {
		super();
		this.id = id;
		this.quantidade = quantidade;
		this.produto = produto;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}
