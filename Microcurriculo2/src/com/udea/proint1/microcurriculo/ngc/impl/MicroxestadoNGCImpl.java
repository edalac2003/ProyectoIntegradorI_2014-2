package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.udea.proint1.microcurriculo.dao.EstadosDAO;
import com.udea.proint1.microcurriculo.dao.MicroxEstadoDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmPersona;
import com.udea.proint1.microcurriculo.dto.TbAdmTipopersona;
import com.udea.proint1.microcurriculo.dto.TbMicEstados;
import com.udea.proint1.microcurriculo.dto.TbMicMicroxestado;
import com.udea.proint1.microcurriculo.ngc.MicroxestadoNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class MicroxestadoNGCImpl implements MicroxestadoNGC {

	private static Logger log=Logger.getLogger(PersonaNGCImpl.class);
	
	MicroxEstadoDAO microxestadoDao;
	
	EstadosDAO estadosDao;
	
	public void setMicroxestadoDao(MicroxEstadoDAO microxestadoDao) {
		this.microxestadoDao = microxestadoDao;
	}

	public void setEstadosDao(EstadosDAO estadosDao) {
		this.estadosDao = estadosDao;
	}

	@Override
	public void guardarMicroxestado(TbMicMicroxestado microxEstado)
			throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(microxEstado == null){
			throw new ExcepcionesLogica("El objeto microxEstado está vacio");
		}
		try {
			int id = microxEstado.getNbId();
			TbMicMicroxestado microxEstadoConsulta = microxestadoDao.obtenerMicroxestado(id);
		
			if(microxEstadoConsulta != null){
				throw new ExcepcionesLogica("El Micro x Estado a insertar ya existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerMicroxestado de la clase microxestadoDao: "+ e);
		}
		
		try {
			
			microxestadoDao.guardarMicroxestado(microxEstado);;
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo guardarMicroxestado de la clase microxestadoDao: "+ e);
		}
	}

	@Override
	public void actualizarMicroxestado(TbMicMicroxestado microxEstado)
			throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(microxEstado == null){
			throw new ExcepcionesLogica("El objeto microxEstado está vacio");
		}
		try {
			int id = microxEstado.getNbId();
			TbMicMicroxestado microxEstadoConsulta = microxestadoDao.obtenerMicroxestado(id);
		
			if(microxEstadoConsulta == null){
				throw new ExcepcionesLogica("El micro x estado a actualizar no existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerMicroxestado de la clase microxestadoDao: "+ e);
		}
		
		try {
			
			microxestadoDao.actualizarMicroxestado(microxEstado);;
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo actualizarMicroxestado de la clase microxestadoDao: "+ e);
		}
	}

	@Override
	public TbMicMicroxestado obtenerMicroxestado(int id)
			throws ExcepcionesLogica {
		/*
		 * Comprobamos que el dato id no sea vacio
		 */
		if(id == 0){
			throw new ExcepcionesLogica("No se ha ingresado una identificación de microxEstado, está vacia");
		}
		TbMicMicroxestado microxEstado = null;
		
		try {
			microxEstado = microxestadoDao.obtenerMicroxestado(id);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerMicroxestado de la clase microxestadoDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(microxEstado == null){
			//si está vacio tira una excepción
			throw new ExcepcionesLogica("No se encontró microxEstado con el id "+ id);
		}else{
			return microxEstado;
		}
	}

	@Override
	public List<TbMicMicroxestado> listarMicroxestado()
			throws ExcepcionesLogica {
		List<TbMicMicroxestado> listaMicrosxestado = null;
		try {
			listaMicrosxestado = microxestadoDao.listarMicroxestado();
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo listarMicroxestado de la clase microxestadoDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(listaMicrosxestado == null){
			throw new ExcepcionesLogica("No se encontraron Micros x Estado en la tabla TbMicMicroxestado");
		}else{
			return listaMicrosxestado;
		}
	}

	@Override
	public List<TbMicMicroxestado> listarMicrosxestado(int idEstado)
			throws ExcepcionesLogica {
		List<TbMicMicroxestado> listaMicrosxestado = null;
		
		TbMicEstados estado = null;
		
		try {
			estado = estadosDao.obtenerEstado(idEstado);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerEstado de la clase estadosDao: "+ e);
		}
		
		try {
			listaMicrosxestado = microxestadoDao.listarMicrosxestado(estado);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo listarMicrosxestado de la clase microxestadoDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(listaMicrosxestado == null){
			throw new ExcepcionesLogica("No se encontraron Micros x estado de tipo estado en la tabla TbMicMicroxestado");
		}else{
			return listaMicrosxestado;
		}
	}

}
