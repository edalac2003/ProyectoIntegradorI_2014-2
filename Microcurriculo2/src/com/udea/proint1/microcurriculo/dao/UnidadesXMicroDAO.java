package com.udea.proint1.microcurriculo.dao;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbMicUnidadesxmicro;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public interface UnidadesXMicroDAO {

	public void guardarUnidadXmicro(TbMicUnidadesxmicro unidadXmicro) throws ExcepcionesDAO;
	
	public void modificarUnidadXmicro(TbMicUnidadesxmicro unidadXmicro) throws ExcepcionesDAO;
	
	public TbMicUnidadesxmicro obtenerUnidadXmicro(String idMicrocurriculo, int idUnidad) throws ExcepcionesDAO;
	
	public List<TbMicUnidadesxmicro> listarUnidadesXmicro(String idMicrocurriculo) throws ExcepcionesDAO;
	
	public List<TbMicUnidadesxmicro> listarTodoUnidadesXmicro() throws ExcepcionesDAO;
	
	public int contarRegistros() throws ExcepcionesDAO;
	
}
