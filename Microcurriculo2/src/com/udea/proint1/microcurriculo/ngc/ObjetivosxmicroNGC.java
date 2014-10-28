package com.udea.proint1.microcurriculo.ngc;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbMicObjetivosxmicro;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface ObjetivosxmicroNGC {
	
	public TbMicObjetivosxmicro obtenerObjetivosxmicro (int id) throws ExcepcionesLogica;
	public void guardarObjetivosxmicro (TbMicObjetivosxmicro objetivosxmicro) throws ExcepcionesLogica;
    public void actualizarObjetivosxmicro (TbMicObjetivosxmicro objetivosxmicro) throws ExcepcionesLogica;
    public List<TbMicObjetivosxmicro> listarObjetivosxmicro () throws ExcepcionesLogica;

}
