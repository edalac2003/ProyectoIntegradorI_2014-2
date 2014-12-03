package com.udea.proint1.microcurriculo.dto;

import java.util.Date;

public class TbMicObservaciones {

	private int nbIdobservacion;
	private String vrDescripcion;
	private String vrModusuario;
	private Date dtModfecha;

	public TbMicObservaciones() {
	}

	public TbMicObservaciones(int nbIdobservacion,String vrDescripcion, 
			Date dtModfecha,String vrModusuario) {
		this.nbIdobservacion = nbIdobservacion;
		this.vrDescripcion = vrDescripcion;
		this.vrModusuario = vrModusuario;
		this.dtModfecha = dtModfecha;
	}

	public int getNbIdobservacion() {
		return nbIdobservacion;
	}

	public void setNbIdobservacion(int nbIdobservacion) {
		this.nbIdobservacion = nbIdobservacion;
	}

	public String getVrDescripcion() {
		return vrDescripcion;
	}

	public void setVrDescripcion(String vrDescripcion) {
		this.vrDescripcion = vrDescripcion;
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
