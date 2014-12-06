package com.udea.proint1.microcurriculo.dao;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbMicAutor;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public interface AutorDao {

	public void guardarAutores(TbMicAutor autores) throws ExcepcionesDAO;
	
	public TbMicAutor obtenerAutores(int id) throws ExcepcionesDAO;
	
	public List<TbMicAutor> listarAutores() throws ExcepcionesDAO;
	
	public void actualizarAutores(TbMicAutor autores) throws ExcepcionesDAO;
}
