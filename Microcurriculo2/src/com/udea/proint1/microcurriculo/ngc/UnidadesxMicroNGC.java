package com.udea.proint1.microcurriculo.ngc;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbMicUnidadesxmicro;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface UnidadesxMicroNGC {

	public void guardarUnidadXmicro(TbMicUnidadesxmicro unidadXmicro) throws ExcepcionesLogica;
		
	public void modificarUnidadXmicro(TbMicUnidadesxmicro unidadXmicro) throws ExcepcionesLogica;
	
	public TbMicUnidadesxmicro obtenerUnidadXmicro(int id) throws ExcepcionesLogica;

	public List<TbMicUnidadesxmicro> listarUnidadesXMicroxMicro(String idMicrocurriculo) throws ExcepcionesLogica;
	
	public List<TbMicUnidadesxmicro> listarUnidadesXmicro() throws ExcepcionesLogica;
	
	public int contarRegistros() throws ExcepcionesLogica;
}
