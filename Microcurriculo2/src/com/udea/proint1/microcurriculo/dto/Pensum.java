package com.udea.proint1.microcurriculo.dto;

import java.util.Date;

public class Pensum {

	private int idPensum;
	private String Descripcion;
	private Date fechaInicio;
	private Date fechaFin;
	private String modUsuario;
	private Date modFecha;
	
	public Pensum() {
		// TODO Auto-generated constructor stub
	}

	public int getIdPensum() {
		return idPensum;
	}

	public void setIdPensum(int idPensum) {
		this.idPensum = idPensum;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
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

	public void setModFecha(Date modFecha) {
		this.modFecha = modFecha;
	}

	public String getModUsuario() {
		return modUsuario;
	}

	public void setModUsuario(String modUsuario) {
		this.modUsuario = modUsuario;
	}
	
	

}
