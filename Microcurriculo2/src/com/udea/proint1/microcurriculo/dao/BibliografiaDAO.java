package com.udea.proint1.microcurriculo.dao;

import java.util.List;
import com.udea.proint1.microcurriculo.dto.TbMicBibliografia;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public interface BibliografiaDAO {

	public void guardarBibliografia(TbMicBibliografia bibliografia) throws ExcepcionesDAO;
	
	public void modificarBibliografia(TbMicBibliografia bibliografia) throws ExcepcionesDAO;
	
	public List<TbMicBibliografia> listarBibliografia(String idMicrocurriculo) throws ExcepcionesDAO;
	
	public List<TbMicBibliografia> listarBibliografiaxTipo(char tipo) throws ExcepcionesDAO;
	
	public int contarRegistros() throws ExcepcionesDAO;
}
