package com.udea.proint1.microcurriculo.dto;

import java.util.Date;

public class Correquisitos {

	private int id;
	private Materias materia;
	private Materias correquisito;
	private Usuarios modUsuario;
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

	public Materias getMateria() {
		return materia;
	}

	public void setMateria(Materias materia) {
		this.materia = materia;
	}

	public Materias getCorrequisito() {
		return correquisito;
	}

	public void setCorrequisito(Materias correquisito) {
		this.correquisito = correquisito;
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
