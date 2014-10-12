package com.udea.proint1.microcurriculo.dto;

import java.util.Date;

public class DocentesXNucleo {

	private int id;
	private Nucleo nucleo;
	private Persona docente;
	private Usuarios modUsuario;
	private Date modFecha;
	
	public DocentesXNucleo() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Nucleo getNucleo() {
		return nucleo;
	}

	public void setNucleo(Nucleo nucleo) {
		this.nucleo = nucleo;
	}

	public Persona getDocente() {
		return docente;
	}

	public void setDocente(Persona docente) {
		this.docente = docente;
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
