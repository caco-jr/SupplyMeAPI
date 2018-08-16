package br.com.supplyme.SuppleMe.precificacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/precificacao")
public class PrecificacaoRest {

	@Autowired
	private PrecificacaoService precificacaoService;
	
	@PostMapping(value = "/salvar")
	public void salvaPrecificacao(@RequestBody Precificacao preci) {
		this.precificacaoService.adicionaPrecos(preci);
	}
}
