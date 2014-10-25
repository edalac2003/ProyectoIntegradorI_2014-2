package com.udea.proint1.microcurriculo.dao;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbMicObjetivos;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public interface ObjetivosDAO {
	
	public void guardarObjetivo(TbMicObjetivos objetivo) throws ExcepcionesDAO;
	
	public TbMicObjetivos obtenerObjetivo(int idObjetivo) throws ExcepcionesDAO;
	
	public List<TbMicObjetivos> listarObjetivosPorMicrocurriculo(String idMicrocurriculo) throws ExcepcionesDAO;
	
	public List<TbMicObjetivos> listarObjetivosPorTipo(String idMicrocurriculo, char tipo) throws ExcepcionesDAO;
	
	public void modificarObjetivo(TbMicObjetivos objetivo) throws ExcepcionesDAO;

}
