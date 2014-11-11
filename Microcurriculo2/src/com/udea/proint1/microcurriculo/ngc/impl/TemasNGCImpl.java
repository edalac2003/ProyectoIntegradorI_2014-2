package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.udea.proint1.microcurriculo.dao.TemasDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmPrerrequisitos;
import com.udea.proint1.microcurriculo.dto.TbMicTemas;
import com.udea.proint1.microcurriculo.ngc.TemasNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;
	
public class TemasNGCImpl implements TemasNGC {
		
	private static Logger log=Logger.getLogger(TemasNGCImpl.class);
		
	TemasDAO temasDao;

	public void setTemasDao(TemasDAO temasDao) {
		this.temasDao = temasDao;
	}

	@Override
	public TbMicTemas obtenerTemas(int id) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el dato id no sea vacio
		 */
		if(id == 0){
			throw new ExcepcionesLogica("No se ha ingresado una identificación de Tema, está vacia");
		}
		TbMicTemas tema = null;
		
		try {
			//le pedimos a la clase Dao que nos traiga la ciudad con dicho id
			tema = temasDao.obtenerTema(id);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerTema de la clase temasDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(tema == null){
			//si está vacio tira una excepción
			throw new ExcepcionesLogica("No se encontró tema con el id "+ id);
		}else{
			//si no esta vacio retorna la ciudad
			return tema;
		}
	}

	@Override
	public void guardarTemas(TbMicTemas tema) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(tema == null){
			throw new ExcepcionesLogica("El objeto prerrequisito está vacio");
		}
		try {
			int id = tema.getNbIdtema();
			TbMicTemas temasConsulta = temasDao.obtenerTema(id);
		
			if(temasConsulta != null){
				throw new ExcepcionesLogica("El tema a insertar ya existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerTema de la clase temasDao: "+ e);
		}
		
		try {
			
			temasDao.guardarTema(tema);
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo guardarTema de la clase temasDao: "+ e);
		}
	}

	@Override
	public void actualizarTema(TbMicTemas tema) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(tema == null){
			throw new ExcepcionesLogica("El objeto tema está vacio");
		}
		try {
			int id = tema.getNbIdtema();
			TbMicTemas temaConsulta = temasDao.obtenerTema(id);
		
			if(temaConsulta == null){
				throw new ExcepcionesLogica("El tema a actualizar no existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerTema de la clase temasDao: "+ e);
		}
		
		try {
			
			temasDao.modificarTema(tema);
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo modificarTema de la clase temasDao: "+ e);
		}
	}

	@Override
	public List<TbMicTemas> listarTemas() throws ExcepcionesLogica {
		List<TbMicTemas> listaTemas = null;
		try {
			listaTemas = temasDao.listarTemas();
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo listarTemas de la clase temasDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(listaTemas == null){
			throw new ExcepcionesLogica("No se encontraron temas en la tabla TbMicTemas");
		}else{
			return listaTemas;
		}
	}

	@Override
	public int contarRegistros() throws ExcepcionesLogica {
		int registro = 0;
		
		try {
			registro = temasDao.contarRegistros();
		} catch (ExcepcionesDAO e) {
			throw new ExcepcionesLogica("NGC : Se produjo un Error al intentar Contar los Registros de Temas.");
		}
		
		return registro;
	}
	
	

}
