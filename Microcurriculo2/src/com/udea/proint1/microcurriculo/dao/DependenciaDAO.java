package com.udea.proint1.microcurriculo.dao;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbAdmDependencia;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public interface DependenciaDAO {

	public void guardarDependencia(TbAdmDependencia dependencias) throws ExcepcionesDAO;
	
	public TbAdmDependencia obtenerDependencias(String id) throws ExcepcionesDAO;
	
	public List<TbAdmDependencia> listarDependencias() throws ExcepcionesDAO;
	
	public void actualizarDependencias(TbAdmDependencia dependencias) throws ExcepcionesDAO;

	public List<TbAdmDependencia> buscarDependencias(String buscar) throws ExcepcionesDAO;
	
}
