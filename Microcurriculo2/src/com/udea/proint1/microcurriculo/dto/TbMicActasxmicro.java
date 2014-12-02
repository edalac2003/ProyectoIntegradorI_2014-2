package com.udea.proint1.microcurriculo.dto;

import java.util.Date;

public class TbMicActasxmicro {

	private int nbIdactas;
	private TbMicMicrocurriculos tbMicMicrocurriculos;
	private String vrModusuario;
	private Date dtModfecha;
	private String vrAprobador;
	private Date dtFechaaprobacion;

	public TbMicActasxmicro() {
	}

	public TbMicActasxmicro(int nbIdactas, TbMicMicrocurriculos tbMicMicrocurriculos) {
		this.nbIdactas = nbIdactas;
		this.tbMicMicrocurriculos = tbMicMicrocurriculos;
	}

	public TbMicActasxmicro(int nbIdactas, TbMicMicrocurriculos tbMicMicrocurriculos, 
			String vrModusuario, Date dtModfecha,
			String vrAprobador, Date dtFechaaprobacion) {
		this.nbIdactas = nbIdactas;
		this.tbMicMicrocurriculos = tbMicMicrocurriculos;
		this.vrModusuario = vrModusuario;
		this.dtModfecha = dtModfecha;
		this.vrAprobador = vrAprobador;
		this.dtFechaaprobacion = dtFechaaprobacion;
	}

	public int getNbIdactas() {
		return nbIdactas;
	}

	public void setNbIdactas(int nbIdactas) {
		this.nbIdactas = nbIdactas;
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

	public Date getDtModfecha() {
		return dtModfecha;
	}

	public void setDtModfecha(Date dtModfecha) {
		this.dtModfecha = dtModfecha;
	}

	public String getVrAprobador() {
		return vrAprobador;
	}

	public void setVrAprobador(String vrAprobador) {
		this.vrAprobador = vrAprobador;
	}

	public Date getDtFechaaprobacion() {
		return dtFechaaprobacion;
	}

	public void setDtFechaaprobacion(Date dtFechaaprobacion) {
		this.dtFechaaprobacion = dtFechaaprobacion;
	}
	
}
