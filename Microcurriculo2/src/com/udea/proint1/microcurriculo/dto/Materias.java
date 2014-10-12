package com.udea.proint1.microcurriculo.dto;

import java.util.Date;

public class Materias {

	private int idMateria;
	private String nombre;
	private int semestre;
	private int creditos;
	private char habilitable;
	private char validable;
	private char clasificable;
	private int ht;
	private int hp;
	private int htp;
	private Nucleo nucleo;
	private Usuarios modUsuario;
	private Date modFecha;
	
	public Materias() {
		
	}

	public int getIdMateria() {
		return idMateria;
	}

	public void setIdMateria(int idMateria) {
		this.idMateria = idMateria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getSemestre() {
		return semestre;
	}

	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}

	public int getCreditos() {
		return creditos;
	}

	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}

	
	public char getHabilitable() {
		return habilitable;
	}

	public void setHabilitable(char habilitable) {
		this.habilitable = habilitable;
	}

	public char getValidable() {
		return validable;
	}

	public void setValidable(char validable) {
		this.validable = validable;
	}

	public char getClasificable() {
		return clasificable;
	}

	public void setClasificable(char clasificable) {
		this.clasificable = clasificable;
	}

	public int getHt() {
		return ht;
	}

	public void setHt(int ht) {
		this.ht = ht;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getHtp() {
		return htp;
	}

	public void setHtp(int htp) {
		this.htp = htp;
	}

	public Nucleo getNucleo() {
		return nucleo;
	}

	public void setNucleo(Nucleo nucleo) {
		this.nucleo = nucleo;
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
