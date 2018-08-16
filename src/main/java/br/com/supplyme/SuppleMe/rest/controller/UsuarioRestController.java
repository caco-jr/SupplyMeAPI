package br.com.supplyme.SuppleMe.rest.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.supplyme.SuppleMe.model.Usuario;
import br.com.supplyme.SuppleMe.repository.UsuarioRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/usuario")
public class UsuarioRestController {

	Logger logger = Logger.getLogger(UsuarioRestController.class);

	@Autowired
	private UsuarioRepository usuarioRepository;

	//ENDPOINT PARA CADASTRAR USUÁRIO
	@PostMapping("/cadastrar")
	public void cadastrar(Usuario usuario) {

		try {
			logger.info("Cadastrando um novo usuário");
			usuarioRepository.save(usuario);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//ENDPOINT PARA LISTAR TODOS OS USUÁRIOS
	@GetMapping("/")
	public Iterable<Usuario> listarProdutos() {
		
		logger.info("Listando todos os usuários");
		
		return usuarioRepository.findAll();
		
	}

	//ENDPOINT PARA BUSCAR UMA DETERMINADO USUÁRIO
	@GetMapping("/{id}")
	public Usuario buscarUsuario(@PathVariable Long id) {

		logger.info("Buscando o usuário ID: " + id);

		return usuarioRepository.findById(id).orElse(null);
	}
	
	//ENDPOINT PARA DELETAR UM USUÁRIO
	@DeleteMapping("/{id}")
	public void deletarProduto(@PathVariable Long id) {

		logger.info("Deletando o usuário ID: " + id);
		
		usuarioRepository.deleteById(id);
	}

}
