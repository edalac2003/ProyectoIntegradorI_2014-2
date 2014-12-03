package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.MicrocurriculosDAO;
import com.udea.proint1.microcurriculo.dao.UnidadesXMicroDAO;
import com.udea.proint1.microcurriculo.dto.TbMicBiblioxunidad;
import com.udea.proint1.microcurriculo.dto.TbMicMicrocurriculos;
import com.udea.proint1.microcurriculo.dto.TbMicUnidades;
import com.udea.proint1.microcurriculo.dto.TbMicUnidadesxmicro;
import com.udea.proint1.microcurriculo.ngc.UnidadesxMicroNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class UnidadesxMicroNGCImpl  implements UnidadesxMicroNGC {
	
	private static Logger log=Logger.getLogger(UnidadesxMicroNGCImpl.class);
	
	UnidadesXMicroDAO unidadesxMicroDao;
	
	MicrocurriculosDAO microcurriculosDao;
	
	public void setUnidadesxMicroDao(UnidadesXMicroDAO unidadesxMicroDao) {
		this.unidadesxMicroDao = unidadesxMicroDao;
	}

	public void setMicrocurriculosDao(MicrocurriculosDAO microcurriculosDao) {
		this.microcurriculosDao = microcurriculosDao;
	}

	@Override
	public void guardarUnidadXmicro(TbMicUnidadesxmicro unidadXmicro) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no est� vacio
		 */
		if(unidadXmicro == null){
			throw new ExcepcionesLogica("El objeto unidadXmicro est� vacio");
		}
		try {
			int id = unidadXmicro.getNbId();
			TbMicUnidadesxmicro unidadXmicroConsulta = unidadesxMicroDao.obtenerUnidadXmicro(id);
		
			if(unidadXmicroConsulta != null){
				throw new ExcepcionesLogica("La Unidad x Microcurriculo a insertar ya existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("fall� al invocar el metodo obtenerUnidadXmicro de la clase unidadesxMicroDao: "+ e);
		}
		
		try {
			
			unidadesxMicroDao.guardarUnidadXmicro(unidadXmicro);;
		
		} catch (ExcepcionesDAO e) {
			log.error("fall� al invocar el metodo guardarUnidadXmicro de la clase unidadesxMicroDao: "+ e);
		}
	}

	
	/*@Override
	public void guardarUnidadXmicro(List<TbMicUnidadesxmicro> listaUnidadxMicro) throws ExcepcionesLogica {
		if(listaUnidadxMicro != null){
			for(TbMicUnidadesxmicro uxM : listaUnidadxMicro){
				guardarUnidadXmicro(uxM);
			}
		}else{
			throw new ExcepcionesLogica();
		}		
	}*/

	@Override
	public void modificarUnidadXmicro(TbMicUnidadesxmicro unidadXmicro)
			throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(unidadXmicro == null){
			throw new ExcepcionesLogica("El objeto unidadXmicro está vacio");
		}
		try {
			int id = unidadXmicro.getNbId();
			TbMicUnidadesxmicro unidadXmicroConsulta = unidadesxMicroDao.obtenerUnidadXmicro(id);
		
			if(unidadXmicroConsulta == null){
				throw new ExcepcionesLogica("La unidad x micro actualizar no existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerUnidadXmicro de la clase unidadesxMicroDao: "+ e);
		}
		
		try {
			
			unidadesxMicroDao.modificarUnidadXmicro(unidadXmicro);
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo modificarUnidadXmicro de la clase unidadesxMicroDao: "+ e);
		}
	}

	@Override
	public TbMicUnidadesxmicro obtenerUnidadXmicro(int id) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el dato id no sea vacio
		 */
		if(id == 0){
			throw new ExcepcionesLogica("No se ha ingresado una identificación de unidadxmicro, está vacia");
		}
		TbMicUnidadesxmicro unidadXmicro = null;
		
		try {
			//le pedimos a la clase Dao que nos traiga la ciudad con dicho id
			unidadXmicro = unidadesxMicroDao.obtenerUnidadXmicro(id);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerUnidadXmicro de la clase unidadesxMicroDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(unidadXmicro == null){
			//si está vacio tira una excepción
			throw new ExcepcionesLogica("No se encontró Unidad x Micro con el id "+ id);
		}else{
			//si no esta vacio retorna la ciudad
			return unidadXmicro;
		}
	}

	@Override
	public List<TbMicUnidadesxmicro> listarUnidadesXMicroxMicro(
			String idMicrocurriculo) throws ExcepcionesLogica {
		List<TbMicUnidadesxmicro> listaUnidadesxMicro = null;
		
		TbMicMicrocurriculos microcurriculo= null;
		
		try {
			microcurriculo = microcurriculosDao.obtenerMicrocurriculo(idMicrocurriculo);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerMicrocurriculo de la clase microcurriculosDao: "+ e);
		}
		
		
		try {
			listaUnidadesxMicro = unidadesxMicroDao.listarUnidadesXMicroxMicro(microcurriculo);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo listarUnidadesXMicroxMicro de la clase unidadesxMicroDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		return listaUnidadesxMicro;
	}

	@Override
	public List<TbMicUnidadesxmicro> listarUnidadesXmicro()
			throws ExcepcionesLogica {
		List<TbMicUnidadesxmicro> listaUnidadesxMicro = null;
		try {
			listaUnidadesxMicro = unidadesxMicroDao.listarUnidadesXmicro();
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo listarUnidadesXmicro de la clase unidadesxMicroDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(listaUnidadesxMicro == null){
			throw new ExcepcionesLogica("No se encontraron UnidadesxMicro en la tabla TbMicUnidadesxmicro");
		}else{
			return listaUnidadesxMicro;
		}
	}

	@Override
	public int contarRegistros() throws ExcepcionesLogica {
		int registro = 0;
		
		try {
			registro = unidadesxMicroDao.contarRegistros();
		} catch (ExcepcionesDAO e) {
			throw new ExcepcionesLogica("Se produjeron Errores al Obtener el numero de Registros de la Tabla Unidades x Microcurriculo.");
		}
				
		return 0;
	}
	
	

}
