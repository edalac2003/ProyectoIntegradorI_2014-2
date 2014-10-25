package com.udea.proint1.microcurriculo.ngc;

import java.util.Date;
import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbAdmPaises;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface PaisesNGC {
	
	public void guardarPais(int id, String nombre, String usuario, Date modFecha) throws ExcepcionesLogica;

	public void actualizarPais(String nombre, String usuario, Date modFecha) throws ExcepcionesLogica;
	
	public List<TbAdmPaises> listarPaises() throws ExcepcionesLogica;
	
	public TbAdmPaises obtenerPais() throws ExcepcionesLogica;
	
}
