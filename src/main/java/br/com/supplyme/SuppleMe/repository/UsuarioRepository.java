package br.com.supplyme.SuppleMe.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.supplyme.SuppleMe.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

}