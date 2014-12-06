package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.udea.proint1.microcurriculo.dao.AutorDao;
import com.udea.proint1.microcurriculo.dto.TbMicAutor;
import com.udea.proint1.microcurriculo.ngc.AutorNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class AutorNGCImpl implements AutorNGC {
	
	private static Logger log=Logger.getLogger(AutorNGCImpl.class);
	
	AutorDao autorDao;	

	public void setAutorDao(AutorDao autorDao) {
		this.autorDao = autorDao;
	}

	public AutorNGCImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public TbMicAutor obtenerAutor(int id) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el dato id no sea vacio
		 */
		if(id == 0){
			throw new ExcepcionesLogica("No se ha ingresado una identificación de autor, está vacia");
		}
		TbMicAutor autor = null;
		
		try {
			//le pedimos a la clase Dao que nos traiga la ciudad con dicho id
			autor = autorDao.obtenerAutores(id);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerAutor de la clase autorDao: "+ e);
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
	public void guardarAutores(TbMicAutor autor) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(autor == null){
			throw new ExcepcionesLogica("El objeto autor está vacio");
		}
		try {
			int id = autor.getNbIdautor();
			TbMicAutor autorConsulta = autorDao.obtenerAutores(id);
		
			if(autorConsulta != null){
				throw new ExcepcionesLogica("El autor a insertar ya existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerAutor de la clase autorDao: "+ e);
		}
		
		try {
			
			autorDao.guardarAutores(autor);
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo guardarAutor de la clase autorDao: "+ e);
		}
	}

	@Override
	public void actualizarAutores(TbMicAutor autor) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(autor == null){
			throw new ExcepcionesLogica("El objeto autor está vacio");
		}
		try {
			int id = autor.getNbIdautor();
			TbMicAutor autorConsulta = autorDao.obtenerAutores(id);
		
			if(autorConsulta == null){
				throw new ExcepcionesLogica("El autor a actualizar no existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerAutores de la clase autorDao: "+ e);
		}
		
		try {
			
			autorDao.actualizarAutores(autor);
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo actualizarAutor de la clase autorDao: "+ e);
		}
	}

	@Override
	public List<TbMicAutor> listarAutores() throws ExcepcionesLogica {
		List<TbMicAutor> listaAutores = null;
		try {
			listaAutores = autorDao.listarAutores();
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo listarAutores de la clase autorDao: "+ e);
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
