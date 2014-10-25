package com.udea.proint1.microcurriculo.ngc;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbAdmCiudades;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface CiudadesNGC {
	
	public TbAdmCiudades obtenerCiudad(int id) throws ExcepcionesLogica;
	
	public List<TbAdmCiudades> listarCiudades() throws ExcepcionesLogica;

}
