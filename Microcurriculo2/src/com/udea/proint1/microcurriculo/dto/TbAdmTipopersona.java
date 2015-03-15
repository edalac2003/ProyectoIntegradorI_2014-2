package com.udea.proint1.microcurriculo.dto;

// Generated 21/10/2014 12:17:56 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * TbAdmTipopersona generated by hbm2java
 */
public class TbAdmTipopersona implements java.io.Serializable {

	private int nbIdpersona;
	private String vrDescripcion;
	private String vrModusuario;
	private Date dtModfecha;
	private Set tbAdmPersonas = new HashSet(0);

	public TbAdmTipopersona(int nbIdpersona) {
		this.nbIdpersona = nbIdpersona;
	}

	public TbAdmTipopersona(int nbIdpersona, String vrDescripcion,
			String vrModusuario, Date dtModfecha, Set tbAdmPersonas) {
		this.nbIdpersona = nbIdpersona;
		this.vrDescripcion = vrDescripcion;
		this.vrModusuario = vrModusuario;
		this.dtModfecha = dtModfecha;
		this.tbAdmPersonas = tbAdmPersonas;
	}

	public int getNbIdpersona() {
		return this.nbIdpersona;
	}

	public void setNbIdpersona(int nbIdpersona) {
		this.nbIdpersona = nbIdpersona;
	}

	public String getVrDescripcion() {
		return this.vrDescripcion;
	}

	public void setVrDescripcion(String vrDescripcion) {
		this.vrDescripcion = vrDescripcion;
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
