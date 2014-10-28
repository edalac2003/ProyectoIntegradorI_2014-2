package com.udea.proint1.microcurriculo.ngc;

import java.util.Date;
import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbAdmDocentesxnucleo;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface DocentesxNucleoNGC {
	
	public void guardarDocentexNucleo(TbAdmDocentesxnucleo docentexNucleo) throws ExcepcionesLogica;
	
	public void actualizarDocentexNucleo(TbAdmDocentesxnucleo docentexNucleo) throws ExcepcionesLogica;

	public List<TbAdmDocentesxnucleo> listarDocentesxNucleo() throws ExcepcionesLogica;
	
	public TbAdmDocentesxnucleo obtenerDocentexNucleo(int id) throws ExcepcionesLogica;
}
