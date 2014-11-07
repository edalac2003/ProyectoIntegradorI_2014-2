package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.udea.proint1.microcurriculo.dao.MicrocurriculosDAO;
import com.udea.proint1.microcurriculo.dao.MicroxSemestreDAO;
import com.udea.proint1.microcurriculo.dao.SemestreDAO;
import com.udea.proint1.microcurriculo.dto.TbMicEvaluacionxmicro;
import com.udea.proint1.microcurriculo.dto.TbMicMicroxsemestre;
import com.udea.proint1.microcurriculo.ngc.MicroxsemestreNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class MicroxsemestreNGCIMpl implements MicroxsemestreNGC {
	
	private static Logger log=Logger.getLogger(MicroxsemestreNGCIMpl.class);
	
	MicroxSemestreDAO microxsemestreDao;
	
	MicrocurriculosDAO microcurriculosDao;
	
	SemestreDAO semestreDao;

	public void setMicroxsemestreDao(MicroxSemestreDAO microxsemestreDao) {
		this.microxsemestreDao = microxsemestreDao;
	}

	public void setMicrocurriculosDao(MicrocurriculosDAO microcurriculosDao) {
		this.microcurriculosDao = microcurriculosDao;
	}

	public void setSemestreDao(SemestreDAO semestreDao) {
		this.semestreDao = semestreDao;
	}

	public MicroxsemestreNGCIMpl() {
		// TODO Auto-generated constructor stub
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
			TbMicMicroxsemestre microxSemestreConsulta = microxsemestreDao.obtenerMicroxsemestre(id);
		
			if(microxSemestreConsulta != null){
				throw new ExcepcionesLogica("La microxSemestre a insertar ya existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerMicroxsemestre de la clase microxsemestreDao: "+ e);
		}
		
		try {
			
			microxsemestreDao.guardarMicroxsemestre(microxSemestre);;
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo guardarMicroxsemestre de la clase microxsemestreDao: "+ e);
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
			TbMicMicroxsemestre microxsemestreConsulta = microxsemestreDao.obtenerMicroxsemestre(id);
		
			if(microxsemestreConsulta == null){
				throw new ExcepcionesLogica("La microxsemestre a actualizar no existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerMicroxsemestre de la clase microxsemestreDao");
		}
		
		try {
			
			microxsemestreDao.actualizarMicroxsemestre(microxSemestre);;
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo actualizarEvaluacionesxmicro de la clase microxsemestreDao: "+ e);
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
			microxSemestre = microxsemestreDao.obtenerMicroxsemestre(id);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerMicroxsemestre de la clase microxsemestreDao: "+ e);
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
			listaMicrosxsemestre = microxsemestreDao.listarMicroxsemestre();
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo listarMicroxsemestre de la clase microxsemestreDao: "+ e);
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

}
