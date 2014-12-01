package com.udea.proint1.microcurriculo.dao;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbMicAutorxbiblio;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public interface AutorxBiblioDAO {
	public void guardarAutorxBibliografia(TbMicAutorxbiblio autorxBibliografia) throws ExcepcionesDAO;
	
	public TbMicAutorxbiblio obtenerAutorxBibliografia(int id) throws ExcepcionesDAO;
	
	public List<TbMicAutorxbiblio> listarAutorxBibliografia() throws ExcepcionesDAO;
	
	public void actualizarAutorxBibliografia(TbMicAutorxbiblio autorxBibliografia) throws ExcepcionesDAO;
}
