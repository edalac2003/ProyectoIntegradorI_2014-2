package com.udea.proint1.microcurriculo.dto;

import java.util.Date;

public class Dependencia {

	private int idDependencia;
	private String nombre;
	private UnidadAcademica unidad;
	private Usuarios modUsuario;
	private Date modFecha;
	
	public Dependencia() {
		
	}

	public int getIdDependencia() {
		return idDependencia;
	}

	public void setIdDependencia(int idDependencia) {
		this.idDependencia = idDependencia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public UnidadAcademica getUnidad() {
		return unidad;
	}

	public void setUnidad(UnidadAcademica unidad) {
		this.unidad = unidad;
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
