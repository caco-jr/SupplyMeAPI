package br.com.supplyme.SuppleMe.mercadolivre;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

@Service
public class MercadoLivreService {

	static String PATH_OAUTH = "https://api.mercadolibre.com/oauth/token";

	static Long CLIENT_ID = 6110280255098136L;

	static String CLIENT_KEY = "H4oioUq8cOj0hzC7kJNaw9q5yhmPjzQ5";

	private Client client = ClientBuilder.newClient();

	public void cadastrarProduto(String code, String operation) {
		try {

			WebTarget getAccessToken = client.target(PATH_OAUTH);
			Response response = null;
			response = getAccessToken.queryParam("grant_type", "authorization_code").queryParam("client_id", CLIENT_ID)
					.queryParam("client_secret", CLIENT_KEY).queryParam("redirect_uri", "www.google.com")
					.queryParam("code", code).request().post(null);

			System.out.println("BODY: " + response.getEntity());

			response.readEntity(String.class);

			if (response != null) {
				response.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
