package com.udea.proint1.microcurriculo.dto;

import java.util.Date;

public class Persona {

	private String idPersona;
	private String nombres;
	private String apellidos;
	private String email;
	private String telefono;
	private Ciudades ciudad;
	private char estado;
	private TipoIdentificacion idIdentificacion;
	private TipoPersona tipoPersona;
	private Usuarios modUsuario;
	private Date modFecha;
	
	public Persona() {
		// TODO Auto-generated constructor stub
	}

	public String getIdPersona() {
		return idPersona;
	}

	public void setIdPersona(String idPersona) {
		this.idPersona = idPersona;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Ciudades getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudades ciudad) {
		this.ciudad = ciudad;
	}

	public char getEstado() {
		return estado;
	}

	public void setEstado(char estado) {
		this.estado = estado;
	}

	public TipoIdentificacion getIdIdentificacion() {
		return idIdentificacion;
	}

	public void setIdIdentificacion(TipoIdentificacion idIdentificacion) {
		this.idIdentificacion = idIdentificacion;
	}

	public TipoPersona getTipoPersona() {
		return tipoPersona;
	}

	public void setTipoPersona(TipoPersona tipoPersona) {
		this.tipoPersona = tipoPersona;
	}

	public Date getModFecha() {
		return modFecha;
	}

	public Usuarios getModUsuario() {
		return modUsuario;
	}

	public void setModUsuario(Usuarios modUsuario) {
		this.modUsuario = modUsuario;
	}

	public void setModFecha(Date modFecha) {
		this.modFecha = modFecha;
	}
	
	

}
