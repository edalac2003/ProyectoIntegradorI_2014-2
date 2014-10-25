package com.udea.proint1.microcurriculo.dao;

import java.util.List;

import mapeos.Objetivos;

import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public interface ObjetivosDAO {
	
	public void guardarObjetivo(Objetivos objetivo) throws ExcepcionesDAO;
	
	public Objetivos obtenerObjetivo(int idObjetivo) throws ExcepcionesDAO;
	
	public List<Objetivos> listarObjetivosPorMicrocurriculo(String idMicrocurriculo) throws ExcepcionesDAO;
	
	public List<Objetivos> listarObjetivosPorTipo(String idMicrocurriculo, char tipo) throws ExcepcionesDAO;
	
	public void modificarObjetivo(Objetivos objetivo) throws ExcepcionesDAO;

}
