package com.udea.proint1.microcurriculo.dto;

import java.util.Date;

public class TipoPersona {

	private int idPersona;
	private String descripcion;
	private String modUsuario;
	private Date modFecha;
	
	public TipoPersona() {
		// TODO Auto-generated constructor stub
	}

	public int getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
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
