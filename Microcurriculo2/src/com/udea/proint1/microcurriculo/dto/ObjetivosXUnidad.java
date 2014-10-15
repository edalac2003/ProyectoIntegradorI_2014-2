package com.udea.proint1.microcurriculo.dto;

import java.util.Date;

public class ObjetivosXUnidad {

	private int id;
	private int unidad;
	private int objetivo;
	private String modUsuario;
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

	public Date getModFecha() {
		return modFecha;
	}

	public int getUnidad() {
		return unidad;
	}

	public void setUnidad(int unidad) {
		this.unidad = unidad;
	}

	public int getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(int objetivo) {
		this.objetivo = objetivo;
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
