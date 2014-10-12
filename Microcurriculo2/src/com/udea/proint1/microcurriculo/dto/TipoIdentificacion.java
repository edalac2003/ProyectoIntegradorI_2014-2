package com.udea.proint1.microcurriculo.dto;

import java.util.Date;

public class TipoIdentificacion {
	
	private int idIdentificacion;
	private String descripcion;
	private Usuarios modUsuario;
	private Date modFecha;

	public TipoIdentificacion() {
		// TODO Auto-generated constructor stub
	}

	public int getIdIdentificacion() {
		return idIdentificacion;
	}

	public void setIdIdentificacion(int idIdentificacion) {
		this.idIdentificacion = idIdentificacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
