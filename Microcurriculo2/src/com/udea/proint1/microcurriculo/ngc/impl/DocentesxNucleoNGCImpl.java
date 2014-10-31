package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.udea.proint1.microcurriculo.dao.PersonaDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmDependencia;
import com.udea.proint1.microcurriculo.dto.TbAdmDocentesxnucleo;
import com.udea.proint1.microcurriculo.ngc.DocentesxNucleoNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class DocentesxNucleoNGCImpl implements DocentesxNucleoNGC {
	
	private static Logger log=Logger.getLogger(DocentesxNucleoNGCImpl.class);
	
	DocentesxNucleoDAO docentesxNucleoDao;
	
	NucleoDAO nucleoDao;
	
	PersonaDAO personaDao;
	
	public void setDocentesxNucleoDao(DocentesxNucleoDAO docentesxNucleoDao) {
		this.docentesxNucleoDao = docentesxNucleoDao;
	}

	public void setNucleoDao(NucleoDAO nucleoDao) {
		this.nucleoDao = nucleoDao;
	}

	public void setPersonaDao(PersonaDAO personaDao) {
		this.personaDao = personaDao;
	}

	public DocentesxNucleoNGCImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void guardarDocentexNucleo(TbAdmDocentesxnucleo docentesxNucleo) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(docentesxNucleo == null){
			throw new ExcepcionesLogica("El objeto docentesxNucleo está vacio");
		}
		try {
			int id = docentesxNucleo.getNbId();
			TbAdmDocentesxnucleo docentesxNucleoConsulta = docentesxNucleoDao.obtenerDocentesxNucleo(id);
		
			if(docentesxNucleoConsulta != null){
				throw new ExcepcionesLogica("El docentesxNucleo a insertar ya existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerDocentesxNucleo de la clase DocentesxNucleoDAO: "+ e);
		}
		
		try {
			
			docentesxNucleoDao.guardarDocentexNucleo(docentesxNucleo);
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo guardarDependencia de la clase dependenciaDao: "+ e);
		}
	}

	@Override
	public void actualizarDocentexNucleo(TbAdmDocentesxnucleo docentesxNucleo) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(docentesxNucleo == null){
			throw new ExcepcionesLogica("El objeto docentesxNucleo está vacio");
		}
		try {
			int id = docentesxNucleo.getNbId();
			TbAdmDocentesxnucleo docentesxNucleoConsulta = docentesxNucleoDao.obtenerDocentesxNucleo(id);
		
			if(docentesxNucleoConsulta == null){
				throw new ExcepcionesLogica("El docentesxNucleo a actualizar no existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerDocentesxNucleo de la clase docentesxNucleoDao: "+ e);
		}
		
		try {
			
			docentesxNucleoDao.actualizarDocentesxNucleo(docentesxNucleo);
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo guardarDependencia de la clase dependenciaDao: "+ e);
		}
	}

	@Override
	public List<TbAdmDocentesxnucleo> listarDocentesxNucleo() throws ExcepcionesLogica {
		List<TbAdmDocentesxnucleo> listaDocentesxNucleo = null;
		try {
			listaDocentesxNucleo = docentesxNucleoDao.listarDocentesxNucleo();
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo listarDocentesxNucleo de la clase docentesxNucleoDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(listaDocentesxNucleo == null){
			throw new ExcepcionesLogica("No se encontraron docentesxNucleo en la tabla TbAdmDocentesxnucleo");
		}else{
			return listaDocentesxNucleo;
		}
	}

	@Override
	public TbAdmDocentesxnucleo obtenerDocentexNucleo(int id) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el dato id no sea vacio
		 */
		if(id == 0){
			throw new ExcepcionesLogica("No se ha ingresado una identificación de ciudad,está vacia");
		}
		TbAdmDocentesxnucleo docentesxNucleo = null;
		
		try {
			//le pedimos a la clase Dao que nos traiga la ciudad con dicho id
			docentesxNucleo = docentesxNucleoDao.obtenerDependencias(id);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerDependencia de la clase dependenciaDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(docentesxNucleo == null){
			//si está vacio tira una excepción
			throw new ExcepcionesLogica("No se encontró dependencia con el id "+ id);
		}else{
			//si no esta vacio retorna la ciudad
			return docentesxNucleo;
		}
	}

}
