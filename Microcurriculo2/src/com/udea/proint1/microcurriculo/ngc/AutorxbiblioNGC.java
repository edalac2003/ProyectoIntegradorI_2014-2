package com.udea.proint1.microcurriculo.ngc;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbMicAutorxbiblio;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface AutorxbiblioNGC {

	
	public TbMicAutorxbiblio obtenerEstados (int id) throws ExcepcionesLogica;
	public void guardarAutorxbiblio (TbMicAutorxbiblio autorxBiblio) throws ExcepcionesLogica;
    public void actualizarAutorxbiblio (TbMicAutorxbiblio autorxBiblio) throws ExcepcionesLogica;
    public List<TbMicAutorxbiblio> listarAutorxbiblio () throws ExcepcionesLogica;
}
