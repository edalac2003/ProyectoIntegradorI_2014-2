package com.udea.proint1.microcurriculo.dto;

// Generated 21/10/2014 12:17:56 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * TbMicObjetivosxmicro generated by hbm2java
 */
public class TbMicObjetivoxmicro implements java.io.Serializable {

	private int nbId;
	private TbMicObjetivo tbMicObjetivo;
	private TbMicMicrocurriculo tbMicMicrocurriculo;
	private String vrModusuario;
	private Date dtModfecha;

	public TbMicObjetivoxmicro() {
	}

	public TbMicObjetivoxmicro(int nbId, TbMicObjetivo tbMicObjetivo,
			TbMicMicrocurriculo tbMicMicrocurriculo) {
		this.nbId = nbId;
		this.tbMicObjetivo = tbMicObjetivo;
		this.tbMicMicrocurriculo = tbMicMicrocurriculo;
	}

	public TbMicObjetivoxmicro(int nbId, TbMicObjetivo tbMicObjetivo,
			TbMicMicrocurriculo tbMicMicrocurriculo, String vrModusuario,
			Date dtModfecha) {
		this.nbId = nbId;
		this.tbMicObjetivo = tbMicObjetivo;
		this.tbMicMicrocurriculo = tbMicMicrocurriculo;
		this.vrModusuario = vrModusuario;
		this.dtModfecha = dtModfecha;
	}

	public int getNbId() {
		return this.nbId;
	}

	public void setNbId(int nbId) {
		this.nbId = nbId;
	}

	public TbMicObjetivo getTbMicObjetivo() {
		return this.tbMicObjetivo;
	}

	public void setTbMicObjetivo(TbMicObjetivo tbMicObjetivo) {
		this.tbMicObjetivo = tbMicObjetivo;
	}

	public TbMicMicrocurriculo getTbMicMicrocurriculo() {
		return this.tbMicMicrocurriculo;
	}

	public void setTbMicMicrocurriculo(
			TbMicMicrocurriculo tbMicMicrocurriculo) {
		this.tbMicMicrocurriculo = tbMicMicrocurriculo;
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
