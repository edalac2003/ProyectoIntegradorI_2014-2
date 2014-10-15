package com.udea.proint1.microcurriculo.dto;

import java.util.Date;

public class Microcurriculos {

	private String idMicrocurriculo;
	private String materia;
	private String resumen;
	private String metodologia;
	private String semestre;
	private String responsable;
	private String modUsuario;
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

	public String getMateria() {
		return materia;
	}

	public void setMateria(String materia) {
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

	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	public String getResponsable() {
		return responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}

	public String getModUsuario() {
		return modUsuario;
	}

	public void setModUsuario(String modUsuario) {
		this.modUsuario = modUsuario;
	}

	public Date getModFecha() {
		return modFecha;
	}

	public void setModFecha(Date modFecha) {
		this.modFecha = modFecha;
	}
	
	

}
