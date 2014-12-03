package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.UnidadesDAO;
import com.udea.proint1.microcurriculo.dto.TbMicBiblioxunidad;
import com.udea.proint1.microcurriculo.dto.TbMicUnidades;
import com.udea.proint1.microcurriculo.ngc.UnidadesNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class UnidadesNGCImpl  implements UnidadesNGC {
	
private static Logger log = Logger.getLogger(UnidadesNGCImpl.class);
	
	UnidadesDAO unidadesDao;
	
	public void setunidadesDao(UnidadesDAO unidadesDao) {
		this.unidadesDao = unidadesDao;
	}

	
	@Override
	public void guardarUnidades(TbMicUnidades unidad) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no est� vacio
		 */
		if(unidad == null){
			throw new ExcepcionesLogica("El objeto unidad est� vacio");
		}
		try {
			int id = unidad.getNbIdunidad();
			TbMicUnidades unidadConsulta = unidadesDao.obtenerUnidad(id);
		
			if(unidadConsulta != null){
				throw new ExcepcionesLogica("La Unidad a insertar ya existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("fall� al invocar el metodo obtenerUnidad de la clase unidadesDao: "+ e);
		}
		
		try {
			
			unidadesDao.guardarUnidad(unidad);
		
		} catch (ExcepcionesDAO e) {
			log.error("fall� al invocar el metodo guardarUnidad de la clase unidadesDao: "+ e);
		}
	}

	@Override
	public TbMicUnidades obtenerUnidades(int idUnidad) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el dato id no sea vacio
		 */
		if(idUnidad == 0){
			throw new ExcepcionesLogica("No se ha ingresado una identificación de unidad, está vacia");
		}
		TbMicUnidades unidad = null;
		
		try {
			//le pedimos a la clase Dao que nos traiga la ciudad con dicho id
			unidad = unidadesDao.obtenerUnidad(idUnidad);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerUnidad de la clase unidadesDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(unidad == null){
			//si está vacio tira una excepción
			throw new ExcepcionesLogica("No se encontró Unidad con el id "+ idUnidad);
		}else{
			//si no esta vacio retorna la ciudad
			return unidad;
		}
	}

	@Override
	public void actualizarUnidades(TbMicUnidades unidad) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(unidad == null){
			throw new ExcepcionesLogica("El objeto unidad está vacio");
		}
		try {
			int id = unidad.getNbIdunidad();
			TbMicUnidades unidadConsulta = unidadesDao.obtenerUnidad(id);
		
			if(unidadConsulta == null){
				throw new ExcepcionesLogica("La Unidad a actualizar no existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerUnidad de la clase unidadesDao: "+ e);
		}
		
		try {
			
			unidadesDao.modificarUnidad(unidad);
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo modificarUnidad de la clase unidadesDao: "+ e);
		}
	}

	@Override
	public List<TbMicUnidades> listarUnidades() throws ExcepcionesLogica {
		List<TbMicUnidades> listaUnidades = null;
		try {
			listaUnidades = unidadesDao.listarUnidades();
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo listarUnidades de la clase unidadesDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(listaUnidades == null){
			throw new ExcepcionesLogica("No se encontraron unidades en la tabla TbMicUnidades");
		}else{
			return listaUnidades;
		}
	}

	@Override
	public int numeroRegistros() throws ExcepcionesLogica {
		int registro = 0;
		try {
			registro = unidadesDao.numeroRegistros();
		} catch (ExcepcionesDAO e) {
			throw new ExcepcionesLogica("Se produjo un Error al Contar los Registros de la Tabla Unidades.");
		}
		
		return registro;
	}
	
	

}
