package com.udea.proint1.microcurriculo.ngc;

import java.util.Date;
import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbMicAutorxbiblio;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface AutorxbiblioNGC {

	
	public TbMicAutorxbiblio obtenerEstados (int id) throws ExcepcionesLogica;
	public void guardarAutorxbiblio (int id, int idBibliografia, int idAutor, String usuario, Date fecha) throws ExcepcionesLogica;
    public void actualizarAutorxbiblio (int idBibliografia, int idAutor, String usuario, Date fecha) throws ExcepcionesLogica;
    public List<TbMicAutorxbiblio> listarAutorxbiblio () throws ExcepcionesLogica;
}
