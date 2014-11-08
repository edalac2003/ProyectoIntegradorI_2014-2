package com.udea.proint1.microcurriculo.dao;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbMicEvaluacionxmicro;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public interface EvaluacionxmicroDAO {
	
	public void guardarEvaluacionesxmicro(TbMicEvaluacionxmicro evaluacionxMicro) throws ExcepcionesDAO;
	
	public TbMicEvaluacionxmicro obtenerEvaluacionesxmicro(int id) throws ExcepcionesDAO;
	
	public List<TbMicEvaluacionxmicro> listarEvaluacionesxmicro() throws ExcepcionesDAO;
	
	public void actualizarEvaluacionesxmicro(TbMicEvaluacionxmicro evaluacionxMicro) throws ExcepcionesDAO;
}
