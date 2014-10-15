package com.udea.proint1.microcurriculo.dto;

import java.util.Date;

public class TemasXUnidad {

	private int id;
	private int tema;
	private int unidad;
	private String modUsuario;
	private Date modFecha;
	
	public TemasXUnidad() {
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

	public int getTema() {
		return tema;
	}

	public void setTema(int tema) {
		this.tema = tema;
	}

	public int getUnidad() {
		return unidad;
	}

	public void setUnidad(int unidad) {
		this.unidad = unidad;
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
