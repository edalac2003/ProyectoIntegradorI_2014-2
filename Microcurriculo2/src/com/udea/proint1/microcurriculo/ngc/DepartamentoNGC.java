package com.udea.proint1.microcurriculo.ngc;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbAdmDepartamento;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface DepartamentoNGC {
	
	public List<TbAdmDepartamento> listarDepartamentos() throws ExcepcionesLogica;
	
	public TbAdmDepartamento obtenerDepartamentos(int id) throws ExcepcionesLogica;

	public void modificarDepartamentos(TbAdmDepartamento departamento) throws ExcepcionesLogica;
}
