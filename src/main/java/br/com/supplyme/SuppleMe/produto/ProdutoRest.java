package br.com.supplyme.SuppleMe.produto;

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

	@GetMapping(value = "/produtos")
	public ResponseEntity<?> produtos() {
		try {
			return ResponseEntity.ok(this.produtoService.produtos());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ResponseEntity.badRequest().build();
	}

}
