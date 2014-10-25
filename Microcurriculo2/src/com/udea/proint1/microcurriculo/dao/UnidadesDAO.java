package com.udea.proint1.microcurriculo.dao;

import com.udea.proint1.microcurriculo.dto.TbMicUnidades;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public interface UnidadesDAO {
	
	public void guardarUnidad(TbMicUnidades unidad) throws ExcepcionesDAO;
	
	public TbMicUnidades obtenerUnidad(int idUnidad) throws ExcepcionesDAO;
	
	public void modificarUnidad(TbMicUnidades unidad) throws ExcepcionesDAO;

}
