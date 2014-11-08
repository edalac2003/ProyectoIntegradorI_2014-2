package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.udea.proint1.microcurriculo.dao.EvaluacionesDAO;
import com.udea.proint1.microcurriculo.dao.EvaluacionxmicroDAO;
import com.udea.proint1.microcurriculo.dao.MicrocurriculosDAO;
import com.udea.proint1.microcurriculo.dto.TbMicEvaluaciones;
import com.udea.proint1.microcurriculo.dto.TbMicEvaluacionxmicro;
import com.udea.proint1.microcurriculo.ngc.EvaluacionxmicroNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class EvaluacionxmicroNGCImpl implements EvaluacionxmicroNGC {
	
	private static Logger log=Logger.getLogger(EvaluacionesNGCImpl.class);
	
	MicrocurriculosDAO microcurriculosDao;
	
	EvaluacionesDAO evaluacionesDao;
	
	EvaluacionxmicroDAO evaluacionesxmicroDao;

	public void setMicrocurriculosDao(MicrocurriculosDAO microcurriculosDao) {
		this.microcurriculosDao = microcurriculosDao;
	}

	public void setEvaluacionesDao(EvaluacionesDAO evaluacionesDao) {
		this.evaluacionesDao = evaluacionesDao;
	}

	public void setEvaluacionesxmicroDao(EvaluacionxmicroDAO evaluacionesxmicroDao) {
		this.evaluacionesxmicroDao = evaluacionesxmicroDao;
	}

	public EvaluacionxmicroNGCImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void guardarEvaluacionxmicro(TbMicEvaluacionxmicro evaluacionxMicro) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto no esté vacio
		 */
		if(evaluacionxMicro == null){
			throw new ExcepcionesLogica("El objeto evaluacionxMicro está vacio");
		}
		try {
			int id = evaluacionxMicro.getNbId();
			TbMicEvaluacionxmicro evaluacionxMicroConsulta = evaluacionesxmicroDao.obtenerEvaluacionesxmicro(id);
		
			if(evaluacionxMicroConsulta != null){
				throw new ExcepcionesLogica("La evaluacionxMicro a insertar ya existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerEvaluacionesxmicro de la clase evaluacionesxmicroDao: "+ e);
		}
		
		try {
			
			evaluacionesxmicroDao.guardarEvaluacionesxmicro(evaluacionxMicro);
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo guardarEvaluacionesxmicro de la clase evaluacionesxmicroDao: "+ e);
		}
	}

	@Override
	public void actualizarEvaluacionxmicro(TbMicEvaluacionxmicro evaluacionxMicro) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto no esté vacio
		 */
		if(evaluacionxMicro == null){
			throw new ExcepcionesLogica("El objeto evaluacionxMicro está vacio");
		}
		try {
			int id = evaluacionxMicro.getNbId();
			TbMicEvaluacionxmicro evaluacionxMicroConsulta = evaluacionesxmicroDao.obtenerEvaluacionesxmicro(id);
		
			if(evaluacionxMicroConsulta == null){
				throw new ExcepcionesLogica("La evaluacionesxmicroDao a actualizar no existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerEvaluacionesxmicro de la clase evaluacionesxmicroDao: "+ e);
		}
		
		try {
			
			evaluacionesxmicroDao.actualizarEvaluacionesxmicro(evaluacionxMicro);
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo actualizarEvaluacionesxmicro de la clase evaluacionesxmicroDao: "+ e);
		}
	}

	@Override
	public TbMicEvaluacionxmicro obtenerEvaluacionxmicro(int id) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el dato id no sea vacio
		 */
		if(id==0){
			throw new ExcepcionesLogica("No se ha ingresado una identificación de evaluacionxMicro, está vacia");
		}
		TbMicEvaluacionxmicro evaluacionxMicro = null;
		
		try {
			evaluacionxMicro = evaluacionesxmicroDao.obtenerEvaluacionesxmicro(id);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerEvaluacionesxmicro de la clase evaluacionesxmicroDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(evaluacionxMicro == null){
			//si está vacio tira una excepción
			throw new ExcepcionesLogica("No se encontró evaluacionxMicro con el id "+ id);
		}else{
			return evaluacionxMicro;
		}
	}

	@Override
	public List<TbMicEvaluacionxmicro> actualizarEvaluacionesxmicro() throws ExcepcionesLogica {
		List<TbMicEvaluacionxmicro> listaEvaluacionesxMicro = null;
		try {
			listaEvaluacionesxMicro = evaluacionesxmicroDao.listarEvaluacionesxmicro();
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo listarEvaluaciones de la clase evaluacionesxmicroDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(listaEvaluacionesxMicro == null){
			throw new ExcepcionesLogica("No se encontraron EvaluacionesxMicro en la tabla TbMicEvaluacionesxmicro");
		}else{
			return listaEvaluacionesxMicro;
		}
	}

}
