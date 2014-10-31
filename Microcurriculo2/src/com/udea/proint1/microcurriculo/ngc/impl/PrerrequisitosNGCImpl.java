package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.udea.proint1.microcurriculo.dto.TbAdmDependencia;
import com.udea.proint1.microcurriculo.dto.TbAdmPrerrequisitos;
import com.udea.proint1.microcurriculo.ngc.PrerrequisitosNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class PrerrequisitosNGCImpl implements PrerrequisitosNGC {

	private static Logger log=Logger.getLogger(PrerrequisitosNGCImpl.class);	
	
	PrerrequisitoDAO prerrequisitosDao;
	MateriasDAO materiasDao;
	
	public void setPrerrequisitosDao(PrerrequisitoDAO prerrequisitosDao) {
		this.prerrequisitosDao = prerrequisitosDao;
	}

	public void setMateriasDao(MateriasDAO materiasDao) {
		this.materiasDao = materiasDao;
	}

	public PrerrequisitosNGCImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void guardarPrerrequisito(TbAdmPrerrequisitos prerrequisito) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(prerrequisito == null){
			throw new ExcepcionesLogica("El objeto prerrequisito está vacio");
		}
		try {
			int id = prerrequisito.getNbId();
			TbAdmPrerrequisitos prerrequisitoConsulta = prerrequisitosDao.obtenerPrerrequisito(id);
		
			if(prerrequisitoConsulta != null){
				throw new ExcepcionesLogica("La prerrequisito a insertar ya existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerPrerrequisito de la clase prerrequisitosDao: "+ e);
		}
		
		try {
			
			prerrequisitosDao.guardarPrerrequisito(prerrequisito);
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo guardarPrerrequisito de la clase prerrequisitosDao: "+ e);
		}
	}

	@Override
	public void actualizarPrerrequisito(TbAdmPrerrequisitos prerrequisito) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(prerrequisito == null){
			throw new ExcepcionesLogica("El objeto prerrequisito está vacio");
		}
		try {
			int id = prerrequisito.getNbId();
			TbAdmPrerrequisitos prerrequisitoConsulta = prerrequisitosDao.obtenerPrerrequisito(id);
		
			if(prerrequisitoConsulta == null){
				throw new ExcepcionesLogica("El prerrequisito a actualizar no existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerPrerrequisito de la clase prerrequisitosDao: "+ e);
		}
		
		try {
			
			prerrequisitosDao.actualizarPrerrequisito(prerrequisito);
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo actualizarPrerrequisito de la clase prerrequisitosDao: "+ e);
		}
	}

	@Override
	public List<TbAdmPrerrequisitos> listarPrerrequisitos() throws ExcepcionesLogica {
		List<TbAdmPrerrequisitos> listaPrerrequisitos = null;
		try {
			listaPrerrequisitos = prerrequisitosDao.listarPrerrequisitos();
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo listarPrerrequisitos de la clase prerrequisitosDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(listaPrerrequisitos == null){
			throw new ExcepcionesLogica("No se encontraron prerrequisitos en la tabla TbAdmPrerrequisitos");
		}else{
			return listaPrerrequisitos;
		}
	}

	@Override
	public TbAdmPrerrequisitos obtenerPrerrequisito(int id) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el dato id no sea vacio
		 */
		if(id == 0){
			throw new ExcepcionesLogica("No se ha ingresado una identificación de prerrequisito, está vacia");
		}
		TbAdmPrerrequisitos prerrequisito = null;
		
		try {
			//le pedimos a la clase Dao que nos traiga la ciudad con dicho id
			prerrequisito = prerrequisitosDao.obtenerPrerrequisito(id);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerPrerrequisito de la clase prerrequisitosDao: "+ e);
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

}
