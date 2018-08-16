package br.com.supplyme.SuppleMe.mercadolivre;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/notification")
public class MercadoLivreRest {

	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

}
