package com.udea.proint1.microcurriculo.dao;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbMicMicrocurriculos;
import com.udea.proint1.microcurriculo.dto.TbMicObjetivos;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface ObjetivosDAO {
	
	public void guardarObjetivo(TbMicObjetivos objetivo) throws ExcepcionesDAO;
	
	public TbMicObjetivos obtenerObjetivo(int idObjetivo) throws ExcepcionesDAO;
	
	public List<TbMicObjetivos> listarObjetivosPorMicrocurriculo(TbMicMicrocurriculos microcurriculo) throws ExcepcionesDAO;
	
	public List<TbMicObjetivos> listarObjetivosPorTipo(char tipo) throws ExcepcionesDAO;
	
	public void modificarObjetivo(TbMicObjetivos objetivo) throws ExcepcionesDAO;
	
	public List<TbMicObjetivos> listarObjetivos () throws ExcepcionesDAO;
	
	public int numeroRegistros() throws ExcepcionesDAO;

}
