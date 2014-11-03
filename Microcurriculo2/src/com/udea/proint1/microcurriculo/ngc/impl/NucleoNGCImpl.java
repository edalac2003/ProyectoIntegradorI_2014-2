package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.udea.proint1.microcurriculo.dao.DependenciasDAO;
import com.udea.proint1.microcurriculo.dao.NucleoDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmDependencia;
import com.udea.proint1.microcurriculo.dto.TbAdmDocentesxnucleo;
import com.udea.proint1.microcurriculo.dto.TbAdmNucleo;
import com.udea.proint1.microcurriculo.ngc.NucleoNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class NucleoNGCImpl implements NucleoNGC {
	
	private static Logger log=Logger.getLogger(NucleoNGCImpl.class);
	
	NucleoDAO nucleoDao;
	DependenciasDAO dependenciasDAO;

	public void setNucleoDao(NucleoDAO nucleoDao) {
		this.nucleoDao = nucleoDao;
	}

	public void setDependenciasDAO(DependenciasDAO dependenciasDAO) {
		this.dependenciasDAO = dependenciasDAO;
	}

	public NucleoNGCImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void guardarNucleo(TbAdmNucleo nucleo) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(nucleo == null){
			throw new ExcepcionesLogica("El objeto nucleo está vacio");
		}
		try {
			String id = nucleo.getVrIdnucleo();
			TbAdmNucleo nucleoConsulta = nucleoDao.obtenerNucleo(id);
		
			if(nucleoConsulta != null){
				throw new ExcepcionesLogica("El nucleo a insertar ya existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerNucleo de la clase nucleoDao: "+ e);
		}
		
		try {
			
			nucleoDao.guardarNucleo(nucleo);
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo guardarNucleo de la clase nucleoDao: "+ e);
		}
	}

	@Override
	public void actualizarNucleo(TbAdmNucleo nucleo) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(nucleo == null){
			throw new ExcepcionesLogica("El objeto nucleo está vacio");
		}
		try {
			String id = nucleo.getVrIdnucleo();
			TbAdmNucleo nucleoConsulta = nucleoDao.obtenerNucleo(id);
		
			if(nucleoConsulta == null){
				throw new ExcepcionesLogica("El nucleo a actualizar no existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerNucleo de la clase nucleoDao: "+ e);
		}
		
		try {
			
			nucleoDao.actualizarNucleo(nucleo);
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerNucleo de la clase nucleoDao: "+ e);
		}
	}

	@Override
	public TbAdmNucleo obtenerNucleo(String id) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el dato id no sea vacio
		 */
		if((id.equals(""))||(id.equals(null))){
			throw new ExcepcionesLogica("No se ha ingresado una identificación de nucleo, está vacia");
		}
		TbAdmNucleo nucleo = null;
		
		try {
			nucleo = nucleoDao.obtenerNucleo(id);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerNucleo de la clase nucleoDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(nucleo == null){
			//si está vacio tira una excepción
			throw new ExcepcionesLogica("No se encontró nucleo con el id "+ id);
		}else{
			return nucleo;
		}
	}

	@Override
	public List<TbAdmNucleo> listarNucleos() throws ExcepcionesLogica {
		List<TbAdmNucleo> listaNucleos = null;
		try {
			listaNucleos = nucleoDao.listarNucleos();
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo listarNucleos de la clase nucleoDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(listaNucleos == null){
			throw new ExcepcionesLogica("No se encontraron dependencias en la tabla TbAdmDependencia");
		}else{
			return listaNucleos;
		}
	}

}
