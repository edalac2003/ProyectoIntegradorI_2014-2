package com.udea.proint1.microcurriculo.dao;

import java.util.List;


import com.udea.proint1.microcurriculo.dto.Materias;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public interface MateriasDAO {
	public void guardarMateria(Materias materia) throws ExcepcionesDAO;
	
	public Materias obtenerMateria(String id) throws ExcepcionesDAO;
	
	public List<Materias> listarMaterias() throws ExcepcionesDAO;
	
	public List<Materias> listarMateriasPorNucleo(String nucleo) throws ExcepcionesDAO;
	
	public List<Materias> listarMateriasPorSemestre(int semestre) throws ExcepcionesDAO;
	
	public void actualizarMateria(Materias materia) throws ExcepcionesDAO;
}
