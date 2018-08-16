package br.com.supplyme.SuppleMe.rest.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin( origins = "*" )
@RestController
@RequestMapping( value = "/usuario")
public class UsuarioRestController {
	
	@GetMapping("test")
	public String helloWorld() {
		return "Hello World";
	}
}
