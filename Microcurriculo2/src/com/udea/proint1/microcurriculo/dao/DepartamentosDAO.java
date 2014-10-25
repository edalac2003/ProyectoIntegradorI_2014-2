package com.udea.proint1.microcurriculo.dao;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbAdmDepartamentos;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public interface DepartamentosDAO {
	
	public TbAdmDepartamentos obtenerDepartamento(int id) throws ExcepcionesDAO;
	
	public List<TbAdmDepartamentos> listarDepartamentos() throws ExcepcionesDAO;
	
	public void modificarDepartamentos(TbAdmDepartamentos departamento) throws ExcepcionesDAO;
}
