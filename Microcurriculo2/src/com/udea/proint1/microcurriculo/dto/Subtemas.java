package com.udea.proint1.microcurriculo.dto;

import java.util.Date;

public class Subtemas {

	private int idSubtema;
	private String descripcion;
	private int tema;
	private String usuario;
	private Date modFecha;
	
	public Subtemas() {
		// TODO Auto-generated constructor stub
	}

	public int getIdSubtema() {
		return idSubtema;
	}

	public void setIdSubtema(int idSubtema) {
		this.idSubtema = idSubtema;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	
	public int getTema() {
		return tema;
	}

	public void setTema(int tema) {
		this.tema = tema;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Date getModFecha() {
		return modFecha;
	}

	public void setModFecha(Date modFecha) {
		this.modFecha = modFecha;
	}

	
}
