package com.hwwh.data.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.hwwh.model.UsuarioModel;
import com.hwwh.repository.UsuarioRepository;

@Component
public class DetalheUsuarioServiceImpl implements UserDetailsService {

	private final UsuarioRepository _repository;
	
	public DetalheUsuarioServiceImpl(UsuarioRepository _repository) {
		this._repository = _repository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<UsuarioModel> user = _repository.findByemail(username);
		
		if(user.isEmpty()) {
			throw new UsernameNotFoundException("Usuário " + username + " não encontrado");
		}
		
		Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
		user.get().getRules().forEach(role -> {
			authorities.add(new SimpleGrantedAuthority(role.getRule()));
		 });
				
		return new org.springframework.security.core.userdetails.User(user.get().getEmail(), user.get().getPassword(), authorities);
	}	

}
