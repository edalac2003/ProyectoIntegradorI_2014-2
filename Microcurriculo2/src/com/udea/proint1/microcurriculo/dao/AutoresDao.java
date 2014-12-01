package com.udea.proint1.microcurriculo.dao;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbMicAutores;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public interface AutoresDao {

	public void guardarAutores(TbMicAutores autores) throws ExcepcionesDAO;
	
	public TbMicAutores obtenerAutores(int id) throws ExcepcionesDAO;
	
	public List<TbMicAutores> listarAutores() throws ExcepcionesDAO;
	
	public void actualizarAutores(TbMicAutores autores) throws ExcepcionesDAO;
}
