package br.com.supplyme.SuppleMe.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.supplyme.SuppleMe.model.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Long>{
	
}
