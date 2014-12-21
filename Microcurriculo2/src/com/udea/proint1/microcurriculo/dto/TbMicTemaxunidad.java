package com.udea.proint1.microcurriculo.dto;

// Generated 21/10/2014 12:17:56 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * TbMicTemasxunidad generated by hbm2java
 */
public class TbMicTemaxunidad implements java.io.Serializable {

	private int nbId;
	private TbMicUnidad tbMicUnidad;
	private TbMicTema tbMicTema;
	private int nbSemanasRequeridas;
	private String vrModusuario;
	private Date dtModfecha;


	public TbMicTemaxunidad(int nbId, TbMicUnidad tbMicUnidad,
			TbMicTema tbMicTema) {
		this.nbId = nbId;
		this.tbMicUnidad = tbMicUnidad;
		this.tbMicTema = tbMicTema;
	}

	public TbMicTemaxunidad(int nbId, TbMicUnidad tbMicUnidad,
			TbMicTema tbMicTema, int nbSemanasRequeridas,
			String vrModusuario, Date dtModfecha) {
		this.nbId = nbId;
		this.tbMicUnidad = tbMicUnidad;
		this.tbMicTema = tbMicTema;
		this.nbSemanasRequeridas = nbSemanasRequeridas;
		this.vrModusuario = vrModusuario;
		this.dtModfecha = dtModfecha;
	}

	public int getNbId() {
		return this.nbId;
	}

	public void setNbId(int nbId) {
		this.nbId = nbId;
	}

	public TbMicUnidad getTbMicUnidad() {
		return this.tbMicUnidad;
	}

	public void setTbMicUnidad(TbMicUnidad tbMicUnidad) {
		this.tbMicUnidad = tbMicUnidad;
	}

	public TbMicTema getTbMicTema() {
		return this.tbMicTema;
	}

	public void setTbMicTema(TbMicTema tbMicTema) {
		this.tbMicTema = tbMicTema;
	}

	public int getNbSemanasRequeridas() {
		return this.nbSemanasRequeridas;
	}

	public void setNbSemanasRequeridas(int nbSemanasRequeridas) {
		this.nbSemanasRequeridas = nbSemanasRequeridas;
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
