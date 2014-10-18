package com.udea.proint1.microcurriculo.dao;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TemasXUnidad;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public interface TemasXUnidadDAO {

	public void guardarTemasXUnidad(TemasXUnidad temaXunidad) throws ExcepcionesDAO;
	
	public void modificarTemasXUnidad(TemasXUnidad temaXunidad) throws ExcepcionesDAO;
	
	public TemasXUnidad obtenerTemaXunidad(int idTema, int idUnidad) throws ExcepcionesDAO;
	
	public List<TemasXUnidad> ListarTemasXunidad(int idUnidad) throws ExcepcionesDAO;
	
	public List<TemasXUnidad> ListarTodoTemaXunidad() throws ExcepcionesDAO;
	
}