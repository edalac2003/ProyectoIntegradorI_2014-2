package com.udea.proint1.microcurriculo.dto;

import java.util.Date;

public class BiblioXUnidad {

	private int id;
	private Unidades unidad;
	private Bibliografia bibliografia;
	private Usuarios modUsuario;
	private Date modFecha;
	
	public BiblioXUnidad() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Unidades getUnidad() {
		return unidad;
	}

	public void setUnidad(Unidades unidad) {
		this.unidad = unidad;
	}

	public Bibliografia getBibliografia() {
		return bibliografia;
	}

	public void setBibliografia(Bibliografia bibliografia) {
		this.bibliografia = bibliografia;
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
