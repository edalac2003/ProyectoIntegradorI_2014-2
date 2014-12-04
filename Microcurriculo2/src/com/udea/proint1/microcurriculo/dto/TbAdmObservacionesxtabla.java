package com.udea.proint1.microcurriculo.dto;

public class TbAdmObservacionesxtabla {

	private String vrObservaciones;
	private int nbIdobservaciones;

	public TbAdmObservacionesxtabla() {
	}

	public TbAdmObservacionesxtabla(String vrObservaciones, int nbIdobservaciones) {
		this.vrObservaciones = vrObservaciones;
		this.nbIdobservaciones = nbIdobservaciones;
	}

	public String getVrObservaciones() {
		return vrObservaciones;
	}

	public void setVrObservaciones(String vrObservaciones) {
		this.vrObservaciones = vrObservaciones;
	}

	public int getNbIdobservaciones() {
		return nbIdobservaciones;
	}

	public void setNbIdobservaciones(int nbIdobservaciones) {
		this.nbIdobservaciones = nbIdobservaciones;
	}
	
}
