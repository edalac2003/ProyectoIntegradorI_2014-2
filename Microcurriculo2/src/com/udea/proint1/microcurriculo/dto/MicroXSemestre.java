package com.udea.proint1.microcurriculo.dto;

import java.util.Date;

public class MicroXSemestre {

	private int id;
	private Microcurriculos microcurriculo;
	private Semestre semestre;
	private Usuarios modUsuario;
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

	public Microcurriculos getMicrocurriculo() {
		return microcurriculo;
	}

	public void setMicrocurriculo(Microcurriculos microcurriculo) {
		this.microcurriculo = microcurriculo;
	}

	public Semestre getSemestre() {
		return semestre;
	}

	public void setSemestre(Semestre semestre) {
		this.semestre = semestre;
	}

	public Usuarios getModUsuario() {
		return modUsuario;
	}

	public void setModUsuario(Usuarios modUsuario) {
		this.modUsuario = modUsuario;
	}

	public Date getModFecha() {
		return modFecha;
	}

	public void setModFecha(Date modFecha) {
		this.modFecha = modFecha;
	}

	
}
