package br.com.supplyme.SuppleMe.precificacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PrecificacaoService {
	@Autowired
	private PrecificacaoRepository precificacaoRepository;

	//SERVIÇO PARA ADICIONAR PREÇO FINAL 
	public void adicionaPrecos(Precificacao preci) {
		try {
			preci.setPrecoFinal(preci.getPrecoInicial());
			this.precificacaoRepository.save(preci);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//SERVIÇO DE LISTAR TODOS OS PREÇOS
	public List<Precificacao> recuperaPrecos() {
		return this.precificacaoRepository.findAll();
	}
}
