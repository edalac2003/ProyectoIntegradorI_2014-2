package com.udea.proint1.microcurriculo.dto;

import java.util.Date;

public class TbAdmAuditoria {

	private int nbIdauditoria;
	private TbAdmUsuarios tbAdmUsuarios;
	private TbAdmTablas tbAdmTablas;
	private int nbObservaciones;
	private Date dtFecha;

	public TbAdmAuditoria() {
	}

	public TbAdmAuditoria(int nbIdauditoria, TbAdmUsuarios tbAdmUsuarios,
			TbAdmTablas tbAdmTablas) {
		this.nbIdauditoria = nbIdauditoria;
		this.tbAdmUsuarios = tbAdmUsuarios;
		this.tbAdmTablas = tbAdmTablas;
	}

	public TbAdmAuditoria(int nbIdauditoria, TbAdmUsuarios tbAdmUsuarios,
			TbAdmTablas tbAdmTablas, int nbObservaciones, Date dtFecha) {
		this.nbIdauditoria = nbIdauditoria;
		this.tbAdmUsuarios = tbAdmUsuarios;
		this.tbAdmTablas = tbAdmTablas;
		this.nbObservaciones = nbObservaciones;
		this.dtFecha = dtFecha;
	}

	public int getNbIdauditoria() {
		return nbIdauditoria;
	}

	public void setNbIdauditoria(int nbIdauditoria) {
		this.nbIdauditoria = nbIdauditoria;
	}

	public TbAdmUsuarios getTbAdmUsuarios() {
		return tbAdmUsuarios;
	}

	public void setTbAdmUsuarios(TbAdmUsuarios tbAdmUsuarios) {
		this.tbAdmUsuarios = tbAdmUsuarios;
	}

	public TbAdmTablas getTbAdmTablas() {
		return tbAdmTablas;
	}

	public void setTbAdmTablas(TbAdmTablas tbAdmTablas) {
		this.tbAdmTablas = tbAdmTablas;
	}

	public int getNbObservaciones() {
		return nbObservaciones;
	}

	public void setNbObservaciones(int nbObservaciones) {
		this.nbObservaciones = nbObservaciones;
	}

	public Date getDtFecha() {
		return dtFecha;
	}

	public void setDtFecha(Date dtFecha) {
		this.dtFecha = dtFecha;
	}
	
}
