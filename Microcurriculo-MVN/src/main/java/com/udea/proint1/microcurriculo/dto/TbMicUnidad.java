package com.udea.proint1.microcurriculo.dto;

// Generated 21/10/2014 12:17:56 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * TbMicUnidades generated by hbm2java
 */
public class TbMicUnidad implements java.io.Serializable {

	private int nbIdunidad;
	private String vrNombre;
	private String vrModusuario;
	private Date dtModfecha;
	private Set tbMicTemasxunidads = new HashSet(0);
	private Set tbMicUnidadesxmicros = new HashSet(0);
	private Set tbMicBiblioxunidads = new HashSet(0);

	public TbMicUnidad() {
		
	}
	
	

	public TbMicUnidad(int nbIdunidad, String vrNombre, String vrModusuario,
			Date dtModfecha) {
		super();
		this.nbIdunidad = nbIdunidad;
		this.vrNombre = vrNombre;
		this.vrModusuario = vrModusuario;
		this.dtModfecha = dtModfecha;
	}



	public TbMicUnidad(int nbIdunidad) {
		this.nbIdunidad = nbIdunidad;
	}

	public TbMicUnidad(int nbIdunidad, String vrNombre,
			String vrModusuario, Date dtModfecha, Set tbMicTemasxunidads,
			Set tbMicUnidadesxmicros, Set tbMicBiblioxunidads) {
		this.nbIdunidad = nbIdunidad;
		this.vrNombre = vrNombre;
		this.vrModusuario = vrModusuario;
		this.dtModfecha = dtModfecha;
		this.tbMicTemasxunidads = tbMicTemasxunidads;
		this.tbMicUnidadesxmicros = tbMicUnidadesxmicros;
		this.tbMicBiblioxunidads = tbMicBiblioxunidads;
	}

	public int getNbIdunidad() {
		return this.nbIdunidad;
	}

	public void setNbIdunidad(int nbIdunidad) {
		this.nbIdunidad = nbIdunidad;
	}

	public String getVrNombre() {
		return this.vrNombre;
	}

	public void setVrNombre(String vrNombre) {
		this.vrNombre = vrNombre;
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

	public Set getTbMicTemasxunidads() {
		return this.tbMicTemasxunidads;
	}

	public void setTbMicTemasxunidads(Set tbMicTemasxunidads) {
		this.tbMicTemasxunidads = tbMicTemasxunidads;
	}

	public Set getTbMicUnidadesxmicros() {
		return this.tbMicUnidadesxmicros;
	}

	public void setTbMicUnidadesxmicros(Set tbMicUnidadesxmicros) {
		this.tbMicUnidadesxmicros = tbMicUnidadesxmicros;
	}

	public Set getTbMicBiblioxunidads() {
		return this.tbMicBiblioxunidads;
	}

	public void setTbMicBiblioxunidads(Set tbMicBiblioxunidads) {
		this.tbMicBiblioxunidads = tbMicBiblioxunidads;
	}

}
