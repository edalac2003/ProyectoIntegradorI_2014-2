package com.udea.proint1.microcurriculo.dto;

// Generated 21/10/2014 12:17:56 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * TbMicObjetivos generated by hbm2java
 */
public class TbMicObjetivo implements java.io.Serializable {

	private int nbIdobjetivo;
	private String vrDescripcion;
	private char blTipo;
	private String vrModusuario;
	private Date dtModfecha;
	private Set tbMicObjetivosxmicros = new HashSet(0);

	public TbMicObjetivo() {
	}
	
	public TbMicObjetivo(int nbIdobjetivo, String vrDescripcion, char blTipo, String vrModusuario, Date dtModfecha) {
		super();
		this.nbIdobjetivo = nbIdobjetivo;
		this.vrDescripcion = vrDescripcion;
		this.blTipo = blTipo;
		this.vrModusuario = vrModusuario;
		this.dtModfecha = dtModfecha;
	}

	public TbMicObjetivo(int nbIdobjetivo, String vrDescripcion, char blTipo,
			String vrModusuario, Date dtModfecha,
			Set tbMicObjetivosxmicros) {
		this.nbIdobjetivo = nbIdobjetivo;
		this.vrDescripcion = vrDescripcion;
		this.blTipo = blTipo;
		this.vrModusuario = vrModusuario;
		this.dtModfecha = dtModfecha;
		this.tbMicObjetivosxmicros = tbMicObjetivosxmicros;
	}

	public int getNbIdobjetivo() {
		return this.nbIdobjetivo;
	}

	public void setNbIdobjetivo(int nbIdobjetivo) {
		this.nbIdobjetivo = nbIdobjetivo;
	}

	public String getVrDescripcion() {
		return this.vrDescripcion;
	}

	public void setVrDescripcion(String vrDescripcion) {
		this.vrDescripcion = vrDescripcion;
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

	public Set getTbMicObjetivosxmicros() {
		return this.tbMicObjetivosxmicros;
	}

	public void setTbMicObjetivosxmicros(Set tbMicObjetivosxmicros) {
		this.tbMicObjetivosxmicros = tbMicObjetivosxmicros;
	}

	public char getBlTipo() {
		return blTipo;
	}

	public void setBlTipo(char blTipo) {
		this.blTipo = blTipo;
	}

}
