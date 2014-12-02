package com.udea.proint1.microcurriculo.dao;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbAdmMaterias;
import com.udea.proint1.microcurriculo.dto.TbAdmPrerrequisitos;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public interface PrerrequisitosDAO {
	
	public List<TbAdmPrerrequisitos> listarPrerrequisitosxMateria(TbAdmMaterias materia) throws ExcepcionesDAO;
	
	public List<TbAdmPrerrequisitos> listarPrerrequisitos() throws ExcepcionesDAO;
	
	public TbAdmPrerrequisitos obtenerPrerrequisito(int id) throws ExcepcionesDAO;
	
	public void guardarPrerrequisito(TbAdmPrerrequisitos prerrequisito) throws ExcepcionesDAO;
	
	public void actualizarPrerrequisito(TbAdmPrerrequisitos prerrequisito) throws ExcepcionesDAO;

}
