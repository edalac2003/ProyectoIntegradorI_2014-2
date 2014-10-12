package com.udea.proint1.microcurriculo.dto;

import java.util.Date;

public class Nucleo {

	private int nucleo;
	private String nombre;
	private Dependencia dependencia;
	private Usuarios modUsuario;
	private Date modFecha;
	
	public Nucleo() {
		
	}

	public int getNucleo() {
		return nucleo;
	}

	public void setNucleo(int nucleo) {
		this.nucleo = nucleo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Dependencia getDependencia() {
		return dependencia;
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
