package com.udea.proint1.microcurriculo.dao;

import com.udea.proint1.microcurriculo.dto.TbAdmUnidadAcademica;
import com.udea.proint1.microcurriculo.dto.TbMicUnidades;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public interface UnidadesAcademicasDAO {
	
	public void guardarUnidad(TbAdmUnidadAcademica unidadAcademica) throws ExcepcionesDAO;
	
	public TbAdmUnidadAcademica obtenerUnidad(String idUnidadAcademica) throws ExcepcionesDAO;
	
	public void modificarUnidad(TbAdmUnidadAcademica unidadAcademica) throws ExcepcionesDAO;
}
