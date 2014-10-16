package com.udea.proint1.microcurriculo.dao;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.Microcurriculos;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

/*
 * Interfaz MicrocurriculosDAO
 * 
 *  Esta Interfaz define los metodos asociados a los Microcurriculos
 *  
 *  @Author.  Grupo Proyecto Integrador I. 2014-2
 */

public interface MicrocurriculosDAO {

	public void guardarMicrocurriculo(Microcurriculos microcurriculo) throws ExcepcionesDAO;
	
	public Microcurriculos obtenerMicrocurriculo(String idMicrocurriculo) throws ExcepcionesDAO;
	
	public void modificarMicrocurriculo (Microcurriculos microcurriculo) throws ExcepcionesDAO;
	
	public List<Microcurriculos> listarMicrocurriculos() throws ExcepcionesDAO;
	
	public List<Microcurriculos> listarMicrocurriculosPorSemestre(String idSemestre) throws ExcepcionesDAO;
	
	public List<Microcurriculos> listarMicrocurriculosPorNucleo(String idNucleo) throws ExcepcionesDAO;
	
	public List<Microcurriculos> listarMicrocurriculosPorMateria(String idMateria) throws ExcepcionesDAO;
	
	public List<Microcurriculos> listarMicrocurriculosPorResponsable(String idResponsable) throws ExcepcionesDAO;
	
	
}
