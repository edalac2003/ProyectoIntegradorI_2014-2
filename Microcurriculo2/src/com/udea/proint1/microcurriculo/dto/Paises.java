package com.udea.proint1.microcurriculo.dto;

import java.util.Date;

public class Paises {

	private int idPais;
	private int nombre;
	private String modUsuario;
	private Date modFecha;
	
	public Paises() {
		// TODO Auto-generated constructor stub
	}

	public int getIdPais() {
		return idPais;
	}

	public void setIdPais(int idPais) {
		this.idPais = idPais;
	}

	public int getNombre() {
		return nombre;
	}

	public void setNombre(int nombre) {
		this.nombre = nombre;
	}

	public Date getModFecha() {
		return modFecha;
	}

	public void setModFecha(Date modFecha) {
		this.modFecha = modFecha;
	}

	public String getModUsuario() {
		return modUsuario;
	}

	public void setModUsuario(String modUsuario) {
		this.modUsuario = modUsuario;
	}

	
}
