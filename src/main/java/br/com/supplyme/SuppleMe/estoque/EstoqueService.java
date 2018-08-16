package br.com.supplyme.SuppleMe.estoque;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.supplyme.SuppleMe.mercadolivre.MercadoLivreService;

@Service
public class EstoqueService {

	Logger logger = Logger.getLogger(Estoque.class);

	@Autowired
	private EstoqueRepository estoqueRepository;

	//SERVIÇO PARA DESCONTAR A QTD DE ESTOQUE
	public void descontaEstoque(int idProduto, int qtd) {
		Estoque estoques = this.estoqueRepository.findByProduto(idProduto);

		if (estoques != null) {
			int qtdFinal = estoques.getQuantidade() - qtd;
			estoques.setQuantidade(qtdFinal);
			this.estoqueRepository.save(estoques);
		}
	}

	//SERVIÇO QUE RETORNA A QTD DE ESTOQUE DE UM DETERMINADO PRODUTO
	public Integer estoqueQuantidade(int idProduto) {
		return this.estoqueRepository.findQuantidadeByProduto(idProduto);
	}

	//SERVIÇO QUE ADICIONA UMA QTD DE ESTOQUE PARA UM DETERMINADO PRODUTO
	public void adiciona(Integer idProduto, Integer qtd) {
		Estoque estoques = this.estoqueRepository.findByProduto(idProduto);
		
		if (estoques != null) {
			int qtdFinal = estoques.getQuantidade() + qtd;
			estoques.setQuantidade(qtdFinal);
			this.estoqueRepository.save(estoques);
		}
	}
}
