package com.udea.proint1.microcurriculo.ngc;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbMicUnidadesxmicro;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface UnidadesxMicroNGC {

	public void guardarUnidadXmicro(TbMicUnidadesxmicro unidadXmicro) throws ExcepcionesLogica;
	
	public void guardarUnidadXmicro(List<TbMicUnidadesxmicro> listaUnidadxMicro) throws ExcepcionesLogica;
		
	public void modificarUnidadXmicro(TbMicUnidadesxmicro unidadXmicro) throws ExcepcionesLogica;
	
	public TbMicUnidadesxmicro obtenerUnidadXmicro(String idMicrocurriculo, int idUnidad) throws ExcepcionesLogica;
	
	public List<TbMicUnidadesxmicro> listarUnidadesXmicro(String idMicrocurriculo) throws ExcepcionesLogica;
	
	public List<TbMicUnidadesxmicro> listarTodoUnidadesXmicro() throws ExcepcionesLogica;
	
	public int contarRegistros() throws ExcepcionesLogica;
}
