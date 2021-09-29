package com.hwwh.security;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hwwh.model.UsuarioModel;

public class JWTAuthenticateFilter extends UsernamePasswordAuthenticationFilter {
	

	public static final int TOKEN_EXPIRATION = 600000;
	public static final String TOKEN_PASSWORD = "f59141eb-7914-47ad-919c-00d12eb13b67";
	private static final String APPLICATION_JSON_VALUE = "application/json";
	private final AuthenticationManager _authenticationManager;
	
	public JWTAuthenticateFilter(AuthenticationManager _authenticationManager) {
		this._authenticationManager = _authenticationManager;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {

		try {
			UsuarioModel usuario = new ObjectMapper().readValue(request.getInputStream(), UsuarioModel.class);
			return _authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(usuario.getEmail(), usuario.getPassword()));
		} catch (IOException e) {
			throw new RuntimeException("Falha ao autenticar usuario", e);
		}

	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		User user = (User)authResult.getPrincipal();
		
		String token = JWT.create().
				withSubject(user.getUsername())
				.withExpiresAt(new Date(System.currentTimeMillis() + TOKEN_EXPIRATION))
				.withClaim("roles", user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
				.sign(Algorithm.HMAC512(TOKEN_PASSWORD));
		
		
		Map<String,String> tokens = new HashMap<>();
		tokens.put("acess_token", token);
		response.setContentType(APPLICATION_JSON_VALUE);
		new ObjectMapper().writeValue(response.getOutputStream(), tokens);
	}
	

}
