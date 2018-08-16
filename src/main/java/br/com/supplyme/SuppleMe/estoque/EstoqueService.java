package br.com.supplyme.SuppleMe.estoque;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstoqueService {

	@Autowired
	private EstoqueRepository estoqueRepository;

	public void descontaEstoque(int idProduto, int qtd) {
		Estoque estoques = this.estoqueRepository.findByProduto(idProduto);

		if (estoques != null) {
			int qtdFinal = estoques.getQuantidade() - qtd;
			estoques.setQuantidade(qtdFinal);
			this.estoqueRepository.save(estoques);
		}
	}

	public Integer estoqueQuantidade(int idProduto) {
		return this.estoqueRepository.findQuantidadeByProduto(idProduto);
	}

	public void adiciona(Integer idProduto, Integer qtd) {
		Estoque estoques = this.estoqueRepository.findByProduto(idProduto);
		
		if (estoques != null) {
			int qtdFinal = estoques.getQuantidade() + qtd;
			estoques.setQuantidade(qtdFinal);
			this.estoqueRepository.save(estoques);
		}
	}
}
