package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.udea.proint1.microcurriculo.dao.MateriasDAO;
import com.udea.proint1.microcurriculo.dao.NucleoDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmDependencia;
import com.udea.proint1.microcurriculo.dto.TbAdmMaterias;
import com.udea.proint1.microcurriculo.dto.TbAdmNucleo;
import com.udea.proint1.microcurriculo.dto.TbAdmPersona;
import com.udea.proint1.microcurriculo.dto.TbAdmTipopersona;
import com.udea.proint1.microcurriculo.ngc.MateriasNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class MateriasNGCImpl implements MateriasNGC {
	
	private static Logger log=Logger.getLogger(MateriasNGCImpl.class);
	
	MateriasDAO materiasDao;
	NucleoDAO nucleoDao;

	public void setMateriasDao(MateriasDAO materiasDao) {
		this.materiasDao = materiasDao;
	}

	public void setNucleoDao(NucleoDAO nucleoDao) {
		this.nucleoDao = nucleoDao;
	}

	public MateriasNGCImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean guardarMateria(TbAdmMaterias materia) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		
		boolean correcto = false;
		if(materia == null){
			throw new ExcepcionesLogica("El objeto materias está vacio");
		}
		try {
			String id = materia.getVrIdmateria();
			log.info("Id materia:" + id);
			TbAdmMaterias materiasConsulta = materiasDao.obtenerMateria(id);
			if(materiasConsulta != null){
				throw new ExcepcionesLogica("La materia a insertar ya existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenermaterias de la clase materiasDAO: "+ e);
		}
		
		try {
			
			materiasDao.guardarMateria(materia);
			correcto = true;
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo guardarDependencia de la clase dependenciaDao: "+ e);
		}
		return correcto;
	}

	@Override
	public void actualizarMateria(TbAdmMaterias materia) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(materia == null){
			throw new ExcepcionesLogica("El objeto materias está vacio");
		}
		try {
			String id = materia.getVrIdmateria();
			TbAdmMaterias materiaConsulta = materiasDao.obtenerMateria(id);
		
			if(materiaConsulta == null){
				throw new ExcepcionesLogica("El materias a actualizar no existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerMaterias de la clase materiasDao: "+ e);
		}
		
		try {
			
			materiasDao.actualizarMateria(materia);
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo guardarDependencia de la clase dependenciaDao: "+ e);
		}
	}

	@Override
	public TbAdmMaterias obtenerMateria(String id) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el dato id no sea vacio
		 */
		if("".equals(id) || (id.equals(null))){
			throw new ExcepcionesLogica("No se ha ingresado un ID de Materia Valido.");
		}
		TbAdmMaterias materias = null;
		
		try {
			//le pedimos a la clase Dao que nos traiga la ciudad con dicho id
			materias = materiasDao.obtenerMateria(id);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerMaterias de la clase materiasDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(materias == null){
			//si está vacio tira una excepción
			throw new ExcepcionesLogica("No se encontró dependencia con el id "+ id);
		}else{
			//si no esta vacio retorna la ciudad
			return materias;
		}
	}

	@Override
	public List<TbAdmMaterias> listarMaterias() throws ExcepcionesLogica {
		List<TbAdmMaterias> listaMaterias = null;
		try {
			listaMaterias = materiasDao.listarMaterias();
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo listarMaterias de la clase materiasDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(listaMaterias == null){
			throw new ExcepcionesLogica("No se encontraron materias en la tabla TbAdmMaterias");
		}else{
			return listaMaterias;
		}
	}
	
	@Override
	public List<TbAdmMaterias> listarMateriasxNucleo(String nucleo) throws ExcepcionesLogica{
		List<TbAdmMaterias> listaMaterias = null;
		
		TbAdmNucleo nucleoConsulta = null;
		
		try {
			nucleoConsulta = nucleoDao.obtenerNucleo(nucleo);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerNucleo de la clase NucleoDao: "+ e);
		}
		
		try {
			listaMaterias = materiasDao.listarMateriasPorNucleo(nucleoConsulta);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo listarMateriasPorNucleo de la clase materiasDao: "+ e);
		}
		
			return listaMaterias;
	}
	
	@Override
	public List<TbAdmMaterias> listarMateriasxSemetre(int semestre) throws ExcepcionesLogica{
		List<TbAdmMaterias> listaMaterias = null;
		
		if(semestre == 0){
			throw new ExcepcionesLogica("No se ingreso un semestre");
		}
		
		try{
			listaMaterias = materiasDao.listarMateriasPorSemestre(semestre);
		}catch (ExcepcionesDAO e){
			log.error("Falló al invocar el metodo listarMateriasPorSemestre de la clase materiasDao: "+ e);
		}
		return listaMaterias;
	}
	
	@Override
	public List<TbAdmMaterias> buscarMaterias(String buscar) throws ExcepcionesLogica{
		if(buscar.equals("")||(buscar.equals(null))){
			throw new ExcepcionesLogica("Error no hay id de busqueda identificado");
		}
		List<TbAdmMaterias> listaMaterias = null;
		try {
			listaMaterias = materiasDao.buscarMaterias(buscar);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo buscarMaterias de la clase materiasDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(listaMaterias == null){
			throw new ExcepcionesLogica("No se encontraron materias en la tabla TbAdmMaterias");
		}else{
			return listaMaterias;
		}
	}
		
}
