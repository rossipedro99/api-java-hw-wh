package com.hwwh.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hwwh.model.UsuarioModel;

public interface UsuarioRepository extends JpaRepository<UsuarioModel, Integer> {
	
	public Optional<UsuarioModel> findByemail(String email);

}
