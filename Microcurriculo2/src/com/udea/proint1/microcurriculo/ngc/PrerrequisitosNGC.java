package com.udea.proint1.microcurriculo.ngc;

import java.util.Date;
import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbAdmPrerrequisitos;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface PrerrequisitosNGC {
	
	public void guardarPrerrequisito(int id, String idMateria1, String idMateria2, String usuario, Date modFecha) throws ExcepcionesLogica;
	
	public void actualizarPrerrequisito(String idMateria1, String idMateria2, String usuario, Date modFecha) throws ExcepcionesLogica;
	
	public List<TbAdmPrerrequisitos> listarPrerrequisitos() throws ExcepcionesLogica;
	
	public TbAdmPrerrequisitos obtenerPrerrequisito(int id) throws ExcepcionesLogica;

}
