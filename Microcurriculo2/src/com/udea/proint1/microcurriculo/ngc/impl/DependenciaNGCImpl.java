package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.udea.proint1.microcurriculo.dao.DependenciasDAO;
import com.udea.proint1.microcurriculo.dao.UnidadesAcademicasDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmCiudades;
import com.udea.proint1.microcurriculo.dto.TbAdmDependencia;
import com.udea.proint1.microcurriculo.ngc.DependenciaNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class DependenciaNGCImpl implements DependenciaNGC {
	
	private static Logger log=Logger.getLogger(DependenciaNGCImpl.class);
	
	DependenciasDAO dependenciaDao;
	
	UnidadesAcademicasDAO unidadAcademicaDao;

	public void setDependenciaDao(DependenciasDAO dependenciaDao) {
		this.dependenciaDao = dependenciaDao;
	}

	public void setUnidadAcademicaDao(UnidadesAcademicasDAO unidadAcademicaDao) {
		this.unidadAcademicaDao = unidadAcademicaDao;
	}

	public DependenciaNGCImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void guardarDependencia(TbAdmDependencia dependencia) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(dependencia == null){
			throw new ExcepcionesLogica("El objeto dependencia está vacio");
		}
		try {
			String id = dependencia.getVrIddependencia();
			TbAdmDependencia dependenciaConsulta = dependenciaDao.obtenerDependencia(id);
		
			if(dependenciaConsulta != null){
				throw new ExcepcionesLogica("La dependencia a insertar ya existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerDependencia de la clase dependenciaDao: "+ e);
		}
		
		try {
			
			dependenciaDao.guardarDependencia(dependencia);
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo guardarDependencia de la clase dependenciaDao: "+ e);
		}
	}

	@Override
	public void actualizarDependencia(TbAdmDependencia dependencia) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(dependencia == null){
			throw new ExcepcionesLogica("El objeto dependencia está vacio");
		}
		try {
			String id = dependencia.getVrIddependencia();
			TbAdmDependencia dependenciaConsulta = dependenciaDao.obtenerDependencia(id);
		
			if(dependenciaConsulta == null){
				throw new ExcepcionesLogica("La dependencia a actualizar no existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerDependencia de la clase dependenciaDao: "+ e);
		}
		
		try {
			
			dependenciaDao.actualizarDependencia(dependencia);
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo guardarDependencia de la clase dependenciaDao: "+ e);
		}
	}

	@Override
	public TbAdmDependencia obtenerDependencia(String id) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el dato id no sea vacio
		 */
		if((id.equals(""))||(id.equals(null))){
			throw new ExcepcionesLogica("No se ha ingresado una identificación de ciudad,está vacia");
		}
		TbAdmDependencia dependencia = null;
		
		try {
			//le pedimos a la clase Dao que nos traiga la ciudad con dicho id
			dependencia = dependenciaDao.obtenerDependencia(id);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerDependencia de la clase dependenciaDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(dependencia == null){
			//si está vacio tira una excepción
			throw new ExcepcionesLogica("No se encontró dependencia con el id "+ id);
		}else{
			//si no esta vacio retorna la ciudad
			return dependencia;
		}
	}

	@Override
	public List<TbAdmDependencia> actualizarDependencia() throws ExcepcionesLogica {
		List<TbAdmDependencia> listaDependencias = null;
		try {
			listaDependencias = dependenciaDao.listarDependencias();
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo listarDependencias de la clase dependenciaDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(listaDependencias == null){
			//si está vacio tira una excepción
			throw new ExcepcionesLogica("No se encontraron dependencias en la tabla TbAdmDependencia");
		}else{
			//si no esta vacio retorna las ciudadades
			return listaDependencias;
		}
	}

}
