package com.udea.proint1.microcurriculo.dto;

import java.util.Date;

public class TbMicActividadesxmicro {

	private int nbIdactividad;
	private TbMicMicrocurriculos tbMicMicrocurriculos;
	private String vrModusuario;
	private String vrDescripcion;
	private Date dtModfecha;

	public TbMicActividadesxmicro() {
	}

	public TbMicActividadesxmicro(int nbIdactividad, TbMicMicrocurriculos tbMicMicrocurriculos) {
		this.nbIdactividad = nbIdactividad;
		this.tbMicMicrocurriculos = tbMicMicrocurriculos;
	}

	public TbMicActividadesxmicro(int nbIdactividad, TbMicMicrocurriculos tbMicMicrocurriculos,
			String vrDescripcion, String vrModusuario, Date dtModfecha) {
		this.nbIdactividad = nbIdactividad;
		this.tbMicMicrocurriculos = tbMicMicrocurriculos;
		this.vrModusuario = vrModusuario;
		this.dtModfecha = dtModfecha;
		this.vrDescripcion = vrDescripcion;
	}

	public int getNbIdactividad() {
		return nbIdactividad;
	}

	public void setNbIdactividad(int nbIdactividad) {
		this.nbIdactividad = nbIdactividad;
	}

	public TbMicMicrocurriculos getTbMicMicrocurriculos() {
		return tbMicMicrocurriculos;
	}

	public void setTbMicMicrocurriculos(TbMicMicrocurriculos tbMicMicrocurriculos) {
		this.tbMicMicrocurriculos = tbMicMicrocurriculos;
	}

	public String getVrModusuario() {
		return vrModusuario;
	}

	public void setVrModusuario(String vrModusuario) {
		this.vrModusuario = vrModusuario;
	}

	public String getVrDescripcion() {
		return vrDescripcion;
	}

	public void setVrDescripcion(String vrDescripcion) {
		this.vrDescripcion = vrDescripcion;
	}

	public Date getDtModfecha() {
		return dtModfecha;
	}

	public void setDtModfecha(Date dtModfecha) {
		this.dtModfecha = dtModfecha;
	}
	
}
