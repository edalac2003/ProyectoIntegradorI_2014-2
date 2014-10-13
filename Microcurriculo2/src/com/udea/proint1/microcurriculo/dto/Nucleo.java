package com.udea.proint1.microcurriculo.dto;

import java.util.Date;

public class Nucleo {

	private String idNucleo;
	private String nombre;
	private Dependencia dependencia;
	private Usuarios modUsuario;
	private Date modFecha;
	
	public Nucleo() {
		
	}

	public String getNombre() {
		return nombre;
	}

	public Dependencia getDependencia() {
		return dependencia;
	}

	public String getIdNucleo() {
		return idNucleo;
	}

	public void setIdNucleo(String idNucleo) {
		this.idNucleo = idNucleo;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setDependencia(Dependencia dependencia) {
		this.dependencia = dependencia;
	}

	public Date getModFecha() {
		return modFecha;
	}

	public Usuarios getModUsuario() {
		return modUsuario;
	}

	public void setModUsuario(Usuarios modUsuario) {
		this.modUsuario = modUsuario;
	}

	public void setModFecha(Date modFecha) {
		this.modFecha = modFecha;
	}

	
}
