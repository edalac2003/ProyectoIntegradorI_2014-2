package com.udea.proint1.microcurriculo.dao;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbMicEvaluaciones;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public interface EvaluacionesDAO {

	public void guardarEvaluaciones(TbMicEvaluaciones evaluacion) throws ExcepcionesDAO;
	
	public TbMicEvaluaciones obtenerEvaluaciones(int id) throws ExcepcionesDAO;
	
	public List<TbMicEvaluaciones> listarEvaluaciones() throws ExcepcionesDAO;
	
	public void actualizarEvaluaciones(TbMicEvaluaciones evaluacion) throws ExcepcionesDAO;
	
	public int contarRegistros() throws ExcepcionesDAO;
}
