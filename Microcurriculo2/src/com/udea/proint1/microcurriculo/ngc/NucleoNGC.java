package com.udea.proint1.microcurriculo.ngc;

import java.util.Date;
import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbAdmNucleo;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface NucleoNGC {
	
	public void guardarNucleo(String id, String idDependencia, String nombre, String usuario, Date modFecha) throws ExcepcionesLogica;
	
	public void actualizarNucleo(String idDependencia, String nombre, String usuario, Date modFecha) throws ExcepcionesLogica;

	public List<TbAdmNucleo> obtenerNucleo(String id) throws ExcepcionesLogica;
	
	public TbAdmNucleo listarNucleos() throws ExcepcionesLogica;

}
