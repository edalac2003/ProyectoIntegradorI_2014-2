package com.udea.proint1.microcurriculo.ngc;

import java.util.Date;
import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbAdmMaterias;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface MateriasNGC {

	public void guardarMateria(String id, String idNucleo, String nombre, int semestre, int creditos, 
			int habilitable, int validable, int clasificable, int ht, int hp, int htp, String usuario, Date modFecha) throws ExcepcionesLogica;
	
	public void actualizarMateria(String idNucleo, String nombre, int semestre, int creditos, 
			int habilitable, int validable, int clasificable, int ht, int hp, int htp, String usuario, Date modFecha) throws ExcepcionesLogica;
	
	public TbAdmMaterias obtenerMateria(String id) throws ExcepcionesLogica;
	
	public List<TbAdmMaterias> listarMaterias() throws ExcepcionesLogica;
}
