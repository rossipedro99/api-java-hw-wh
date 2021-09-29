package com.hwwh.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity(name="Usuario")
public class UsuarioModel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(unique = true,nullable = false)
	private String email;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)
	private String nomeCompleto;
	@Column(nullable = false)
	private int ddd;
	@Column(unique = true,nullable = false)
	@NotNull
	private String telefone;
	@ManyToMany(fetch = FetchType.EAGER)
	private Collection<RulesModel> rules = new ArrayList<>();
	@CreationTimestamp
	@Column(nullable = false)
	private Date dataCriacao;
	@UpdateTimestamp
	private Date dataUpdate;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	public void setPassword(String password) {
		this.password = password;
	}
	public Collection<RulesModel> getRules() {
		return rules;
	}
	public void setRules(Collection<RulesModel> rules) {
		this.rules = rules;
	}
	public String getNomeCompleto() {
		return nomeCompleto;
	}
	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}
	public int getDdd() {
		return ddd;
	}
	public void setDdd(int ddd) {
		this.ddd = ddd;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public Integer getId() {
		return id;
	}
	
	
}
