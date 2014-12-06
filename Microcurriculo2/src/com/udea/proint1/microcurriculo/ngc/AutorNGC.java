package com.udea.proint1.microcurriculo.ngc;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbMicAutor;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface AutorNGC {
	
	public TbMicAutor obtenerAutor (int idAutor) throws ExcepcionesLogica;
	
	public void guardarAutores (TbMicAutor autor) throws ExcepcionesLogica;
	
    public void actualizarAutores (TbMicAutor autor) throws ExcepcionesLogica;
    
    public List<TbMicAutor> listarAutores () throws ExcepcionesLogica;

}
