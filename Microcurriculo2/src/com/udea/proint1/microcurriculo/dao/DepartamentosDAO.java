package com.udea.proint1.microcurriculo.dao;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.Departamentos;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public interface DepartamentosDAO {
	public void guardarDepartamento(Departamentos departamento) throws ExcepcionesDAO;
	
	public Departamentos obtenerDepartamento(int id) throws ExcepcionesDAO;
	
	public List<Departamentos> listarDepartamentos() throws ExcepcionesDAO;
	
	public void modificarDepartamentos(Departamentos departamento) throws ExcepcionesDAO;
}
