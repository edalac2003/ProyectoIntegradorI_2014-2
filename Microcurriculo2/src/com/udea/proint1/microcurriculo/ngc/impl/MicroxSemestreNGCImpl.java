package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.udea.proint1.microcurriculo.dao.MicrocurriculoDAO;
import com.udea.proint1.microcurriculo.dao.MicroxSemestreDAO;
import com.udea.proint1.microcurriculo.dao.SemestreDAO;
import com.udea.proint1.microcurriculo.dto.TbMicMicroxsemestre;
import com.udea.proint1.microcurriculo.ngc.MicroxSemestreNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class MicroxSemestreNGCImpl implements MicroxSemestreNGC {
	
	private static Logger log=Logger.getLogger(MicroxSemestreNGCImpl.class);
	
	MicroxSemestreDAO microxSemestreDao;
	MicrocurriculoDAO microcurriculoDao;
	SemestreDAO semestreDao;

	
	public void setmicroxSemestreDao(MicroxSemestreDAO microxSemestreDao) {
		this.microxSemestreDao = microxSemestreDao;
	}

	public void setMicrocurriculoDao(MicrocurriculoDAO microcurriculoDao) {
		this.microcurriculoDao = microcurriculoDao;
	}

	public void setSemestreDao(SemestreDAO semestreDao) {
		this.semestreDao = semestreDao;
	}

	
	
	@Override
	public void guardarMicroxsemestre(TbMicMicroxsemestre microxSemestre)
			throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto no esté vacio
		 */
		if(microxSemestre == null){
			throw new ExcepcionesLogica("El objeto microxSemestre está vacio");
		}
		try {
			int id = microxSemestre.getNbId();
			TbMicMicroxsemestre microxSemestreConsulta = microxSemestreDao.obtenerMicroxsemestre(id);
		
			if(microxSemestreConsulta != null){
				throw new ExcepcionesLogica("La microxSemestre a insertar ya existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerMicroxsemestre de la clase microxSemestreDao: "+ e);
		}
		
		try {
			
			microxSemestreDao.guardarMicroxsemestre(microxSemestre);;
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo guardarMicroxsemestre de la clase microxSemestreDao: "+ e);
		}
	}

	
	@Override
	public void actualizarMicroxsemestre(TbMicMicroxsemestre microxSemestre)
			throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto no esté vacio
		 */
		if(microxSemestre == null){
			throw new ExcepcionesLogica("El objeto microxSemestre está vacio");
		}
		try {
			int id = microxSemestre.getNbId();
			TbMicMicroxsemestre microxsemestreConsulta = microxSemestreDao.obtenerMicroxsemestre(id);
		
			if(microxsemestreConsulta == null){
				throw new ExcepcionesLogica("La microxsemestre a actualizar no existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerMicroxsemestre de la clase microxSemestreDao");
		}
		
		try {
			
			microxSemestreDao.actualizarMicroxsemestre(microxSemestre);;
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo actualizarEvaluacionesxmicro de la clase microxSemestreDao: "+ e);
		}
	}

	@Override
	public TbMicMicroxsemestre obtenerMicroxsemestre(int id)
			throws ExcepcionesLogica {
		/*
		 * Comprobamos que el dato id no sea vacio
		 */
		if(id==0){
			throw new ExcepcionesLogica("No se ha ingresado una identificación de microxSemestre, está vacia");
		}
		TbMicMicroxsemestre microxSemestre = null;
		
		try {
			microxSemestre = microxSemestreDao.obtenerMicroxsemestre(id);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerMicroxsemestre de la clase microxSemestreDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(microxSemestre == null){
			//si está vacio tira una excepción
			throw new ExcepcionesLogica("No se encontró microxSemestre con el id "+ id);
		}else{
			return microxSemestre;
		}
	}

	@Override
	public List<TbMicMicroxsemestre> listarMicroxsemestre()
			throws ExcepcionesLogica {
		List<TbMicMicroxsemestre> listaMicrosxsemestre = null;
		try {
			listaMicrosxsemestre = microxSemestreDao.listarMicroxsemestre();
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo listarMicroxsemestre de la clase microxSemestreDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(listaMicrosxsemestre == null){
			throw new ExcepcionesLogica("No se encontraron Microsxsemestre en la tabla TbMicMicroxsemestre");
		}else{
			return listaMicrosxsemestre;
		}
	}
	
	@Override
	public int ContarMicrosxsemestre() throws ExcepcionesLogica{
		int registros = 0;
		
		try{
			registros = microxSemestreDao.ContarMicrosxsemestre();
		}catch(ExcepcionesDAO e){
			log.error("falló al invocar el metodo ContarMicrosxsemestre de la clase microxSemestreDao: "+ e);
		}
		
		return registros;
	}

}
