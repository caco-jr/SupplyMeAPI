package br.com.supplyme.SuppleMe.rest.controller;

import java.io.File;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.supplyme.SuppleMe.model.Produto;
import br.com.supplyme.SuppleMe.repository.ProdutoRepository;

@CrossOrigin( origins = "*" )
@RestController
@RequestMapping( value = "/produto")
public class ProdutoRestController {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@GetMapping("/test")
	public String test() {
		
		return "Produto OK";
	}
	
	
	@GetMapping("/{id}")
	public Produto buscarProduto(@PathVariable Long id) {
		return produtoRepository.findById(id).orElse(null);
		
	}
	
	@GetMapping("/")
	public Iterable<Produto> listarProdutos() {
		return produtoRepository.findAll();
		
	}
	
	@DeleteMapping("/{id}")
	public Produto deletarProduto(@PathVariable Long id) {
		return produtoRepository.findById(id).orElse(null);
		
	}
}
