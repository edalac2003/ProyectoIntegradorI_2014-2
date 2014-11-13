package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.udea.proint1.microcurriculo.dao.SubtemasDAO;
import com.udea.proint1.microcurriculo.dao.TemasDAO;
import com.udea.proint1.microcurriculo.dto.TbMicSubtemas;
import com.udea.proint1.microcurriculo.ngc.SubtemasNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class SubtemasNGCImpl implements SubtemasNGC {
		
	private static Logger log=Logger.getLogger(SubtemasNGCImpl.class);
		
	SubtemasDAO subtemasDao;
	TemasDAO temasDao;
		
	public void setsubtemasDao(SubtemasDAO subtemasDao) {
		this.subtemasDao = subtemasDao;
	}
		
	public void setTemasDao(TemasDAO temasDao) {
		this.temasDao = temasDao;
	}

	@Override
	public TbMicSubtemas obtenerSubtemas(int id) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el dato id no sea vacio
		 */
		if(id == 0){
			throw new ExcepcionesLogica("No se ha ingresado una identificación de subtema, está vacia");
		}
		TbMicSubtemas subtema = null;
		
		try {
			//le pedimos a la clase Dao que nos traiga la ciudad con dicho id
			subtema = subtemasDao.obtenerSubtemas(id);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerSubtema de la clase subtemasDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(subtema == null){
			//si está vacio tira una excepción
			throw new ExcepcionesLogica("No se encontró subtema con el id "+ id);
		}else{
			return subtema;
		}
	}

	@Override
	public void guardarSubtemas(TbMicSubtemas subtema) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(subtema == null){
			throw new ExcepcionesLogica("El objeto subtema está vacio");
		}
		try {
			int id = subtema.getNbIdsubtema();
			TbMicSubtemas subtemaConsulta = subtemasDao.obtenerSubtemas(id);
		
			if(subtemaConsulta != null){
				throw new ExcepcionesLogica("El subtemaConsulta a insertar ya existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerSubtema de la clase subtemasDao: "+ e);
		}
		
		try {
			
			subtemasDao.guardarSubtema(subtema);
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo guardarSubtema de la clase subtemasDao: "+ e);
		}
	}

	@Override
	public void actualizarSubtemas(TbMicSubtemas subtema) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(subtema == null){
			throw new ExcepcionesLogica("El objeto subtema está vacio");
		}
		try {
			int id = subtema.getNbIdsubtema();
			TbMicSubtemas subtemaConsulta = subtemasDao.obtenerSubtemas(id);
		
			if(subtemaConsulta == null){
				throw new ExcepcionesLogica("El subtema a actualizar no existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerSubtema de la clase subtemasDao: "+ e);
		}
		
		try {
			
			subtemasDao.modificarSubtema(subtema);
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo actualizarSubtema de la clase subtemasDao: "+ e);
		}
	}

	@Override
	public List<TbMicSubtemas> listarSubtemas() throws ExcepcionesLogica {
		List<TbMicSubtemas> listaSubtemas = null;
		try {
			listaSubtemas = subtemasDao.listarSubtemas();
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo listarSubtemas de la clase subtemasDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(listaSubtemas == null){
			throw new ExcepcionesLogica("No se encontraron subtemas en la tabla TbMicSubtemas");
		}else{
			return listaSubtemas;
		}
	}

	@Override
	public int contarRegistros() throws ExcepcionesLogica {
		int registro = 0;
		
		try {
			registro = subtemasDao.contarRegistros();
		} catch (ExcepcionesDAO e) {
			throw new ExcepcionesLogica("Se presentaron errores al intentar obtener el numero de Registros de la tabla Subtemas.");
		}
		
		return registro;
	}
	
	

}
