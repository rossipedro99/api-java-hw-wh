package com.hwwh.security;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.hwwh.data.services.DetalheUsuarioServiceImpl;

@EnableWebSecurity
public class JWTSettings  extends WebSecurityConfigurerAdapter{
	
	private final DetalheUsuarioServiceImpl _usuarioService;
	private final PasswordEncoder _passwordEncoder;
	
	public JWTSettings(DetalheUsuarioServiceImpl _usuarioService, PasswordEncoder _passwordEncoder) {
		this._usuarioService = _usuarioService;
		this._passwordEncoder = _passwordEncoder;
		
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(_usuarioService).passwordEncoder(_passwordEncoder);
	}

	 @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.csrf().disable().authorizeRequests()
	                .antMatchers(HttpMethod.POST, "/login").permitAll()
	                .antMatchers(HttpMethod.POST, "/register").permitAll()
	                .anyRequest().authenticated()
	                .and()
	                .addFilter(new JWTAuthenticateFilter(authenticationManager()))
	                .addFilter(new JWTValidateFilter(authenticationManager()));
	    }
	@Bean
    CorsConfigurationSource corsConfigurationSource() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        CorsConfiguration corsConfiguration = new CorsConfiguration().applyPermitDefaultValues();
        source.registerCorsConfiguration("/**", corsConfiguration);
        return source;
    }
}
