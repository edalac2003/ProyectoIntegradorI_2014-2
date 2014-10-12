package com.udea.proint1.microcurriculo.dto;

import java.util.Date;

public class Semestre {

	private String idSemestre;
	private String descripcion;
	private Date fechaInicio;
	private Date fechaFin;
	private Usuarios modUsuario;
	private Date modFecha;
	
	public Semestre() {
		// TODO Auto-generated constructor stub
	}

	public String getIdSemestre() {
		return idSemestre;
	}

	public void setIdSemestre(String idSemestre) {
		this.idSemestre = idSemestre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
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
