package com.udea.proint1.microcurriculo.dto;

import java.util.Date;

public class UnidadesXMicro {

	private int id;
	private Microcurriculos microcurriculo;
	private Unidades unidad;
	private Usuarios modUsuario;
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

	public Microcurriculos getMicrocurriculo() {
		return microcurriculo;
	}

	public void setMicrocurriculo(Microcurriculos microcurriculo) {
		this.microcurriculo = microcurriculo;
	}

	public Unidades getUnidad() {
		return unidad;
	}

	public void setUnidad(Unidades unidad) {
		this.unidad = unidad;
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
