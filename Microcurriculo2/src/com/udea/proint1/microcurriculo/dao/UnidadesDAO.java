package com.udea.proint1.microcurriculo.dao;

import java.util.List;

import mapeos.Unidades;

import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public interface UnidadesDAO {
	
	public void guardarUnidad(Unidades unidad) throws ExcepcionesDAO;
	
	public Unidades obtenerUnidad(int idUnidad) throws ExcepcionesDAO;
	
	public void modificarUnidad(Unidades unidad) throws ExcepcionesDAO;

}
