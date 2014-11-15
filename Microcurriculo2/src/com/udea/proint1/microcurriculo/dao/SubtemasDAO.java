package com.udea.proint1.microcurriculo.dao;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbMicSubtemas;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public interface SubtemasDAO {

	public void guardarSubtema(TbMicSubtemas subtema) throws ExcepcionesDAO;
	
	public void guardarSubtema(List<TbMicSubtemas> listaSubtema) throws ExcepcionesDAO;
	
	public void modificarSubtema(TbMicSubtemas tema) throws ExcepcionesDAO;
	
	public TbMicSubtemas obtenerSubtemas(int idSubtema) throws ExcepcionesDAO;
	
	public List<TbMicSubtemas> listarSubtemas() throws ExcepcionesDAO;
	
	public List<TbMicSubtemas> listarSubtemas(int idTema) throws ExcepcionesDAO;
	
	public int contarRegistros() throws ExcepcionesDAO;
}
