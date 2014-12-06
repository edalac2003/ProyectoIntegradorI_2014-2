package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.udea.proint1.microcurriculo.dao.EvaluacionDAO;
import com.udea.proint1.microcurriculo.dao.EvaluacionxMicroDAO;
import com.udea.proint1.microcurriculo.dao.MicrocurriculoDAO;
import com.udea.proint1.microcurriculo.dto.TbMicEvaluacionxmicro;
import com.udea.proint1.microcurriculo.ngc.EvaluacionxMicroNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class EvaluacionxMicroNGCImpl implements EvaluacionxMicroNGC {
	
	private static Logger log=Logger.getLogger(EvaluacionNGCImpl.class);
	
	MicrocurriculoDAO microcurriculoDao;
	
	EvaluacionDAO evaluacionDao;
	
	EvaluacionxMicroDAO evaluacionxMicroDao;

	public void setMicrocurriculoDao(MicrocurriculoDAO microcurriculoDao) {
		this.microcurriculoDao = microcurriculoDao;
	}

	public void setEvaluacionDao(EvaluacionDAO evaluacionDao) {
		this.evaluacionDao = evaluacionDao;
	}

	public void setEvaluacionxMicroDao(EvaluacionxMicroDAO evaluacionxMicroDao) {
		this.evaluacionxMicroDao = evaluacionxMicroDao;
	}

	public EvaluacionxMicroNGCImpl() {
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
			TbMicEvaluacionxmicro evaluacionxMicroConsulta = evaluacionxMicroDao.obtenerEvaluacionesxmicro(id);
		
			if(evaluacionxMicroConsulta != null){
				throw new ExcepcionesLogica("La evaluacionxMicro a insertar ya existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerEvaluacionesxmicro de la clase evaluacionxmicroDao: "+ e);
		}
		
		try {
			
			evaluacionxMicroDao.guardarEvaluacionesxmicro(evaluacionxMicro);
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo guardarEvaluacionesxmicro de la clase evaluacionxmicroDao: "+ e);
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
			TbMicEvaluacionxmicro evaluacionxMicroConsulta = evaluacionxMicroDao.obtenerEvaluacionesxmicro(id);
		
			if(evaluacionxMicroConsulta == null){
				throw new ExcepcionesLogica("La evaluacionxmicroDao a actualizar no existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerEvaluacionesxmicro de la clase evaluacionxmicroDao: "+ e);
		}
		
		try {
			
			evaluacionxMicroDao.actualizarEvaluacionesxmicro(evaluacionxMicro);
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo actualizarEvaluacionesxmicro de la clase evaluacionxmicroDao: "+ e);
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
			evaluacionxMicro = evaluacionxMicroDao.obtenerEvaluacionesxmicro(id);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerEvaluacionesxmicro de la clase evaluacionxmicroDao: "+ e);
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
			listaEvaluacionesxMicro = evaluacionxMicroDao.listarEvaluacionesxmicro();
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo listarEvaluaciones de la clase evaluacionxmicroDao: "+ e);
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
