package com.udea.proint1.microcurriculo.dto;

import java.util.Date;

public class TbMicObservacionesxmicro {

	private int nbId;
	private TbMicObservaciones tbMicObservaciones;
	private TbMicMicrocurriculos tbMicMicrocurriculos;
	private Date dtFechaobservacion;
	private String vrModusuario;
	private Date vrModfecha;

	public TbMicObservacionesxmicro() {
	}

	public TbMicObservacionesxmicro(int nbId, TbMicObservaciones tbMicObservaciones,
			TbMicMicrocurriculos tbMicMicrocurriculos) {
		this.nbId = nbId;
		this.tbMicObservaciones = tbMicObservaciones;
		this.tbMicMicrocurriculos = tbMicMicrocurriculos;
	}

	public TbMicObservacionesxmicro(int nbId, TbMicObservaciones tbMicObservaciones,
			TbMicMicrocurriculos tbMicMicrocurriculos, String vrModusuario, Date vrModfecha,
			Date dtFechaobservacion) {
		this.nbId = nbId;
		this.tbMicObservaciones = tbMicObservaciones;
		this.tbMicMicrocurriculos = tbMicMicrocurriculos;
		this.vrModusuario = vrModusuario;
		this.vrModfecha = vrModfecha;
		this.dtFechaobservacion = dtFechaobservacion;
	}

	public int getNbId() {
		return nbId;
	}

	public void setNbId(int nbId) {
		this.nbId = nbId;
	}

	public TbMicObservaciones getTbMicObservaciones() {
		return tbMicObservaciones;
	}

	public void setTbMicObservaciones(TbMicObservaciones tbMicObservaciones) {
		this.tbMicObservaciones = tbMicObservaciones;
	}

	public TbMicMicrocurriculos getTbMicMicrocurriculos() {
		return tbMicMicrocurriculos;
	}

	public void setTbMicMicrocurriculos(TbMicMicrocurriculos tbMicMicrocurriculos) {
		this.tbMicMicrocurriculos = tbMicMicrocurriculos;
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

	public Date getVrModfecha() {
		return vrModfecha;
	}

	public void setVrModfecha(Date vrModfecha) {
		this.vrModfecha = vrModfecha;
	}
	
}
