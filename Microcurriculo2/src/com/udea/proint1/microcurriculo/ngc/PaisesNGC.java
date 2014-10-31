package com.udea.proint1.microcurriculo.ngc;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbAdmPaises;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface PaisesNGC {
	
	public List<TbAdmPaises> listarPaises() throws ExcepcionesLogica;
	
	public TbAdmPaises obtenerPais(int id) throws ExcepcionesLogica;
	
}
