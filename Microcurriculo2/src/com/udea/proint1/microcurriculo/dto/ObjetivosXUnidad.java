package com.udea.proint1.microcurriculo.dto;

import java.util.Date;

public class ObjetivosXUnidad {

	private int id;
	private Unidades unidad;
	private Objetivos objetivo;
	private Usuarios modUsuario;
	private Date modFecha;
	
	public ObjetivosXUnidad() {
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

	public Objetivos getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(Objetivos objetivo) {
		this.objetivo = objetivo;
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
