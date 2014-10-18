package com.udea.proint1.microcurriculo.dao;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.Subtemas;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public interface SubtemasDAO {

	public void guardarSubtema(Subtemas subtema) throws ExcepcionesDAO;
	
	public void modificarSubtema(Subtemas tema) throws ExcepcionesDAO;
	
	public Subtemas obtenerSubtemas(int idSubtema) throws ExcepcionesDAO;
	
	public List<Subtemas> listarSubtemas() throws ExcepcionesDAO;
	
	public List<Subtemas> listarSubtemasPorTema(int idTema) throws ExcepcionesDAO;
}
