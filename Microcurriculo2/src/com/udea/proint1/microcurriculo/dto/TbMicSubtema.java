package com.udea.proint1.microcurriculo.dto;

// Generated 21/10/2014 12:17:56 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * TbMicSubtemas generated by hbm2java
 */
public class TbMicSubtema implements java.io.Serializable {

	private int nbIdsubtema;
	private String vrDescripcion;
	private String vrModusuario;
	private Date dtModfecha;

		
	public TbMicSubtema(int nbIdsubtema, String vrDescripcion) {
		super();
		this.nbIdsubtema = nbIdsubtema;
		this.vrDescripcion = vrDescripcion;
	}

	public TbMicSubtema(int nbIdsubtema, String vrDescripcion, String vrModusuario, Date dtModfecha) {
		this.nbIdsubtema = nbIdsubtema;
		this.vrDescripcion = vrDescripcion;
		this.vrModusuario = vrModusuario;
		this.dtModfecha = dtModfecha;
	}

	public int getNbIdsubtema() {
		return this.nbIdsubtema;
	}

	public void setNbIdsubtema(int nbIdsubtema) {
		this.nbIdsubtema = nbIdsubtema;
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

}