package com.udea.proint1.microcurriculo.ngc;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbAdmNucleo;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface NucleoNGC {
	
	public void guardarNucleo(TbAdmNucleo nucleo) throws ExcepcionesLogica;
	
	public void actualizarNucleo(TbAdmNucleo nucleo) throws ExcepcionesLogica;

	public List<TbAdmNucleo> obtenerNucleo(String id) throws ExcepcionesLogica;
	
	public TbAdmNucleo listarNucleos() throws ExcepcionesLogica;

}
