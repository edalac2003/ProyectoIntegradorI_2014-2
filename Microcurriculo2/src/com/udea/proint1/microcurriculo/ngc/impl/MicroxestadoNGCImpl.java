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
	public void guardarMicroxestado(TbMicMicroxestado microxEstado) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no est茅 vacio
		 */
		TbMicMicroxestado microxEstadoConsulta = null;
		
		if(microxEstado != null){
			try {
				microxEstadoConsulta = microxestadoDao.obtenerMicroxestado(microxEstado.getNbId());
			} catch (ExcepcionesDAO e1) {
				throw new ExcepcionesLogica();
			}
			
			if(microxEstadoConsulta == null){
				
				try {
					microxestadoDao.guardarMicroxestado(microxEstado);
				} catch (ExcepcionesDAO e) {
					throw new ExcepcionesLogica();
				}
				
			} else {
				throw new ExcepcionesLogica("El Registro que desea guardar ya existe en la Base de Datos.");
			}
		} else {
			throw new ExcepcionesLogica("El registro que desea ingresar no contiene informaci髇 v醠ida.");
		}
	}

	@Override
	public void actualizarMicroxestado(TbMicMicroxestado microxEstado)
			throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no est茅 vacio
		 */
		if(microxEstado == null){
			throw new ExcepcionesLogica("El objeto microxEstado est谩 vacio");
		}
		try {
			int id = microxEstado.getNbId();
			TbMicMicroxestado microxEstadoConsulta = microxestadoDao.obtenerMicroxestado(id);
		
			if(microxEstadoConsulta == null){
				throw new ExcepcionesLogica("El micro x estado a actualizar no existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("fall贸 al invocar el metodo obtenerMicroxestado de la clase microxestadoDao: "+ e);
		}
		
		try {
			
			microxestadoDao.actualizarMicroxestado(microxEstado);;
		
		} catch (ExcepcionesDAO e) {
			log.error("fall贸 al invocar el metodo actualizarMicroxestado de la clase microxestadoDao: "+ e);
		}
	}

	@Override
	public TbMicMicroxestado obtenerMicroxestado(int id)
			throws ExcepcionesLogica {
		/*
		 * Comprobamos que el dato id no sea vacio
		 */
		if(id == 0){
			throw new ExcepcionesLogica("No se ha ingresado una identificaci贸n de microxEstado, est谩 vacia");
		}
		TbMicMicroxestado microxEstado = null;
		
		try {
			microxEstado = microxestadoDao.obtenerMicroxestado(id);
		} catch (ExcepcionesDAO e) {
			log.error("fall贸 al invocar el metodo obtenerMicroxestado de la clase microxestadoDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en 茅l.
		 */
		if(microxEstado == null){
			//si est谩 vacio tira una excepci贸n
			throw new ExcepcionesLogica("No se encontr贸 microxEstado con el id "+ id);
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
			log.error("fall贸 al invocar el metodo listarMicroxestado de la clase microxestadoDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en 茅l.
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
			log.error("fall贸 al invocar el metodo obtenerEstado de la clase estadosDao: "+ e);
		}
		
		try {
			listaMicrosxestado = microxestadoDao.listarMicrosxestado(estado);
		} catch (ExcepcionesDAO e) {
			log.error("fall贸 al invocar el metodo listarMicrosxestado de la clase microxestadoDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en 茅l.
		 */
		if(listaMicrosxestado == null){
			throw new ExcepcionesLogica("No se encontraron Micros x estado de tipo estado en la tabla TbMicMicroxestado");
		}else{
			return listaMicrosxestado;
		}
	}

	@Override
	public int contarRegistros() throws ExcepcionesLogica {
		int registro = 0;
		
		try {
			registro = microxestadoDao.contarRegistros();
		} catch (ExcepcionesDAO e) {
			throw new ExcepcionesLogica();
		}
		
		return registro;
	}
	
	

}
