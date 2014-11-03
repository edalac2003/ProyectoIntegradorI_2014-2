package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.udea.proint1.microcurriculo.dao.CiudadesDAO;
import com.udea.proint1.microcurriculo.dao.TemasDAO;
import com.udea.proint1.microcurriculo.dao.UnidadesDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmPrerrequisitos;
import com.udea.proint1.microcurriculo.dto.TbMicTemasxunidad;
import com.udea.proint1.microcurriculo.ngc.TemasxUnidadNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class TemasxUnidadNGCImpl implements TemasxUnidadNGC {
	
	private static Logger log=Logger.getLogger(TemasxUnidadNGCImpl.class);
	
	TemasxUnidadDAO temasxunidadDao;
	
	UnidadesDAO unidadesDao;
	
	TemasDAO temasDao;

	public void setTemasxUnidadDao(TemasxUnidadDAO temasxUnidadDao) {
		this.temasxunidadDao = temasxUnidadDao;
	}

	public void setUnidadesDao(UnidadesDAO unidadesDao) {
		this.unidadesDao = unidadesDao;
	}

	public void setTemasDao(TemasDAO temasDao) {
		this.temasDao = temasDao;
	}

	@Override
	public TbMicTemasxunidad obtenerTemasxUnidad(int id)throws ExcepcionesLogica {
		/*
		 * Comprobamos que el dato id no sea vacio
		 */
		if(id == 0){
			throw new ExcepcionesLogica("No se ha ingresado una id de temasxunidad, está vacia");
		}
		TbMicTemasxunidad temasxunidad = null;
		
		try {
			//le pedimos a la clase Dao que nos traiga la ciudad con dicho id
			temasxunidad = temasxunidadDao.obtenerTemasxunidad(id);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerTemasxunidad de la clase temasxunidadDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(prerrequisito == null){
			//si está vacio tira una excepción
			throw new ExcepcionesLogica("No se encontró prerrequisito con el id "+ id);
		}else{
			//si no esta vacio retorna la ciudad
			return prerrequisito;
		}
	}

	@Override
	public void guardarTemasxUnidad(TbMicTemasxunidad temasxunidad) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(temasxunidad == null){
			throw new ExcepcionesLogica("El objeto temasxunidad está vacio");
		}
		try {
			int id = temasxunidad.getNbId();
			TbMicTemasxunidad temasxunidadConsulta = temasxunidadDao.obtenerTemasxunidad(id);
		
			if(temasxunidadConsulta != null){
				throw new ExcepcionesLogica("El temasxunidad a insertar ya existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerPrerrequisito de la clase prerrequisitosDao: "+ e);
		}
		
		try {
			
			prerrequisitosDao.guardarPrerrequisito(prerrequisito);
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerTemasxunidad de la clase temasxunidadDao: "+ e);
		}
	}

	@Override
	public void actualizarTemaxUnidad(TbMicTemasxunidad temasxunidad) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(temasxunidad == null){
			throw new ExcepcionesLogica("El objeto temasxunidad está vacio");
		}
		try {
			int id = temasxunidad.getNbId();
			TbAdmPrerrequisitos temasxunidadConsulta = temasxunidadDao.obtenerTemasxunidad(id);
		
			if(temasxunidadConsulta == null){
				throw new ExcepcionesLogica("El prerrequisito a actualizar no existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerTemasxunidad de la clase temasxunidadDao: "+ e);
		}
		
		try {
			
			temasxunidadDao.actualizarTemasxunidad(temasxunidad);
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo actualizarTemasxunidad de la clase temasxunidadDao: "+ e);
		}
	}

	@Override
	public List<TbMicTemasxunidad> listarTemasxUnidad() throws ExcepcionesLogica {
		List<TbMicTemasxunidad> listaTemasxUnidad = null;
		try {
			listaTemasxUnidad = temasxunidadDao.listarTemasxunidad();
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo listarTemasxunidad de la clase temasxunidadDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(listaTemasxUnidad == null){
			throw new ExcepcionesLogica("No se encontraron listaTemasxUnidad en la tabla TbMicTemasxunidad");
		}else{
			return listaTemasxUnidad;
		}
	}

}
