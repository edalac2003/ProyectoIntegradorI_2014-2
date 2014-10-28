package com.udea.proint1.microcurriculo.ngc;

import java.util.Date;
import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbMicMateriasxpensum;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface MateriasxpensumNGC {
	
	public TbMicMateriasxpensum obtenerMateriasxpensum (int id) throws ExcepcionesLogica;
	public void guardarMateriasxpensum (TbMicMateriasxpensum materiasxPensum) throws ExcepcionesLogica;
    public void actualizarMateriasxpensum (TbMicMateriasxpensum materiasxPensum) throws ExcepcionesLogica;
    public List<TbMicMateriasxpensum> listarMateriasxpensum () throws ExcepcionesLogica;

}
