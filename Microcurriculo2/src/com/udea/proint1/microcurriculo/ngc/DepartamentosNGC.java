package com.udea.proint1.microcurriculo.ngc;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbAdmDepartamentos;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface DepartamentosNGC {
	
	public List<TbAdmDepartamentos> listarDepartamentos() throws ExcepcionesLogica;
	
	public TbAdmDepartamentos obtenerDepartamentos(int id) throws ExcepcionesLogica;

	public void modificarDepartamentos(TbAdmDepartamentos departamento) throws ExcepcionesLogica;
}
