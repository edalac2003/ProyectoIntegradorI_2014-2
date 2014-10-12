package com.udea.proint1.microcurriculo.dto;

import java.util.Date;

public class Subtemas {

	private int idSubtema;
	private String descripcion;
	private Temas tema;
	private Usuarios usuario;
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

	public Temas getTema() {
		return tema;
	}

	public void setTema(Temas tema) {
		this.tema = tema;
	}

	public Usuarios getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}

	public Date getModFecha() {
		return modFecha;
	}

	public void setModFecha(Date modFecha) {
		this.modFecha = modFecha;
	}

	
}
