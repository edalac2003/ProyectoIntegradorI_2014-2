package com.udea.proint1.microcurriculo.ngc;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbMicEvaluaciones;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface EvaluacionesNGC {

	public void guardarEvaluacion(TbMicEvaluaciones evaluacion) throws ExcepcionesLogica;
	
	public void actualizarEvaluacion(TbMicEvaluaciones evaluacion) throws ExcepcionesLogica;

	public TbMicEvaluaciones obtenerEvaluacion(int id) throws ExcepcionesLogica;
	
	public List<TbMicEvaluaciones> listarEvaluacion() throws ExcepcionesLogica;
	
}
