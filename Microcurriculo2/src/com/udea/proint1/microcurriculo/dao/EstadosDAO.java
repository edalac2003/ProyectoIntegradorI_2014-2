package com.udea.proint1.microcurriculo.dao;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbMicEstados;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public interface EstadosDAO {
	
	public void guardarEstado(TbMicEstados estado) throws ExcepcionesDAO; 
	
	public TbMicEstados obtenerEstado(int idEstado) throws ExcepcionesDAO;
	
	public TbMicEstados obtenerEstadoxNombre(String nombre) throws ExcepcionesDAO;
	
	public List<TbMicEstados> listarEstados() throws ExcepcionesDAO;
}
