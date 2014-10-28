package com.udea.proint1.microcurriculo.ngc;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbAdmPrerrequisitos;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface PrerrequisitosNGC {
	
	public void guardarPrerrequisito(TbAdmPrerrequisitos prerrequisito) throws ExcepcionesLogica;
	
	public void actualizarPrerrequisito(TbAdmPrerrequisitos prerrequisito) throws ExcepcionesLogica;
	
	public List<TbAdmPrerrequisitos> listarPrerrequisitos() throws ExcepcionesLogica;
	
	public TbAdmPrerrequisitos obtenerPrerrequisito(int id) throws ExcepcionesLogica;

}
