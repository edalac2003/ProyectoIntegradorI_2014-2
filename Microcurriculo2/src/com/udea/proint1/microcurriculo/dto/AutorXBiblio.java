package com.udea.proint1.microcurriculo.dto;

import java.util.Date;

public class AutorXBiblio {

	private int id;
	private int bibliografia;
	private int autor;
	private String modUsuario;
	private Date modFecha;
	
	public AutorXBiblio() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getModFecha() {
		return modFecha;
	}

	public int getBibliografia() {
		return bibliografia;
	}

	public void setBibliografia(int bibliografia) {
		this.bibliografia = bibliografia;
	}

	public int getAutor() {
		return autor;
	}

	public void setAutor(int autor) {
		this.autor = autor;
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
