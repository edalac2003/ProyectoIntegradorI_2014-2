package com.udea.proint1.microcurriculo.dao;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.UnidadesXMicro;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public interface UnidadesXMicroDAO {

	public void guardarUnidadXmicro(UnidadesXMicro unidadXmicro) throws ExcepcionesDAO;
	
	public void modificarUnidadXmicro(UnidadesXMicro unidadXmicro) throws ExcepcionesDAO;
	
	public UnidadesXMicro obtenerUnidadXmicro(String idMicrocurriculo, int idUnidad) throws ExcepcionesDAO;
	
	public List<UnidadesXMicro> listarUnidadesXmicro(String idMicrocurriculo) throws ExcepcionesDAO;
	
	public List<UnidadesXMicro> listarTodoUnidadesXmicro() throws ExcepcionesDAO;
	
}
