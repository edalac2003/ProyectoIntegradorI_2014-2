package com.udea.proint1.microcurriculo.dto;

// Generated 21/10/2014 12:17:56 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * TbMicEvaluacionxmicro generated by hbm2java
 */
public class TbMicEvaluacionxmicro implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int nbId;
	private TbMicEvaluacion tbMicEvaluacion;
	private TbMicMicrocurriculo tbMicMicrocurriculo;
	private int nbPorcentaje;
	private Date dtFechaestimada;
	private String vrModusuario;
	private Date dtModfecha;

	public TbMicEvaluacionxmicro() {
	}

	public TbMicEvaluacionxmicro(int nbId, TbMicEvaluacion tbMicEvaluacion,
			TbMicMicrocurriculo tbMicMicrocurriculo,int nbPorcentaje,
			Date dtFechaestimada) {
		this.nbId = nbId;
		this.tbMicEvaluacion = tbMicEvaluacion;
		this.tbMicMicrocurriculo = tbMicMicrocurriculo;
		this.nbPorcentaje = nbPorcentaje;
		this.dtFechaestimada = dtFechaestimada;
	}

	public TbMicEvaluacionxmicro(int nbId, TbMicEvaluacion tbMicEvaluacion,
			TbMicMicrocurriculo tbMicMicrocurriculo, int nbPorcentaje,
			Date dtFechaestimada, String vrModusuario, Date dtModfecha) {
		super();
		this.nbId = nbId;
		this.tbMicEvaluacion = tbMicEvaluacion;
		this.tbMicMicrocurriculo = tbMicMicrocurriculo;
		this.nbPorcentaje = nbPorcentaje;
		this.dtFechaestimada = dtFechaestimada;
		this.vrModusuario = vrModusuario;
		this.dtModfecha = dtModfecha;
	}

	public int getNbId() {
		return this.nbId;
	}

	public void setNbId(int nbId) {
		this.nbId = nbId;
	}

	public TbMicEvaluacion getTbMicEvaluacion() {
		return this.tbMicEvaluacion;
	}

	public void setTbMicEvaluacion(TbMicEvaluacion tbMicEvaluacion) {
		this.tbMicEvaluacion = tbMicEvaluacion;
	}

	public TbMicMicrocurriculo getTbMicMicrocurriculo() {
		return this.tbMicMicrocurriculo;
	}

	public void setTbMicMicrocurriculo(
			TbMicMicrocurriculo tbMicMicrocurriculo) {
		this.tbMicMicrocurriculo = tbMicMicrocurriculo;
	}

	public int getNbPorcentaje() {
		return nbPorcentaje;
	}

	public void setNbPorcentaje(int nbPorcentaje) {
		this.nbPorcentaje = nbPorcentaje;
	}

	public Date getDtFechaestimada() {
		return dtFechaestimada;
	}

	public void setDtFechaestimada(Date dtFechaestimada) {
		this.dtFechaestimada = dtFechaestimada;
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

	public void setDtModfecha(Date dtModusuario) {
		this.dtModfecha = dtModusuario;
	}

}
