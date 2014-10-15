package com.udea.proint1.microcurriculo.dto;

import java.util.Date;

public class Usuarios {

	private int id;
	private String persona;
	private String login;
	private String password;
	private String modUsuario;
	private Date modFecha;
	private boolean estado;
	
	public Usuarios() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getModFecha() {
		return modFecha;
	}

	public void setModFecha(Date modFecha) {
		this.modFecha = modFecha;
	}

	public boolean isEstado() {
		return estado;
	}

	public String getPersona() {
		return persona;
	}

	public void setPersona(String persona) {
		this.persona = persona;
	}

	public String getModUsuario() {
		return modUsuario;
	}

	public void setModUsuario(String modUsuario) {
		this.modUsuario = modUsuario;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	

}
