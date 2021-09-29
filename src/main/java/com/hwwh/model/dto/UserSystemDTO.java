package com.hwwh.model.dto;

import java.io.Serializable;

import com.hwwh.model.UsuarioModel;
import com.sun.istack.NotNull;

public class UserSystemDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private UsuarioModel idUsuario;
	@NotNull
	private String sistemaOperacional;
	@NotNull
	private String processador;
	@NotNull
	private String placaDeVideo;
	@NotNull
	private String placaMae;
	@NotNull
	private String hd;
	@NotNull
	private String memoriaRam;
	@NotNull
	private String cpuID;
	@NotNull
	private String baseBoardID;
	@NotNull
	private String hdID;
	@NotNull
	private String ramID;
	@NotNull
	private String gpuID;
	
	public UserSystemDTO() {

	}

	public UserSystemDTO(UsuarioModel idUsuario, String sistemaOperacional, String processador, String placaDeVideo,
			String placaMae, String hd, String memoriaRam, String cpuID, String baseBoardID, String hdID, String ramID,
			String gpuID) {
		super();
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
