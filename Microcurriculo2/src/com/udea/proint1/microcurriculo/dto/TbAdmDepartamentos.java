package com.udea.proint1.microcurriculo.dto;

// Generated 21/10/2014 12:17:56 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * TbAdmDepartamentos generated by hbm2java
 */
public class TbAdmDepartamentos implements java.io.Serializable {

	private int nbIddepartamento;
	private TbAdmPaises tbAdmPaises;
	private String vrNombres;
	private String vrModusuario;
	private Date dtModfecha;
	private Set tbAdmCiudadeses = new HashSet(0);

	public TbAdmDepartamentos() {
	}

	public TbAdmDepartamentos(int nbIddepartamento,
			TbAdmPaises tbAdmPaises) {
		this.nbIddepartamento = nbIddepartamento;
		this.tbAdmPaises = tbAdmPaises;
	}

	public TbAdmDepartamentos(int nbIddepartamento,
			TbAdmPaises tbAdmPaises, String vrNombres, String vrModusuario,
			Date dtModfecha, Set tbAdmCiudadeses) {
		this.nbIddepartamento = nbIddepartamento;
		this.tbAdmPaises = tbAdmPaises;
		this.vrNombres = vrNombres;
		this.vrModusuario = vrModusuario;
		this.dtModfecha = dtModfecha;
		this.tbAdmCiudadeses = tbAdmCiudadeses;
	}

	public int getNbIddepartamento() {
		return this.nbIddepartamento;
	}

	public void setNbIddepartamento(int nbIddepartamento) {
		this.nbIddepartamento = nbIddepartamento;
	}

	public TbAdmPaises getTbAdmPaises() {
		return this.tbAdmPaises;
	}

	public void setTbAdmPaises(TbAdmPaises tbAdmPaises) {
		this.tbAdmPaises = tbAdmPaises;
	}

	public String getVrNombres() {
		return this.vrNombres;
	}

	public void setVrNombres(String vrNombres) {
		this.vrNombres = vrNombres;
	}

	public String getVrModusuario() {
		return this.vrModusuario;
	}

	public void setVrModusuario(String vrModusuario) {
		this.vrModusuario = vrModusuario;
	}

	public Date getDtModfecha() {
		return this.dtModfecha;
	}

	public void setDtModfecha(Date dtModfecha) {
		this.dtModfecha = dtModfecha;
	}

	public Set getTbAdmCiudadeses() {
		return this.tbAdmCiudadeses;
	}

	public void setTbAdmCiudadeses(Set tbAdmCiudadeses) {
		this.tbAdmCiudadeses = tbAdmCiudadeses;
	}

}