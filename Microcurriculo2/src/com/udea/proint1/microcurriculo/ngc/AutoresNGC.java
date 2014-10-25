package com.udea.proint1.microcurriculo.ngc;

import java.util.Date;
import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbMicAutores;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface AutoresNGC {
	
	public TbMicAutores obtenerEstados (int idAutor) throws ExcepcionesLogica;
	public void guardarAutores (int idAutor, String nombres, String apellidos, int pais, String usuario, Date fecha) throws ExcepcionesLogica;
    public void actualizarAutores (String nombres, String apellidos, int pais, String usuario, Date fecha) throws ExcepcionesLogica;
    public List<TbMicAutores> listarAutores () throws ExcepcionesLogica;

}
