package com.udea.proint1.microcurriculo.dto;

import java.util.Date;

public class UnidadesXMicro {

	private int id;
	private String microcurriculo;
	private int unidad;
	private String modUsuario;
	private Date modFecha;
	
	public UnidadesXMicro() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getModFecha() {
		return modFecha;
	}

	public String getMicrocurriculo() {
		return microcurriculo;
	}

	public void setMicrocurriculo(String microcurriculo) {
		this.microcurriculo = microcurriculo;
	}

	public int getUnidad() {
		return unidad;
	}

	public void setUnidad(int unidad) {
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
