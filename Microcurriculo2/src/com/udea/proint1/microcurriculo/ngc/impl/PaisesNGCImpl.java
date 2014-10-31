package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.udea.proint1.microcurriculo.dao.PaisesDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmCiudades;
import com.udea.proint1.microcurriculo.dto.TbAdmPaises;
import com.udea.proint1.microcurriculo.ngc.PaisesNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class PaisesNGCImpl implements PaisesNGC {

	private static Logger log = Logger.getLogger(PaisesNGCImpl.class);
	
	PaisesDAO paisesDao;
	
	public void setPaisesDao(PaisesDAO paisesDao) {
		this.paisesDao = paisesDao;
	}

	public PaisesNGCImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<TbAdmPaises> listarPaises() throws ExcepcionesLogica {
		List<TbAdmPaises> listaPaises = null;
		try {
			listaPaises = paisesDao.listarPaises();
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo listarPaises de la clase paisesDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(listaPaises == null){
			//si está vacio tira una excepción
			throw new ExcepcionesLogica("No se encontraron paises en la tabla TbAdmPaises");
		}else{
			return listaPaises;
		}
	}

	@Override
	public TbAdmPaises obtenerPais(int id) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el dato id no sea vacio
		 */
		if(id==0){
			throw new ExcepcionesLogica("No se ha ingresado una identificación de país, está vacia");
		}
		TbAdmPaises pais = null;
		
		try {
			//le pedimos a la clase Dao que nos traiga la ciudad con dicho id
			pais = paisesDao.obtenerPais(id);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerPais de la clase paisesDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(pais == null){
			throw new ExcepcionesLogica("No se encontró pais con el id "+ id);
		}else{
			return pais;
		}
	}

}
