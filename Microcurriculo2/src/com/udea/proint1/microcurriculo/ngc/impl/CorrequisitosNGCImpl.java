package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.udea.proint1.microcurriculo.dao.CorrequisitosDAO;
import com.udea.proint1.microcurriculo.dao.MateriasDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmCorrequisitos;
import com.udea.proint1.microcurriculo.dto.TbAdmMaterias;
import com.udea.proint1.microcurriculo.dto.TbAdmPrerrequisitos;
import com.udea.proint1.microcurriculo.ngc.CorrequisitosNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class CorrequisitosNGCImpl implements CorrequisitosNGC {
	
	private static Logger log=Logger.getLogger(CorrequisitosNGCImpl.class);	

	CorrequisitosDAO correquisitosDao;
	MateriasDAO materiasDao;
	
	public void setCorrequisitosDao(CorrequisitosDAO correquisitosDao) {
		this.correquisitosDao = correquisitosDao;
	}

	public void setMateriasDao(MateriasDAO materiasDao) {
		this.materiasDao = materiasDao;
	}

	public CorrequisitosNGCImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void guardarCorrequisito(TbAdmCorrequisitos correquisito) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(correquisito == null){
			throw new ExcepcionesLogica("El objeto correquisito está vacio");
		}
		try {
			int id = correquisito.getNbId();
			TbAdmCorrequisitos correquisitoConsulta = correquisitosDao.obtenerCorrequisitos(id);
		
			if(correquisitoConsulta != null){
				throw new ExcepcionesLogica("La prerrequisito a insertar ya existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerCorrequisitos de la clase correquisitosDao: "+ e);
		}
		
		try {
			
			correquisitosDao.guardarCorrequisito(correquisito);
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo guardarCorrequisito de la clase correquisitosDao: "+ e);
		}
	}

	@Override
	public void actualizarCorrequisito(TbAdmCorrequisitos correquisito) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(correquisito == null){
			throw new ExcepcionesLogica("El objeto correquisito está vacio");
		}
		try {
			int id = correquisito.getNbId();
			TbAdmCorrequisitos correquisitoConsulta = correquisitosDao.obtenerCorrequisitos(id);
		
			if(correquisitoConsulta == null){
				throw new ExcepcionesLogica("El correquisito a actualizar no existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerCorrequisito de la clase correquisitosDao: "+ e);
		}
		
		try {
			
			correquisitosDao.actualizarCorrequisito(correquisito);
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo actualizarPrerrequisito de la clase prerrequisitosDao: "+ e);
		}
	}

	@Override
	public List<TbAdmCorrequisitos> listarCorrequisitos() throws ExcepcionesLogica {
		List<TbAdmCorrequisitos> listaCorrequisitos = null;
		try {
			listaCorrequisitos = correquisitosDao.listarCorrequisitos();
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo listarCorrequisitos de la clase correquisitosDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(listaCorrequisitos == null){
			throw new ExcepcionesLogica("No se encontraron Correquisitos en la tabla TbAdmCorrequisitos");
		}else{
			return listaCorrequisitos;
		}
	}

	@Override
	public TbAdmCorrequisitos obtenerCorrequisito(int id) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el dato id no sea vacio
		 */
		if(id == 0){
			throw new ExcepcionesLogica("No se ha ingresado una identificación de correquisito, está vacia");
		}
		TbAdmCorrequisitos correquisito = null;
		
		try {
			//le pedimos a la clase Dao que nos traiga la ciudad con dicho id
			correquisito = correquisitosDao.obtenerCorrequisitos(id);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerCorrequisitos de la clase correquisitosDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(correquisito == null){
			//si está vacio tira una excepción
			throw new ExcepcionesLogica("No se encontró correquisito con el id "+ id);
		}else{
			//si no esta vacio retorna la ciudad
			return correquisito;
		}
	}
	
	@Override
	public List<TbAdmCorrequisitos> listarCorrequisitosxMateria(String id) throws ExcepcionesLogica{
		
		List<TbAdmCorrequisitos> listaCorrequisitos = null;
		
		TbAdmMaterias materia= null;
		
		try {
			materia = materiasDao.obtenerMateria(id);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerMateria de la clase materiasDao: "+ e);
		}
		
		if(materia == null){
			throw new ExcepcionesLogica("NO existe materia a consultar"); 
		}
		
		try {
			listaCorrequisitos = correquisitosDao.listarCorrequisitosxMateria(materia);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo listarCorrequisitosxmateria de la clase correquisitosDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		return listaCorrequisitos;
	}

}
