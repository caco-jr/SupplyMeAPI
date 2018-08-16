package br.com.supplyme.SuppleMe.produto;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.supplyme.SuppleMe.estoque.EstoqueService;

@Service
public class ProdutoService {
	public static final String PATH_RESOURCE = "https://www.datakick.org/api/";

	private RestTemplate restTemplate = new RestTemplate();

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private EstoqueService estoqueService;

	// SERVIÇO PARA CADASTRAR UM PRODUTO
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

	//Cria o anuncio no MERCADO LIVRE
	public void criaAnuncio() {
		try {
			String postUrl = "https://api.mercadolibre.com/items?access_token=APP_USR-6110280255098136-081608-969f40eff89c99a17d3a76ccb42e07c6-166987208";

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);

			Produto produto = this.produtoRepository.findById(1).get();
			String descricao = "Marca: " + produto.getBrand() + " Cor: " + produto.getCor() + "Material: "
					+ produto.getMaterial();
			Picture picture = new Picture();
			picture.setSource(
					"http://www.magiaeimaginacao.com.br/1936-thickbox_default/copo-termico-aveludado-mickey.jpg");
			List<Picture> pictures = Arrays.asList(picture);

			Anuncio anuncio = new Anuncio(produto.getName(), "MLB", 20.0, "BRL", 1, "buy_it_now", "bronze", "new",
					descricao, "YOUTUBE_ID_HERE", "SEM GARANTIA", pictures);
			HttpEntity<Anuncio> entity = new HttpEntity<>(anuncio, headers);

			this.restTemplate.exchange(postUrl, HttpMethod.POST, entity,
					new ParameterizedTypeReference<Response>() {
					});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// SERVIÇO PARA LISTAR O PRODUTOS
	public List<Produto> produtos() {
		return this.produtoRepository.findAll();
	}
}
