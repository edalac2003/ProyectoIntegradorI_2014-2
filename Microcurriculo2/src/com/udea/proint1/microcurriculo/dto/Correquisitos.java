package com.udea.proint1.microcurriculo.dto;

import java.util.Date;

public class Correquisitos {

	private int id;
	private String materia;
	private String correquisito;
	private String modUsuario;
	private Date modFecha;
	
	public Correquisitos() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setModFecha(Date modFecha) {
		this.modFecha = modFecha;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
	}

	public String getCorrequisito() {
		return correquisito;
	}

	public void setCorrequisito(String correquisito) {
		this.correquisito = correquisito;
	}

	public String getModUsuario() {
		return modUsuario;
	}

	public void setModUsuario(String modUsuario) {
		this.modUsuario = modUsuario;
	}

	public Date getModFecha() {
		return modFecha;
	}

	
}
