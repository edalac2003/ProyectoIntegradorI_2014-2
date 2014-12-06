package com.udea.proint1.microcurriculo.dao;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbAdmDepartamento;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public interface DepartamentoDAO {
	
	public TbAdmDepartamento obtenerDepartamento(int id) throws ExcepcionesDAO;
	
	public List<TbAdmDepartamento> listarDepartamentos() throws ExcepcionesDAO;
	
	public void modificarDepartamentos(TbAdmDepartamento departamento) throws ExcepcionesDAO;
}
