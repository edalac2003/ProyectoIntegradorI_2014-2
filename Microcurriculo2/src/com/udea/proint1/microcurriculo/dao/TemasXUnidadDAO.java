package com.udea.proint1.microcurriculo.dao;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbMicTemasxunidad;
import com.udea.proint1.microcurriculo.dto.TbMicUnidades;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public interface TemasXUnidadDAO {

	public void guardarTemasXUnidad(TbMicTemasxunidad temaXunidad) throws ExcepcionesDAO;
	
	public void modificarTemasXUnidad(TbMicTemasxunidad temaXunidad) throws ExcepcionesDAO;
	
	public TbMicTemasxunidad obtenerTemaXunidad(int idTemaxUnidad) throws ExcepcionesDAO;
	
	public List<TbMicTemasxunidad> ListarTemasxUnidadxUnidad(TbMicUnidades unidad) throws ExcepcionesDAO;
	
	public List<TbMicTemasxunidad> ListarTemasXunidad() throws ExcepcionesDAO;
	
	public int contarRegistros() throws ExcepcionesDAO;
	
}