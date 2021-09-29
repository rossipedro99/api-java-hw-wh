package com.hwwh.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity(name="Usuario_Dispositivo")
public class UserSystemModel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(
			name = "idUsuario",
			referencedColumnName = "id")
	private UsuarioModel idUsuario;
	@Column(nullable = false)
	private String sistemaOperacional;
	@Column(nullable = false)
	private String processador;
	@Column(nullable = false)
	private String placaDeVideo;
	@Column(nullable = false)
	private String placaMae;
	@Column(nullable = false)
	private String hd;
	@Column(nullable = false)
	private String memoriaRam;
	@Column(nullable = false)
	private String cpuID;
	@Column(nullable = false)
	private String baseBoardID;
	@Column(nullable = false)
	private String hdID;
	@Column(nullable = false)
	private String ramID;
	@Column(nullable = false)
	private String gpuID;
	
	public UserSystemModel(UsuarioModel idUsuario, String sistemaOperacional, String processador, String placaDeVideo,
			String placaMae, String hd, String memoriaRam, String cpuID, String baseBoardID, String hdID, String ramID,
			String gpuID) {
		this.idUsuario = idUsuario;
		this.sistemaOperacional = sistemaOperacional;
		this.processador = processador;
		this.placaDeVideo = placaDeVideo;
		this.placaMae = placaMae;
		this.hd = hd;
		this.memoriaRam = memoriaRam;
		this.cpuID = cpuID;
		this.baseBoardID = baseBoardID;
		this.hdID = hdID;
		this.ramID = ramID;
		this.gpuID = gpuID;
	}

	public UsuarioModel getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(UsuarioModel idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getSistemaOperacional() {
		return sistemaOperacional;
	}

	public void setSistemaOperacional(String sistemaOperacional) {
		this.sistemaOperacional = sistemaOperacional;
	}

	public String getProcessador() {
		return processador;
	}

	public void setProcessador(String processador) {
		this.processador = processador;
	}

	public String getPlacaDeVideo() {
		return placaDeVideo;
	}

	public void setPlacaDeVideo(String placaDeVideo) {
		this.placaDeVideo = placaDeVideo;
	}

	public String getPlacaMae() {
		return placaMae;
	}

	public void setPlacaMae(String placaMae) {
		this.placaMae = placaMae;
	}

	public String getHd() {
		return hd;
	}

	public void setHd(String hd) {
		this.hd = hd;
	}

	public String getMemoriaRam() {
		return memoriaRam;
	}

	public void setMemoriaRam(String memoriaRam) {
		this.memoriaRam = memoriaRam;
	}

	public String getCpuID() {
		return cpuID;
	}

	public void setCpuID(String cpuID) {
		this.cpuID = cpuID;
	}

	public String getBaseBoardID() {
		return baseBoardID;
	}

	public void setBaseBoardID(String baseBoardID) {
		this.baseBoardID = baseBoardID;
	}

	public String getHdID() {
		return hdID;
	}

	public void setHdID(String hdID) {
		this.hdID = hdID;
	}

	public String getRamID() {
		return ramID;
	}

	public void setRamID(String ramID) {
		this.ramID = ramID;
	}

	public String getGpuID() {
		return gpuID;
	}

	public void setGpuID(String gpuID) {
		this.gpuID = gpuID;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}



}
