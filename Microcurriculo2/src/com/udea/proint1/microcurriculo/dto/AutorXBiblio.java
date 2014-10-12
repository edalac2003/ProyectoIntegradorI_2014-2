package com.udea.proint1.microcurriculo.dto;

import java.util.Date;

public class AutorXBiblio {

	private int id;
	private Bibliografia bibliografia;
	private Autores autor;
	private Usuarios modUsuario;
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

	public Bibliografia getBibliografia() {
		return bibliografia;
	}

	public void setBibliografia(Bibliografia bibliografia) {
		this.bibliografia = bibliografia;
	}

	public Autores getAutor() {
		return autor;
	}

	public void setAutor(Autores autor) {
		this.autor = autor;
	}

	public Usuarios getModUsuario() {
		return modUsuario;
	}

	public void setModUsuario(Usuarios modUsuario) {
		this.modUsuario = modUsuario;
	}

	public Date getModFecha() {
		return modFecha;
	}

	public void setModFecha(Date modFecha) {
		this.modFecha = modFecha;
	}

	
}
