package com.udea.proint1.microcurriculo.dto;

// Generated 21/10/2014 12:17:56 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * TbAdmTipoidentificacion generated by hbm2java
 */
public class TbAdmTipoidentificacion implements java.io.Serializable {

	private int nbIdidentificacion;
	private String vrDescripcion;
	private String vrModusuario;
	private Date dtModfecha;
	private Set tbAdmPersonas = new HashSet(0);

	public TbAdmTipoidentificacion() {
	}

	public TbAdmTipoidentificacion(int nbIdidentificacion) {
		this.nbIdidentificacion = nbIdidentificacion;
	}

	public TbAdmTipoidentificacion(int nbIdidentificacion,
			String vrDescripcion, String vrModusuario, Date dtModfecha,
			Set tbAdmPersonas) {
		this.nbIdidentificacion = nbIdidentificacion;
		this.vrDescripcion = vrDescripcion;
		this.vrModusuario = vrModusuario;
		this.dtModfecha = dtModfecha;
		this.tbAdmPersonas = tbAdmPersonas;
	}

	public int getNbIdidentificacion() {
		return this.nbIdidentificacion;
	}

	public void setNbIdidentificacion(int nbIdidentificacion) {
		this.nbIdidentificacion = nbIdidentificacion;
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
