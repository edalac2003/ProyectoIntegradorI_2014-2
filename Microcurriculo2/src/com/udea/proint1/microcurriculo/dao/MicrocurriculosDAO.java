package com.udea.proint1.microcurriculo.dao;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbAdmMaterias;
import com.udea.proint1.microcurriculo.dto.TbAdmNucleo;
import com.udea.proint1.microcurriculo.dto.TbAdmPersona;
import com.udea.proint1.microcurriculo.dto.TbMicMicrocurriculos;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

/*
 * Interfaz MicrocurriculosDAO
 * 
 *  Esta Interfaz define los metodos asociados a los Microcurriculos
 *  
 *  @Author.  Grupo Proyecto Integrador I. 2014-2
 */

public interface MicrocurriculosDAO {

	public void guardarMicrocurriculo(TbMicMicrocurriculos microcurriculo) throws ExcepcionesDAO;
	
	public TbMicMicrocurriculos obtenerMicrocurriculo(String idMicrocurriculo) throws ExcepcionesDAO;
	
	public void modificarMicrocurriculo (TbMicMicrocurriculos microcurriculo) throws ExcepcionesDAO;
	
	public List<TbMicMicrocurriculos> listarMicrocurriculos() throws ExcepcionesDAO;
	
	public List<TbMicMicrocurriculos> listarMicrocurriculosPorSemestre(String idSemestre) throws ExcepcionesDAO;
	
	public List<TbMicMicrocurriculos> listarMicrocurriculosPorNucleo(TbAdmNucleo nucleo) throws ExcepcionesDAO;
	
	public List<TbMicMicrocurriculos> listarMicrocurriculosPorMateria(TbAdmMaterias materia) throws ExcepcionesDAO;
	
	public List<TbMicMicrocurriculos> listarMicrocurriculosPorResponsable(TbAdmPersona responsable) throws ExcepcionesDAO;
	
	
}
