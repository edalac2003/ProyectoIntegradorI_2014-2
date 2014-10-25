package com.udea.proint1.microcurriculo.dto;

// Generated 21/10/2014 12:17:56 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * TbAdmCiudades generated by hbm2java
 */
public class TbAdmCiudades implements java.io.Serializable {

	private int nbIdciudad;
	private TbAdmDepartamentos tbAdmDepartamentos;
	private String vrNombre;
	private String vrModusuario;
	private Date dtModfecha;
	private Set tbAdmPersonas = new HashSet(0);

	public TbAdmCiudades() {
	}

	public TbAdmCiudades(int nbIdciudad,
			TbAdmDepartamentos tbAdmDepartamentos) {
		this.nbIdciudad = nbIdciudad;
		this.tbAdmDepartamentos = tbAdmDepartamentos;
	}

	public TbAdmCiudades(int nbIdciudad,
			TbAdmDepartamentos tbAdmDepartamentos, String vrNombre,
			String vrModusuario, Date dtModfecha, Set tbAdmPersonas) {
		this.nbIdciudad = nbIdciudad;
		this.tbAdmDepartamentos = tbAdmDepartamentos;
		this.vrNombre = vrNombre;
		this.vrModusuario = vrModusuario;
		this.dtModfecha = dtModfecha;
		this.tbAdmPersonas = tbAdmPersonas;
	}

	public int getNbIdciudad() {
		return this.nbIdciudad;
	}

	public void setNbIdciudad(int nbIdciudad) {
		this.nbIdciudad = nbIdciudad;
	}

	public TbAdmDepartamentos getTbAdmDepartamentos() {
		return this.tbAdmDepartamentos;
	}

	public void setTbAdmDepartamentos(TbAdmDepartamentos tbAdmDepartamentos) {
		this.tbAdmDepartamentos = tbAdmDepartamentos;
	}

	public String getVrNombre() {
		return this.vrNombre;
	}

	public void setVrNombre(String vrNombre) {
		this.vrNombre = vrNombre;
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

	public Set getTbAdmPersonas() {
		return this.tbAdmPersonas;
	}

	public void setTbAdmPersonas(Set tbAdmPersonas) {
		this.tbAdmPersonas = tbAdmPersonas;
	}

}
