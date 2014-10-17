package com.udea.proint1.microcurriculo.dao;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.Bibliografia;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public interface BibliografiaDAO {

	public void guardarBibliografia(Bibliografia bibliografia) throws ExcepcionesDAO;
	
	public void modificarBibliografia(Bibliografia bibliografia) throws ExcepcionesDAO;
	
	public List<Bibliografia> listarBibliografiaPorMicrocurriculo(String idMicrocurriculo) throws ExcepcionesDAO;
	
	public List<Bibliografia> listarBibliografiaPorTipo(String idMicrocurriculo, char tipo) throws ExcepcionesDAO;
}
