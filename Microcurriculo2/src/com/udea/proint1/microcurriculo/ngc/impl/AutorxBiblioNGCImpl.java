package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.udea.proint1.microcurriculo.dao.AutorxBiblioDAO;
import com.udea.proint1.microcurriculo.dto.TbMicAutorxbiblio;
import com.udea.proint1.microcurriculo.ngc.AutorxBiblioNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class AutorxBiblioNGCImpl implements AutorxBiblioNGC {

	private static Logger log=Logger.getLogger(AutorxBiblioNGCImpl.class);
	
	AutorxBiblioDAO autorxBiblioDao;
	
	public void setAutorxBiblioDao(AutorxBiblioDAO autorxBiblioDao) {
		this.autorxBiblioDao = autorxBiblioDao;
	}

	@Override
	public TbMicAutorxbiblio obtenerAutorxbiblio(int id)
			throws ExcepcionesLogica {
		/*
		 * Comprobamos que el dato id no sea vacio
		 */
		if(id == 0){
			throw new ExcepcionesLogica("No se ha ingresado una identificación de autorxBiblio, está vacia");
		}
		TbMicAutorxbiblio autorxBiblio = null;
		
		try {
			//le pedimos a la clase Dao que nos traiga la ciudad con dicho id
			autorxBiblio = autorxBiblioDao.obtenerAutorxBibliografia(id);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerAutorxBibliografia de la clase autorxBiblioDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(autorxBiblio == null){
			//si está vacio tira una excepción
			throw new ExcepcionesLogica("No se encontró autorxBiblio con el id "+ id);
		}else{
			return autorxBiblio;
		}
	}

	@Override
	public void guardarAutorxbiblio(TbMicAutorxbiblio autorxBiblio)
			throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(autorxBiblio == null){
			throw new ExcepcionesLogica("El objeto autorxBiblio está vacio");
		}
		try {
			int id = autorxBiblio.getNbId();
			TbMicAutorxbiblio autorxBiblioConsulta = autorxBiblioDao.obtenerAutorxBibliografia(id);
		
			if(autorxBiblioConsulta != null){
				throw new ExcepcionesLogica("El autorxBiblio a insertar ya existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerAutorxBibliografia de la clase autorxBiblioDao: "+ e);
		}
		
		try {
			
			autorxBiblioDao.guardarAutorxBibliografia(autorxBiblio);
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo guardarAutorxBibliografia de la clase autorxBiblioDao: "+ e);
		}
	}

	@Override
	public void actualizarAutorxbiblio(TbMicAutorxbiblio autorxBiblio)
			throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(autorxBiblio == null){
			throw new ExcepcionesLogica("El objeto autorxBiblio está vacio");
		}
		try {
			int id = autorxBiblio.getNbId();
			TbMicAutorxbiblio autorxBiblioConsulta = autorxBiblioDao.obtenerAutorxBibliografia(id);
		
			if(autorxBiblioConsulta == null){
				throw new ExcepcionesLogica("El autorxBiblio a actualizar no existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerAutorxBibliografia de la clase autorxBiblioDao: "+ e);
		}
		
		try {
			
			autorxBiblioDao.actualizarAutorxBibliografia(autorxBiblio);
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo actualizarAutorxBibliografia de la clase autorxBiblioDao: "+ e);
		}
	}

	@Override
	public List<TbMicAutorxbiblio> listarAutorxbiblio()
			throws ExcepcionesLogica {
		List<TbMicAutorxbiblio> listaAutorxbiblio = null;
		try {
			listaAutorxbiblio = autorxBiblioDao.listarAutorxBibliografia();
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo listarAutorxBibliografia de la clase autorxBiblioDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(listaAutorxbiblio == null){
			throw new ExcepcionesLogica("No se encontraron Autores x biblio en la tabla TbMicAutorxbiblio");
		}else{
			return listaAutorxbiblio;
		}
	}

}
