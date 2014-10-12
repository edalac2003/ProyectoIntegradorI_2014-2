package com.udea.proint1.microcurriculo.dto;

import java.util.Date;

public class Prerrequisitos {

	private int id;
	private Materias materia;
	private Materias prerrequisito;
	private Usuarios modUsuario;
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

	public Materias getMateria() {
		return materia;
	}

	public void setMateria(Materias materia) {
		this.materia = materia;
	}

	public Materias getPrerrequisito() {
		return prerrequisito;
	}

	public void setPrerrequisito(Materias prerrequisito) {
		this.prerrequisito = prerrequisito;
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
