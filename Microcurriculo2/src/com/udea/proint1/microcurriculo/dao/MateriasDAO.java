package com.udea.proint1.microcurriculo.dao;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbAdmMaterias;
import com.udea.proint1.microcurriculo.dto.TbAdmNucleo;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public interface MateriasDAO {
	public void guardarMateria(TbAdmMaterias materia) throws ExcepcionesDAO;
	
	public TbAdmMaterias obtenerMateria(String id) throws ExcepcionesDAO;
	
	public List<TbAdmMaterias> listarMaterias() throws ExcepcionesDAO;
	
	public List<TbAdmMaterias> listarMateriasPorNucleo(TbAdmNucleo nucleo) throws ExcepcionesDAO;
	
	public List<TbAdmMaterias> listarMateriasPorSemestre(int semestre) throws ExcepcionesDAO;
	
	public void actualizarMateria(TbAdmMaterias materia) throws ExcepcionesDAO;
}
