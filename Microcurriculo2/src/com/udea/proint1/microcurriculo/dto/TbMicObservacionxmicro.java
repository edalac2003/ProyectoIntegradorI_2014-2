package com.udea.proint1.microcurriculo.dto;

import java.util.Date;

public class TbMicObservacionxmicro {

	private int nbId;
	private TbMicObservacion tbMicObservacion;
	private TbMicMicrocurriculo tbMicMicrocurriculo;
	private Date dtFechaobservacion;
	private String vrModusuario;
	private Date dtModfecha;

	public TbMicObservacionxmicro() {
	}

	public TbMicObservacionxmicro(int nbId, TbMicObservacion tbMicObservacion,
			TbMicMicrocurriculo tbMicMicrocurriculo) {
		this.nbId = nbId;
		this.tbMicObservacion = tbMicObservacion;
		this.tbMicMicrocurriculo = tbMicMicrocurriculo;
	}

	public TbMicObservacionxmicro(int nbId, TbMicObservacion tbMicObservacion,
			TbMicMicrocurriculo tbMicMicrocurriculo, String vrModusuario, Date dtModfecha,
			Date dtFechaobservacion) {
		this.nbId = nbId;
		this.tbMicObservacion = tbMicObservacion;
		this.tbMicMicrocurriculo = tbMicMicrocurriculo;
		this.vrModusuario = vrModusuario;
		this.dtModfecha = dtModfecha;
		this.dtFechaobservacion = dtFechaobservacion;
	}

	public int getNbId() {
		return nbId;
	}

	public void setNbId(int nbId) {
		this.nbId = nbId;
	}

	public TbMicObservacion getTbMicObservacion() {
		return tbMicObservacion;
	}

	public void setTbMicObservacion(TbMicObservacion tbMicObservacion) {
		this.tbMicObservacion = tbMicObservacion;
	}

	public TbMicMicrocurriculo getTbMicMicrocurriculo() {
		return tbMicMicrocurriculo;
	}

	public void setTbMicMicrocurriculo(TbMicMicrocurriculo tbMicMicrocurriculo) {
		this.tbMicMicrocurriculo = tbMicMicrocurriculo;
	}

	public Date getDtFechaobservacion() {
		return dtFechaobservacion;
	}

	public void setDtFechaobservacion(Date dtFechaobservacion) {
		this.dtFechaobservacion = dtFechaobservacion;
	}

	public String getVrModusuario() {
		return vrModusuario;
	}

	public void setVrModusuario(String vrModusuario) {
		this.vrModusuario = vrModusuario;
	}

	public Date getDtModfecha() {
		return dtModfecha;
	}

	public void setDtModfecha(Date dtModfecha) {
		this.dtModfecha = dtModfecha;
	}
	
}
