package br.com.supplyme.SuppleMe.produto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.supplyme.SuppleMe.estoque.EstoqueRepository;
import br.com.supplyme.SuppleMe.estoque.EstoqueService;

@Service
public class ProdutoService {
	public static final String PATH_RESOURCE = "https://www.datakick.org/api/";

	private RestTemplate restTemplate = new RestTemplate();
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstoqueService estoqueService;
	
	public void cadastrarProduto(String ean) {
		try {
			String postUrl = PATH_RESOURCE.concat("items/").concat(ean);

			Produto produto = new Produto(null, ean, "Disney", "Copo Mickey", "Plástico", "Disney", "Preto",
					"http://www.magiaeimaginacao.com.br/1936-thickbox_default/copo-termico-aveludado-mickey.jpg");

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			HttpEntity<Produto> entity = new HttpEntity<>(produto, headers);

			ResponseEntity<Produto> produtoResponse = this.restTemplate.exchange(postUrl, HttpMethod.PUT, entity,
					new ParameterizedTypeReference<Produto>() {
					});
			
			if (produtoResponse.getBody() != null) {
				this.produtoRepository.save(produtoResponse.getBody());
				this.estoqueService.adiciona(produto.getId(), 1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Produto> produtos() {
		return this.produtoRepository.findAll();
	}
}
