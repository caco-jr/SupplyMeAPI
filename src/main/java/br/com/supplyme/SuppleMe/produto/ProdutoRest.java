package br.com.supplyme.SuppleMe.produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/produto")
public class ProdutoRest {
	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping(value = "/cadastro/{ean}")
	public void cadastrar(@PathVariable("ean") String ean) {
		try {
			this.produtoService.cadastrarProduto(ean);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
