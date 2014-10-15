package com.udea.proint1.microcurriculo.dto;

import java.util.Date;

public class MicroXSemestre {

	private int id;
	private String microcurriculo;
	private String semestre;
	private String modUsuario;
	private Date modFecha;
	
	public MicroXSemestre() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getModFecha() {
		return modFecha;
	}

	public String getMicrocurriculo() {
		return microcurriculo;
	}

	public void setMicrocurriculo(String microcurriculo) {
		this.microcurriculo = microcurriculo;
	}

	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	public String getModUsuario() {
		return modUsuario;
	}

	public void setModUsuario(String modUsuario) {
		this.modUsuario = modUsuario;
	}

	public void setModFecha(Date modFecha) {
		this.modFecha = modFecha;
	}

	
}
