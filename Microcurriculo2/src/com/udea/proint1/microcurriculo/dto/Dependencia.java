package com.udea.proint1.microcurriculo.dto;

import java.util.Date;

public class Dependencia {

	private String idDependencia;
	private String nombre;
	private String unidad;
	private String modUsuario;
	private Date modFecha;
	
	public Dependencia() {
		
	}

	public String getNombre() {
		return nombre;
	}

	public String getIdDependencia() {
		return idDependencia;
	}

	public void setIdDependencia(String idDependencia) {
		this.idDependencia = idDependencia;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getModFecha() {
		return modFecha;
	}

	public String getUnidad() {
		return unidad;
	}

	public void setUnidad(String unidad) {
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
