package com.udea.proint1.microcurriculo.dto;

import java.util.Date;

public class Bibliografia {

	private int idBibliografia;
	private String nombre;
	private String sitioWeb;
	private String ISBN;
	private boolean tipo;
	private String modUsuario;
	private Date modFecha;
	
	public Bibliografia() {
		// TODO Auto-generated constructor stub
	}

	public int getIdBibliografia() {
		return idBibliografia;
	}

	public void setIdBibliografia(int idBibliografia) {
		this.idBibliografia = idBibliografia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getSitioWeb() {
		return sitioWeb;
	}

	public void setSitioWeb(String sitioWeb) {
		this.sitioWeb = sitioWeb;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public boolean isTipo() {
		return tipo;
	}

	public void setTipo(boolean tipo) {
		this.tipo = tipo;
	}

	public Date getModFecha() {
		return modFecha;
	}

	public String getModUsuario() {
		return modUsuario;
	}

	public void setModUsuario(String modUsuario) {
		this.modUsuario = modUsuario;
	}

	public void setModFecha(Date modFecha) {
		this.modFecha = modFecha;
	}

	
}
