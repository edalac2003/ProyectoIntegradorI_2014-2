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
	private TbMicEvaluaciones tbMicEvaluaciones;
	private TbMicMicrocurriculos tbMicMicrocurriculos;
	private int nbPorcentaje;
	private Date dtFechaestimada;
	private String vrModusuario;
	private Date dtModfecha;

	public TbMicEvaluacionxmicro() {
	}

	public TbMicEvaluacionxmicro(int nbId, TbMicEvaluaciones tbMicEvaluaciones,
			TbMicMicrocurriculos tbMicMicrocurriculos,int nbPorcentaje,
			Date dtFechaestimada) {
		this.nbId = nbId;
		this.tbMicEvaluaciones = tbMicEvaluaciones;
		this.tbMicMicrocurriculos = tbMicMicrocurriculos;
		this.nbPorcentaje = nbPorcentaje;
		this.dtFechaestimada = dtFechaestimada;
	}

	public TbMicEvaluacionxmicro(int nbId, TbMicEvaluaciones tbMicEvaluaciones,
			TbMicMicrocurriculos tbMicMicrocurriculos, int nbPorcentaje,
			Date dtFechaestimada, String vrModusuario, Date dtModfecha) {
		super();
		this.nbId = nbId;
		this.tbMicEvaluaciones = tbMicEvaluaciones;
		this.tbMicMicrocurriculos = tbMicMicrocurriculos;
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

	public TbMicEvaluaciones getTbMicEvaluaciones() {
		return this.tbMicEvaluaciones;
	}

	public void setTbMicEvaluaciones(TbMicEvaluaciones tbMicEvaluaciones) {
		this.tbMicEvaluaciones = tbMicEvaluaciones;
	}

	public TbMicMicrocurriculos getTbMicMicrocurriculos() {
		return this.tbMicMicrocurriculos;
	}

	public void setTbMicMicrocurriculos(
			TbMicMicrocurriculos tbMicMicrocurriculos) {
		this.tbMicMicrocurriculos = tbMicMicrocurriculos;
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
