package com.udea.proint1.microcurriculo.dao;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbMicObservacionxmicro;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public interface ObservacionxMicroDAO{

	public void guardarObservacionxMicro(TbMicObservacionxmicro observacionxMicro) throws ExcepcionesDAO;
	
	public TbMicObservacionxmicro obtenerObservacionxMicro(int id) throws ExcepcionesDAO;
	
	public List<TbMicObservacionxmicro> listarObservacionxMicro() throws ExcepcionesDAO;
	
	public void actualizarObservacionxMicro(TbMicObservacionxmicro observacionxMicro) throws ExcepcionesDAO;
	
}
