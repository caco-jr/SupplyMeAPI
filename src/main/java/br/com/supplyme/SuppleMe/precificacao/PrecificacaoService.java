package br.com.supplyme.SuppleMe.precificacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrecificacaoService {
	@Autowired
	private PrecificacaoRepository precificacaoRepository;

	public void adicionaPrecos(Precificacao preci) {
		try {
			this.precificacaoRepository.save(preci);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
