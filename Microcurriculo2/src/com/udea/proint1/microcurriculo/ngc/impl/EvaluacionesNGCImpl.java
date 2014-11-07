package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.udea.proint1.microcurriculo.dao.EvaluacionesDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmDependencia;
import com.udea.proint1.microcurriculo.dto.TbMicEvaluaciones;
import com.udea.proint1.microcurriculo.ngc.EvaluacionesNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class EvaluacionesNGCImpl implements EvaluacionesNGC {
	
	private static Logger log=Logger.getLogger(EvaluacionesNGCImpl.class);
	
	EvaluacionesDAO evaluacionesDao;

	public void setEvaluacionesDao(EvaluacionesDAO evaluacionesDao) {
		this.evaluacionesDao = evaluacionesDao;
	}

	public EvaluacionesNGCImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void guardarEvaluacion(TbMicEvaluaciones evaluacion) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto no esté vacio
		 */
		if(evaluacion == null){
			throw new ExcepcionesLogica("El objeto evaluacion está vacio");
		}
		try {
			int id = evaluacion.getNbIdevaluacion();
			TbMicEvaluaciones evaluacionConsulta = evaluacionesDao.obtenerEvaluaciones(id);
		
			if(evaluacionConsulta != null){
				throw new ExcepcionesLogica("La evaluacion a insertar ya existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerEvaluaciones de la clase evaluacionesDao: "+ e);
		}
		
		try {
			
			evaluacionesDao.guardarEvaluaciones(evaluacion);
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo guardarEvaluaciones de la clase evaluacionesDao: "+ e);
		}
	}

	@Override
	public void actualizarEvaluacion(TbMicEvaluaciones evaluacion) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto no esté vacio
		 */
		if(evaluacion == null){
			throw new ExcepcionesLogica("El objeto evaluacion está vacio");
		}
		try {
			int id = evaluacion.getNbIdevaluacion();
			TbMicEvaluaciones evaluacionConsulta = evaluacionesDao.obtenerEvaluaciones(id);
		
			if(evaluacionConsulta == null){
				throw new ExcepcionesLogica("La evaluacion a actualizar no existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerEvaluaciones de la clase evaluacionesDao: "+ e);
		}
		
		try {
			
			evaluacionesDao.actualizarEvaluaciones(evaluacion);
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo actualizarEvaluaciones de la clase evaluacionesDao: "+ e);
		}
	}

	@Override
	public TbMicEvaluaciones obtenerEvaluacion(int id) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el dato id no sea vacio
		 */
		if(id==0){
			throw new ExcepcionesLogica("No se ha ingresado una identificación de evaluacion, está vacia");
		}
		TbMicEvaluaciones evaluacion = null;
		
		try {
			evaluacion = evaluacionesDao.obtenerEvaluaciones(id);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerEvaluaciones de la clase evaluacionesDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(evaluacion == null){
			//si está vacio tira una excepción
			throw new ExcepcionesLogica("No se encontró evaluacion con el id "+ id);
		}else{
			return evaluacion;
		}
	}

	@Override
	public List<TbMicEvaluaciones> listarEvaluacion() throws ExcepcionesLogica {
		List<TbMicEvaluaciones> listaEvaluaciones = null;
		try {
			listaEvaluaciones = evaluacionesDao.listarEvaluaciones();
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo listarEvaluaciones de la clase evaluacionesDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(listaEvaluaciones == null){
			throw new ExcepcionesLogica("No se encontraron evaluaciones en la tabla TbMicEvaluaciones");
		}else{
			return listaEvaluaciones;
		}
	}

}
