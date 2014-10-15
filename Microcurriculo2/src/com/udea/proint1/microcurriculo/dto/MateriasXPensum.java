package com.udea.proint1.microcurriculo.dto;

import java.util.Date;

public class MateriasXPensum {

	private int id;
	private int pensum;
	private String materia;
	private String modUsuario;
	private Date modFecha;
	
	public MateriasXPensum() {
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

	public int getPensum() {
		return pensum;
	}

	public void setPensum(int pensum) {
		this.pensum = pensum;
	}

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
		this.materia = materia;
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
