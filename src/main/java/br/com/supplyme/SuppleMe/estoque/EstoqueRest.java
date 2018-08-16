package br.com.supplyme.SuppleMe.estoque;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.supplyme.SuppleMe.mercadolivre.MercadoLivreService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/estoque")
public class EstoqueRest {

	Logger logger = Logger.getLogger(EstoqueRest.class);

	@Autowired
	private EstoqueService estoqueService;

	//ENDPOINT PARA DESCONTAR UMA QTD DO ESTOQUE DE UM PRODUTO
	@GetMapping(value = "/desconto/{idProduto}/{qtd}")
	public void descontaEstoque(@PathVariable("idProduto") Integer idProduto, @PathVariable("qtd") Integer qtd) {
		try {
			this.estoqueService.descontaEstoque(idProduto, qtd);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//END
	@GetMapping(value = "/quantidade/{idProduto}")
	public ResponseEntity<?> quantidade(@PathVariable("idProduto") Integer idProduto) {
		try {
			return ResponseEntity.ok(this.estoqueService.estoqueQuantidade(idProduto));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.badRequest().build();
	}
	
	@GetMapping(value = "/adiciona/{idProduto}/{qtd}")
	public void adicionar(@PathVariable("idProduto") Integer idProduto, @PathVariable("qtd") Integer qtd) {
		try {
			this.estoqueService.adiciona(idProduto, qtd);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
