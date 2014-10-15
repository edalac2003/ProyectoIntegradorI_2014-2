package com.udea.proint1.microcurriculo.dto;

import java.util.Date;

public class Prerrequisitos {

	private int id;
	private String materia;
	private String prerrequisito;
	private String modUsuario;
	private Date modFecha;
	
	public Prerrequisitos() {
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

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public String getPrerrequisito() {
		return prerrequisito;
	}

	public void setPrerrequisito(String prerrequisito) {
		this.prerrequisito = prerrequisito;
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
