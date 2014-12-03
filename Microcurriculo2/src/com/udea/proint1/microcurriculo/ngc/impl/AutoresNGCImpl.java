package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.udea.proint1.microcurriculo.dao.AutoresDao;
import com.udea.proint1.microcurriculo.dto.TbMicAutores;
import com.udea.proint1.microcurriculo.ngc.AutoresNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class AutoresNGCImpl implements AutoresNGC {
	
	private static Logger log=Logger.getLogger(AutoresNGCImpl.class);
	
	AutoresDao autoresDao;	

	public void setAutoresDao(AutoresDao autoresDao) {
		this.autoresDao = autoresDao;
	}

	public AutoresNGCImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public TbMicAutores obtenerAutor(int id) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el dato id no sea vacio
		 */
		if(id == 0){
			throw new ExcepcionesLogica("No se ha ingresado una identificación de autor, está vacia");
		}
		TbMicAutores autor = null;
		
		try {
			//le pedimos a la clase Dao que nos traiga la ciudad con dicho id
			autor = autoresDao.obtenerAutores(id);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerAutor de la clase autoresDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(autor == null){
			//si está vacio tira una excepción
			throw new ExcepcionesLogica("No se encontró autor con el id "+ id);
		}else{
			return autor;
		}
	}

	@Override
	public void guardarAutores(TbMicAutores autor) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(autor == null){
			throw new ExcepcionesLogica("El objeto autor está vacio");
		}
		try {
			int id = autor.getNbIdautor();
			TbMicAutores autorConsulta = autoresDao.obtenerAutores(id);
		
			if(autorConsulta != null){
				throw new ExcepcionesLogica("El autor a insertar ya existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerAutor de la clase autoresDao: "+ e);
		}
		
		try {
			
			autoresDao.guardarAutores(autor);
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo guardarAutor de la clase autoresDao: "+ e);
		}
	}

	@Override
	public void actualizarAutores(TbMicAutores autor) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(autor == null){
			throw new ExcepcionesLogica("El objeto autor está vacio");
		}
		try {
			int id = autor.getNbIdautor();
			TbMicAutores autorConsulta = autoresDao.obtenerAutores(id);
		
			if(autorConsulta == null){
				throw new ExcepcionesLogica("El autor a actualizar no existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerAutores de la clase autoresDao: "+ e);
		}
		
		try {
			
			autoresDao.actualizarAutores(autor);;
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo actualizarAutor de la clase autoresDao: "+ e);
		}
	}

	@Override
	public List<TbMicAutores> listarAutores() throws ExcepcionesLogica {
		List<TbMicAutores> listaAutores = null;
		try {
			listaAutores = autoresDao.listarAutores();
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo listarAutores de la clase autoresDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(listaAutores == null){
			throw new ExcepcionesLogica("No se encontraron Autores en la tabla TbMicAutores");
		}else{
			return listaAutores;
		}
	}

}
