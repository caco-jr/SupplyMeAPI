package br.com.supplyme.SuppleMe.mercadolivre;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/mercadolivre")
public class MercadoLivreRest {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private MercadoLivreService mercadoLivreService;

	@GetMapping(path = "/redirect")
	public String redirectMeli(@RequestParam("code") String subscriptionCode) {
		LOGGER.info("RedirectMeli() -> CODE " + subscriptionCode);
		
		this.mercadoLivreService.getAcessToken(subscriptionCode);
		
		
		return "https://supply-me-api.herokuapp.com/";
	}
	
	@GetMapping(path = "/notification")
	public String notificationMeli() {
		LOGGER.info("Notification received");
		return "https://supply-me-api.herokuapp.com/";
	}

}
