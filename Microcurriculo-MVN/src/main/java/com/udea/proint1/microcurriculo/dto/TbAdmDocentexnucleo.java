package com.udea.proint1.microcurriculo.dto;

// Generated 21/10/2014 12:17:56 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * TbAdmDocentesxnucleo generated by hbm2java
 */
public class TbAdmDocentexnucleo implements java.io.Serializable {

	private int nbId;
	private TbAdmNucleo tbAdmNucleo;
	private TbAdmPersona tbAdmPersona;
	private String vrModusuario;
	private String vrOficina;
	private String vrHorarioatencion;
	private String vrHorarioclases;
	private Date dtModfecha;

	public TbAdmDocentexnucleo() {
	}

	public TbAdmDocentexnucleo(int nbId, TbAdmNucleo tbAdmNucleo,
			TbAdmPersona tbAdmPersona) {
		this.nbId = nbId;
		this.tbAdmNucleo = tbAdmNucleo;
		this.tbAdmPersona = tbAdmPersona;
	}

	public TbAdmDocentexnucleo(int nbId, TbAdmNucleo tbAdmNucleo,
			TbAdmPersona tbAdmPersona, String vrModusuario, Date dtModfecha,
			String vrOficina, String vrHorarioatencion, String vrHorarioclases) {
		this.nbId = nbId;
		this.tbAdmNucleo = tbAdmNucleo;
		this.tbAdmPersona = tbAdmPersona;
		this.vrModusuario = vrModusuario;
		this.dtModfecha = dtModfecha;
		this.vrOficina = vrOficina;
		this.vrHorarioatencion = vrHorarioatencion;
		this.vrHorarioclases = vrHorarioclases;
	}

	public int getNbId() {
		return this.nbId;
	}

	public void setNbId(int nbId) {
		this.nbId = nbId;
	}

	public TbAdmNucleo getTbAdmNucleo() {
		return this.tbAdmNucleo;
	}

	public void setTbAdmNucleo(TbAdmNucleo tbAdmNucleo) {
		this.tbAdmNucleo = tbAdmNucleo;
	}

	public TbAdmPersona getTbAdmPersona() {
		return this.tbAdmPersona;
	}

	public void setTbAdmPersona(TbAdmPersona tbAdmPersona) {
		this.tbAdmPersona = tbAdmPersona;
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

	public void setDtModfecha(Date dtModfecha) {
		this.dtModfecha = dtModfecha;
	}

	public String getVrOficina() {
		return vrOficina;
	}

	public void setVrOficina(String vrOficina) {
		this.vrOficina = vrOficina;
	}

	public String getVrHorarioatencion() {
		return vrHorarioatencion;
	}

	public void setVrHorarioatencion(String vrHorarioatencion) {
		this.vrHorarioatencion = vrHorarioatencion;
	}

	public String getVrHorarioclases() {
		return vrHorarioclases;
	}

	public void setVrHorarioclases(String vrHorarioclases) {
		this.vrHorarioclases = vrHorarioclases;
	}

}
