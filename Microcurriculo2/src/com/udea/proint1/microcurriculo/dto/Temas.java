package com.udea.proint1.microcurriculo.dto;

import java.util.Date;

public class Temas {

	private int idTema;
	private String descripcion;
	private int semanasRequeridas;
	private Usuarios modUsuario;
	private Date modFecha;
	
	public Temas() {
		// dUsuarioTODO Auto-generated constructor stub
	}

	public int getIdTema() {
		return idTema;
	}

	public void setIdTema(int idTema) {
		this.idTema = idTema;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getSemanasRequeridas() {
		return semanasRequeridas;
	}

	public void setSemanasRequeridas(int semanasRequeridas) {
		this.semanasRequeridas = semanasRequeridas;
	}

	public Usuarios getModUsuario() {
		return modUsuario;
	}

	public void setModUsuario(Usuarios modUsuario) {
		this.modUsuario = modUsuario;
	}

	public Date getModFecha() {
		return modFecha;
	}

	public void setModFecha(Date modFecha) {
		this.modFecha = modFecha;
	}

	
}
