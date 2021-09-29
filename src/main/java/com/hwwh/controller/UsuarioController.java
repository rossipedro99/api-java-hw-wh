package com.hwwh.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hwwh.model.UsuarioModel;
import com.hwwh.repository.UsuarioRepository;

@RestController
@RequestMapping()
public class UsuarioController {
	
	private final UsuarioRepository _repository;
	private final PasswordEncoder _pass;
	
	public UsuarioController(UsuarioRepository repository, PasswordEncoder pass) {
		this._repository = repository;
		this._pass = pass;
	}

	@PostMapping("/register")
	public ResponseEntity<String> createUser(@RequestBody UsuarioModel user) {
		user.setPassword(_pass.encode(user.getPassword()));
		_repository.save(user);
		return ResponseEntity.status(HttpStatus.CREATED).body("Usuário Criado com sucesso");
	}

}
