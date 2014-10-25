package com.udea.proint1.microcurriculo.ngc;

import java.util.Date;
import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbAdmUnidadAcademica;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface UnidadAcademicaNGC {

	public void guardarUnidadAcademica(String id, String nombre, String usuario, Date modFecha) throws ExcepcionesLogica;
	
	public void actualizarUnidadAcademica(String nombre, String usuario, Date modFecha) throws ExcepcionesLogica;

	public TbAdmUnidadAcademica obtenerUnidadAcademica(String id) throws ExcepcionesLogica;
	
	public List<TbAdmUnidadAcademica> listarUnidadAcademicas() throws ExcepcionesLogica;
	
}
