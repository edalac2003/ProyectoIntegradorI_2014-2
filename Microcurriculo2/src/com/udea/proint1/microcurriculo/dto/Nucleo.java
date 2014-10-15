package com.udea.proint1.microcurriculo.dto;

import java.util.Date;

public class Nucleo {

	private String idNucleo;
	private String nombre;
	private String dependencia;
	private String modUsuario;
	private Date modFecha;
	
	public Nucleo() {
		
	}

	public String getIdNucleo() {
		return idNucleo;
	}

	public void setIdNucleo(String idNucleo) {
		this.idNucleo = idNucleo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDependencia() {
		return dependencia;
	}

	public void setDependencia(String dependencia) {
		this.dependencia = dependencia;
	}

	public String getModUsuario() {
		return modUsuario;
	}

	public void setModUsuario(String modUsuario) {
		this.modUsuario = modUsuario;
	}

	public Date getModFecha() {
		return modFecha;
	}

	public void setModFecha(Date modFecha) {
		this.modFecha = modFecha;
	}

	
}
