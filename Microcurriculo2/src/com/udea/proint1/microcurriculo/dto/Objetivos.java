package com.udea.proint1.microcurriculo.dto;

import java.util.Date;

public class Objetivos {

	private int idObjetivos;
	private String descripcion;
	private boolean tipo;
	private Usuarios modUsuario;
	private Date modFecha;
	
	public Objetivos() {
		// TODO Auto-generated constructor stub
	}

	public int getIdObjetivos() {
		return idObjetivos;
	}

	public void setIdObjetivos(int idObjetivos) {
		this.idObjetivos = idObjetivos;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isTipo() {
		return tipo;
	}

	public void setTipo(boolean tipo) {
		this.tipo = tipo;
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
