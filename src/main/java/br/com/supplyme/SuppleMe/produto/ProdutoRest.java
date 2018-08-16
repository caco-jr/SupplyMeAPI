package br.com.supplyme.SuppleMe.produto;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/produto")
public class ProdutoRest {
	
	Logger logger = Logger.getLogger(ProdutoRest.class);
	
	@Autowired
	private ProdutoService produtoService;

	//CADASTRAR UM PRODUTO ATRAVÉS DA API EAN
	@GetMapping(value = "/cadastro/{ean}")
	public void cadastrar(@PathVariable("ean") String ean) {
		try {
			logger.info("EAN: " + ean);
			this.produtoService.cadastrarProduto(ean);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//LISTA TODOS OS PRODUTOS
	@GetMapping(value = "/produtos")
	public ResponseEntity<?> produtos() {
		try {
			return ResponseEntity.ok(this.produtoService.produtos());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.badRequest().build();
	}
	
	//Cria o anuncio no ML
	@GetMapping(value = "/anuncio")
	public void anuncio(){
		this.produtoService.criaAnuncio();
	}

}
