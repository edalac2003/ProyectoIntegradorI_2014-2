package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.udea.proint1.microcurriculo.dao.CiudadesDAO;
import com.udea.proint1.microcurriculo.dao.PersonaDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmPersona;
import com.udea.proint1.microcurriculo.ngc.PersonaNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class PersonaNGCImpl implements PersonaNGC {
	
	private static Logger log=Logger.getLogger(PersonaNGCImpl.class);
	
	PersonaDAO personaDao;
	//TipoPersonaDAO tipoPersonaDao;
	CiudadesDAO ciudadesDao;
	//TipoIdentificacionDAO tipoIdentificacionDao;

	public void setPersonaDao(PersonaDAO personaDao) {
		this.personaDao = personaDao;
	}

	/*public void setTipoPersonaDao(TipoPersonaDAO tipoPersonaDao) {
		this.tipoPersonaDao = tipoPersonaDao;
	}*/

	public void setCiudadesDao(CiudadesDAO ciudadesDao) {
		this.ciudadesDao = ciudadesDao;
	}

	/*public void setTipoIdentificacionDao(TipoIdentificacionDAO tipoIdentificacionDao) {
		this.tipoIdentificacionDao = tipoIdentificacionDao;
	}*/

	public PersonaNGCImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void guardarPersona(TbAdmPersona persona) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(persona == null){
			throw new ExcepcionesLogica("El objeto persona está vacio");
		}
		try {
			String id = persona.getVrIdpersona();
			TbAdmPersona personaConsulta = personaDao.obtenerPersona(id);
		
			if(personaConsulta != null){
				throw new ExcepcionesLogica("La persona a insertar ya existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerPersona de la clase personaDao: "+ e);
		}
		
		try {
			
			personaDao.guardarPersona(persona);
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo guardarPersona de la clase personaDao: "+ e);
		}
	}

	@Override
	public void actualizarPersona(TbAdmPersona persona) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(persona == null){
			throw new ExcepcionesLogica("El objeto persona está vacio");
		}
		try {
			String id = persona.getVrIdpersona();
			TbAdmPersona personaConsulta = personaDao.obtenerPersona(id);
		
			if(personaConsulta == null){
				throw new ExcepcionesLogica("La persona a actualizar no existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerPersona de la clase personaDao: "+ e);
		}
		
		try {
			
			personaDao.modificarPersona(persona);
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo actualizarPersona de la clase personaDao: "+ e);
		}
	}

	@Override
	public TbAdmPersona obtenerPersona(String id) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el dato id no sea vacio
		 */
		if((id.equals(""))||(id.equals(null))){
			throw new ExcepcionesLogica("No se ha ingresado una identificación de persona,está vacia");
		}
		TbAdmPersona persona = null;
		
		try {
			persona = personaDao.obtenerPersona(id);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerPersona de la clase personaDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(persona == null){
			//si está vacio tira una excepción
			throw new ExcepcionesLogica("No se encontró persona con el id "+ id);
		}else{
			return persona;
		}
	}

	@Override
	public List<TbAdmPersona> listarPersonas() throws ExcepcionesLogica {
		List<TbAdmPersona> listaPersonas = null;
		try {
			listaPersonas = personaDao.listarPersonas();
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo listarPersonas de la clase personaDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(listaPersonas == null){
			throw new ExcepcionesLogica("No se encontraron personas en la tabla personaDao");
		}else{
			return listaPersonas;
		}
	}

}
