package com.udea.proint1.microcurriculo.ngc;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbMicObservacionxmicro;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface ObservacionxMicroNGC {

	public TbMicObservacionxmicro obtenerObservacionxMicro (int id) throws ExcepcionesLogica;
	
	public void guardarObservacionxMicro (TbMicObservacionxmicro observacionxmicro) throws ExcepcionesLogica;
	
    public void actualizarObservacionxMicro (TbMicObservacionxmicro observacionxmicro) throws ExcepcionesLogica;
    
    public List<TbMicObservacionxmicro> listarObservacionxMicro () throws ExcepcionesLogica;
	
}
