package com.udea.proint1.microcurriculo.ngc;

import java.util.Date;
import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbAdmDocentesxnucleo;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface DocentesxNucleoNGC {
	
	public void guardarDocentexNucleo(int id, String idNucleo, String idPersona, String usuario, Date modFecha) throws ExcepcionesLogica;
	
	public void actualizarDocentexNucleo(String idNucleo, String idPersona, String usuario, Date modFecha) throws ExcepcionesLogica;

	public List<TbAdmDocentesxnucleo> listarDocentesxNucleo() throws ExcepcionesLogica;
	
	public TbAdmDocentesxnucleo obtenerDocentexNucleo(int id) throws ExcepcionesLogica;
}
