package com.udea.proint1.microcurriculo.dto;

// Generated 21/10/2014 12:17:56 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;

/**
 * TbAdmUsuarios generated by hbm2java
 */
public class TbAdmUsuario implements java.io.Serializable {

	private int nbId;
	private TbAdmPersona tbAdmPersona;
	private String vrLogin;
	private String vrPassword;
	private int blEstado;
	private String vrModusuario;
	private Date dtModfecha;

	public TbAdmUsuario() {
	}

	public TbAdmUsuario(int nbId, TbAdmPersona tbAdmPersona,
			String vrLogin) {
		this.nbId = nbId;
		this.tbAdmPersona = tbAdmPersona;
		this.vrLogin = vrLogin;
	}

	public TbAdmUsuario(int nbId, TbAdmPersona tbAdmPersona,
			String vrLogin, String vrPassword, int blEstado,
			String vrModusuario, Date dtModfecha) {
		this.nbId = nbId;
		this.tbAdmPersona = tbAdmPersona;
		this.vrLogin = vrLogin;
		this.vrPassword = vrPassword;
		this.blEstado = blEstado;
		this.vrModusuario = vrModusuario;
		this.dtModfecha = dtModfecha;
	}

	public int getNbId() {
		return this.nbId;
	}

	public void setNbId(int nbId) {
		this.nbId = nbId;
	}

	public TbAdmPersona getTbAdmPersona() {
		return this.tbAdmPersona;
	}

	public void setTbAdmPersona(TbAdmPersona tbAdmPersona) {
		this.tbAdmPersona = tbAdmPersona;
	}

	public String getVrLogin() {
		return this.vrLogin;
	}

	public void setVrLogin(String vrLogin) {
		this.vrLogin = vrLogin;
	}

	public String getVrPassword() {
		return this.vrPassword;
	}

	public void setVrPassword(String vrPassword) {
		this.vrPassword = vrPassword;
	}

	public int getBlEstado() {
		return this.blEstado;
	}

	public void setBlEstado(int blEstado) {
		this.blEstado = blEstado;
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

}
