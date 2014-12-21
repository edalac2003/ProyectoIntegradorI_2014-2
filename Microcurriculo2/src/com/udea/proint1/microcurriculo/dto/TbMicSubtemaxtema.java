package com.udea.proint1.microcurriculo.dto;

import java.util.Date;

public class TbMicSubtemaxtema {

	private int nbid;
	private TbMicTema tema;
	private TbMicSubtema subtema;
	private String vrModUsuario;
	private Date dtModFecha;
	
	
	public TbMicSubtemaxtema(int nbid, TbMicTema tema, TbMicSubtema subtema,
			String vrModUsuario, Date dtModFecha) {
		super();
		this.nbid = nbid;
		this.tema = tema;
		this.subtema = subtema;
		this.vrModUsuario = vrModUsuario;
		this.dtModFecha = dtModFecha;
	}
	
	
	public TbMicSubtemaxtema(int nbid, TbMicTema tema, TbMicSubtema subtema) {
		super();
		this.nbid = nbid;
		this.tema = tema;
		this.subtema = subtema;
	}


	public int getNbid() {
		return nbid;
	}


	public void setNbid(int nbid) {
		this.nbid = nbid;
	}


	public TbMicTema getTema() {
		return tema;
	}


	public void setTema(TbMicTema tema) {
		this.tema = tema;
	}


	public TbMicSubtema getSubtema() {
		return subtema;
	}


	public void setSubtema(TbMicSubtema subtema) {
		this.subtema = subtema;
	}


	public String getVrModUsuario() {
		return vrModUsuario;
	}


	public void setVrModUsuario(String vrModUsuario) {
		this.vrModUsuario = vrModUsuario;
	}


	public Date getDtModFecha() {
		return dtModFecha;
	}


	public void setDtModFecha(Date dtModFecha) {
		this.dtModFecha = dtModFecha;
	}
	
	
	
	
}
