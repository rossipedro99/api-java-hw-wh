package com.hwwh.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hwwh.model.UserSystemModel;
import com.hwwh.model.UsuarioModel;
import com.hwwh.model.dto.UserSystemDTO;
import com.hwwh.model.mapper.UserSystemMapper;
import com.hwwh.repository.UserSystemRepository;
import com.hwwh.repository.UsuarioRepository;

@RestController
@RequestMapping("/systems")
public class UsuarioSystemController {
	
	private final UsuarioRepository _repository;
	private final UserSystemRepository _repositorySystem;
	private final UserSystemMapper map;
	
	
	public UsuarioSystemController(UsuarioRepository _repository, UserSystemRepository _repositorySystem,
			UserSystemMapper map) {
		this._repository = _repository;
		this._repositorySystem = _repositorySystem;
		this.map = map;
	}


	@PostMapping("/create")
	@ResponseBody
	public ResponseEntity<UserSystemModel> createUserSystem(@Validated @RequestBody UserSystemDTO dto, Authentication authentication) {
		Optional<UsuarioModel> user = _repository.findByemail(authentication.getName());
		
		dto.setIdUsuario(user.get());
		
		UserSystemModel system = _repositorySystem.save(map.mapUserSystemDTO(dto));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(system);
		
	}
	
	
	

}
