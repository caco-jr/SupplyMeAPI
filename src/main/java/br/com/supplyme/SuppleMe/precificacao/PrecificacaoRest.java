package br.com.supplyme.SuppleMe.precificacao;

import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/precificacao")
public class PrecificacaoRest {
	
	Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	private PrecificacaoService precificacaoService;
	
	//ENDPOINT PARA SALVAR PRECIFICAÇÃO
	@PostMapping(value = "/salvar")
	public void salvaPrecificacao(@RequestBody Precificacao preci) {
		logger.info("Salvando uma nova precificação");
		this.precificacaoService.adicionaPrecos(preci);
	}
	
	//ENDPOINT PARA RECUPERAR PRECIFICAÇÃO
	@GetMapping(value = "/recuperar")
	public ResponseEntity<?> recuperaPrecificacao(){
		logger.info("Recuperando precificações");
		return ResponseEntity.ok(this.precificacaoService.recuperaPrecos());
	}
}
