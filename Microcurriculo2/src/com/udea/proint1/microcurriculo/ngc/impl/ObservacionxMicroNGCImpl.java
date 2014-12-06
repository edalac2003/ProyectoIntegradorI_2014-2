package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.udea.proint1.microcurriculo.dao.ObservacionxMicroDAO;
import com.udea.proint1.microcurriculo.dto.TbMicObservacionxmicro;
import com.udea.proint1.microcurriculo.ngc.ObservacionxMicroNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class ObservacionxMicroNGCImpl implements ObservacionxMicroNGC {

	private static Logger log=Logger.getLogger(ObservacionxMicroNGCImpl.class);

	ObservacionxMicroDAO observacionxMicroDao;
	
	public void setObservacionxMicroDao(ObservacionxMicroDAO observacionxMicroDao) {
		this.observacionxMicroDao = observacionxMicroDao;
	}

	@Override
	public TbMicObservacionxmicro obtenerObservacionxMicro(int id)
			throws ExcepcionesLogica {
		/*
		 * Comprobamos que el dato id no sea vacio
		 */
		if(id == 0){
			throw new ExcepcionesLogica("No se ha ingresado una identificación de observacionxMicro, está vacia");
		}
		TbMicObservacionxmicro observacionxMicro = null;
		
		try {
			//le pedimos a la clase Dao que nos traiga la ciudad con dicho id
			observacionxMicro = observacionxMicroDao.obtenerObservacionxMicro(id);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerObservacionxMicro de la clase observacionxMicroDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(observacionxMicro == null){
			//si está vacio tira una excepción
			throw new ExcepcionesLogica("No se encontró observacionxMicro con el id "+ id);
		}else{
			return observacionxMicro;
		}
	}

	@Override
	public void guardarObservacionxMicro(
			TbMicObservacionxmicro observacionxmicro) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(observacionxmicro == null){
			throw new ExcepcionesLogica("El objeto observacionxmicro está vacio");
		}
		try {
			int id = observacionxmicro.getNbId();
			TbMicObservacionxmicro actaxMicroConsulta = observacionxMicroDao.obtenerObservacionxMicro(id);
		
			if(actaxMicroConsulta != null){
				throw new ExcepcionesLogica("La observacionxmicro a insertar ya existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerObservacionxMicro de la clase observacionxMicroDao: "+ e);
		}
		
		try {
			
			observacionxMicroDao.guardarObservacionxMicro(observacionxmicro);
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo guardarObservacionxMicro de la clase observacionxMicroDao: "+ e);
		}
	}

	@Override
	public void actualizarObservacionxMicro(
			TbMicObservacionxmicro observacionxmicro) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(observacionxmicro == null){
			throw new ExcepcionesLogica("El objeto observacionxmicro está vacio");
		}
		try {
			int id = observacionxmicro.getNbId();
			TbMicObservacionxmicro observacionxmicroConsulta = observacionxMicroDao.obtenerObservacionxMicro(id);
		
			if(observacionxmicroConsulta == null){
				throw new ExcepcionesLogica("La observacionxmicro a actualizar no existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerObservacionxMicro de la clase observacionxMicroDao: "+ e);
		}
		
		try {
			
			observacionxMicroDao.actualizarObservacionxMicro(observacionxmicro);
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo actualizarObservacionxMicro de la clase observacionxMicroDao: "+ e);
		}
	}

	@Override
	public List<TbMicObservacionxmicro> listarObservacionxMicro()
			throws ExcepcionesLogica {
		List<TbMicObservacionxmicro> listaObservacionxmicro = null;
		try {
			listaObservacionxmicro = observacionxMicroDao.listarObservacionxMicro();
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo listarObservacionxMicro de la clase observacionxMicroDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(listaObservacionxmicro == null){
			throw new ExcepcionesLogica("No se encontraron Observacionxmicro en la tabla TbMicObservacionxmicro");
		}else{
			return listaObservacionxmicro;
		}
	}

}
