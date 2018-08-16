package br.com.supplyme.SuppleMe.estoque;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EstoqueRepository extends JpaRepository<Estoque, Integer>{

	Estoque findByProduto(int id);

	Integer findQuantidadeByProduto(int idProduto);

}
