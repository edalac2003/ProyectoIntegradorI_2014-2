package com.udea.proint1.microcurriculo.dao;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbMicTemasxunidad;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public interface TemasXUnidadDAO {

	public void guardarTemasXUnidad(TbMicTemasxunidad temaXunidad) throws ExcepcionesDAO;
	
	public void modificarTemasXUnidad(TbMicTemasxunidad temaXunidad) throws ExcepcionesDAO;
	
	public TbMicTemasxunidad obtenerTemaXunidad(int idTema, int idUnidad) throws ExcepcionesDAO;
	
	public List<TbMicTemasxunidad> ListarTemasXunidad(int idUnidad) throws ExcepcionesDAO;
	
	public List<TbMicTemasxunidad> ListarTodoTemaXunidad() throws ExcepcionesDAO;
	
}