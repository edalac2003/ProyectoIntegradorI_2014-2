package com.udea.proint1.microcurriculo.dto;

import java.util.Date;

public class Microcurriculos {

	private String idMicrocurriculo;
	private Materias materia;
	private String resumen;
	private String metodologia;
	private Semestre semestre;
	private Persona responsable;
	private Usuarios modUsuario;
	private Date modFecha;
	
	public Microcurriculos() {
		// TODO Auto-generated constructor stub
	}

	public String getIdMicrocurriculo() {
		return idMicrocurriculo;
	}

	public void setIdMicrocurriculo(String idMicrocurriculo) {
		this.idMicrocurriculo = idMicrocurriculo;
	}

	public Materias getMateria() {
		return materia;
	}

	public void setMateria(Materias materia) {
		this.materia = materia;
	}

	public String getResumen() {
		return resumen;
	}

	public void setResumen(String resumen) {
		this.resumen = resumen;
	}

	public String getMetodologia() {
		return metodologia;
	}

	public void setMetodologia(String metodologia) {
		this.metodologia = metodologia;
	}

	public Semestre getSemestre() {
		return semestre;
	}

	public void setSemestre(Semestre semestre) {
		this.semestre = semestre;
	}

	public Persona getResponsable() {
		return responsable;
	}

	public void setResponsable(Persona responsable) {
		this.responsable = responsable;
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
