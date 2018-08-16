package br.com.supplyme.SuppleMe.mercadolivre;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import org.apache.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
public class MercadoLivreService {

	Logger logger = Logger.getLogger(MercadoLivreService.class);

	static String PATH_OAUTH = "https://api.mercadolibre.com/oauth/token";

	static Long CLIENT_ID = 6110280255098136L;

	static String CLIENT_KEY = "H4oioUq8cOj0hzC7kJNaw9q5yhmPjzQ5";

	static String redirect = "https://supply-me-api.herokuapp.com/mercadolivre/redirect";

	private Client client = ClientBuilder.newClient();

	private RestTemplate restTemplate = new RestTemplate();

	public void cadastrarProduto(String code) {
		try {

			logger.info("cadastrarProduto() -> CODE " + code);

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

			MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
			map.add("grant_type", "authorization_code");
			map.add("client_id", CLIENT_ID.toString());
			map.add("client_secret", CLIENT_KEY);
			map.add("redirect_url", redirect);
			map.add("code", code);

			logger.info("MAP -> VALUES -> " + map.get("grant_type") + map.get("client_id") + map.get("client_secret")
					+ map.get("redirect_url") + map.get("code"));

			HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map,
					headers);

			ResponseEntity<String> response = restTemplate.postForEntity(PATH_OAUTH, request, String.class);

			logger.info("JSON -> " + response.getBody());

		} catch (Exception e) {
			logger.info("ERROR -> " + e.getLocalizedMessage());
			e.printStackTrace();
		}
	}
}
