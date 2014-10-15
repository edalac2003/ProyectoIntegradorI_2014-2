package com.udea.proint1.microcurriculo.dto;

import java.util.Date;

public class Ciudades {

	private int idCiudad;
	private String nombre;
	private int departamento;
	private String modUsuario;
	private Date modFecha;
	
	public Ciudades() {
		// TODO Auto-generated constructor stub
	}

	public int getIdCiudad() {
		return idCiudad;
	}

	public void setIdCiudad(int idCiudad) {
		this.idCiudad = idCiudad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getModFecha() {
		return modFecha;
	}

	public int getDepartamento() {
		return departamento;
	}

	public void setDepartamento(int departamento) {
		this.departamento = departamento;
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
