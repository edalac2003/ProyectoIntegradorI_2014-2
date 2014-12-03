package com.udea.proint1.microcurriculo.ngc;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbMicAutores;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface AutoresNGC {
	
	public TbMicAutores obtenerAutor (int idAutor) throws ExcepcionesLogica;
	
	public void guardarAutores (TbMicAutores autor) throws ExcepcionesLogica;
	
    public void actualizarAutores (TbMicAutores autor) throws ExcepcionesLogica;
    
    public List<TbMicAutores> listarAutores () throws ExcepcionesLogica;

}
