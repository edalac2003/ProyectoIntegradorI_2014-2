package com.udea.proint1.microcurriculo.ngc;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbAdmMaterias;
import com.udea.proint1.microcurriculo.dto.TbAdmNucleo;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface MateriasNGC {

	public void guardarMateria(TbAdmMaterias materia) throws ExcepcionesLogica;
	
	public void actualizarMateria(TbAdmMaterias materia) throws ExcepcionesLogica;
	
	public TbAdmMaterias obtenerMateria(String id) throws ExcepcionesLogica;
	
	public List<TbAdmMaterias> listarMaterias() throws ExcepcionesLogica;
	
	public List<TbAdmMaterias> listarMateriasxNucleo(String nucleo) throws ExcepcionesLogica;
	
	public List<TbAdmMaterias> listarMateriasxSemetre(int semestre) throws ExcepcionesLogica;
}
