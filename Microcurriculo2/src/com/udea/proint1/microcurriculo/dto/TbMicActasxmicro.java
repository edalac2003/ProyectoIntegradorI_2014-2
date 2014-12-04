package com.udea.proint1.microcurriculo.dto;

import java.util.Date;

public class TbMicActasxmicro {

	private int nbIdactas;
	private TbMicMicrocurriculos tbMicMicrocurriculos;
	private TbAdmUsuarios tbAdmUsuarios;
	private Date dtFechaaprobacion;

	public TbMicActasxmicro() {
	}

	public TbMicActasxmicro(int nbIdactas, TbMicMicrocurriculos tbMicMicrocurriculos,
			TbAdmUsuarios tbAdmUsuarios) {
		this.nbIdactas = nbIdactas;
		this.tbMicMicrocurriculos = tbMicMicrocurriculos;
		this.tbAdmUsuarios = tbAdmUsuarios;
	}

	public TbMicActasxmicro(int nbIdactas, TbMicMicrocurriculos tbMicMicrocurriculos, 
			TbAdmUsuarios tbAdmUsuarios, Date dtFechaaprobacion) {
		this.nbIdactas = nbIdactas;
		this.tbMicMicrocurriculos = tbMicMicrocurriculos;
		this.tbAdmUsuarios = tbAdmUsuarios;
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

	public Date getDtFechaaprobacion() {
		return dtFechaaprobacion;
	}

	public void setDtFechaaprobacion(Date dtFechaaprobacion) {
		this.dtFechaaprobacion = dtFechaaprobacion;
	}

	public TbAdmUsuarios getTbAdmUsuarios() {
		return tbAdmUsuarios;
	}

	public void setTbAdmUsuarios(TbAdmUsuarios tbAdmUsuarios) {
		this.tbAdmUsuarios = tbAdmUsuarios;
	}
	
}
