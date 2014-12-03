package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.udea.proint1.microcurriculo.dao.CiudadesDAO;
import com.udea.proint1.microcurriculo.dao.TemasDAO;
import com.udea.proint1.microcurriculo.dao.TemasXUnidadDAO;
import com.udea.proint1.microcurriculo.dao.UnidadesDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmPrerrequisitos;
import com.udea.proint1.microcurriculo.dto.TbMicBiblioxunidad;
import com.udea.proint1.microcurriculo.dto.TbMicTemasxunidad;
import com.udea.proint1.microcurriculo.dto.TbMicUnidades;
import com.udea.proint1.microcurriculo.ngc.TemasxUnidadNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class TemasxUnidadNGCImpl implements TemasxUnidadNGC {
	
	private static Logger log=Logger.getLogger(TemasxUnidadNGCImpl.class);
	
	TemasXUnidadDAO temasxunidadDao;
	UnidadesDAO unidadesDao;	
	TemasDAO temasDao;

	
	public void setTemasxunidadDao(TemasXUnidadDAO temasxunidadDao) {
		this.temasxunidadDao = temasxunidadDao;
	}

	public void setUnidadesDao(UnidadesDAO unidadesDao) {
		this.unidadesDao = unidadesDao;
	}

	public void setTemasDao(TemasDAO temasDao) {
		this.temasDao = temasDao;
	}

	
	@Override
	public TbMicTemasxunidad obtenerTemasxUnidad(int id) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el dato id no sea vacio
		 */
		if(id == 0){
			throw new ExcepcionesLogica("No se ha ingresado una identificación de temaxunidad, está vacia");
		}
		TbMicTemasxunidad temaxUnidad = null;
		
		try {
			//le pedimos a la clase Dao que nos traiga la ciudad con dicho id
			temaxUnidad = temasxunidadDao.obtenerTemaXunidad(id);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerTemaXunidad de la clase temasxunidadDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(temaxUnidad == null){
			//si está vacio tira una excepción
			throw new ExcepcionesLogica("No se encontró Tema x Unidad con el id "+ id);
		}else{
			//si no esta vacio retorna la ciudad
			return temaxUnidad;
		}
	}

	@Override
	public void guardarTemasxUnidad(TbMicTemasxunidad temasxunidad) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		TbMicTemasxunidad temaxUnidadTmp = null;
		if (temasxunidad != null){
			try {
				temaxUnidadTmp = temasxunidadDao.obtenerTemaXunidad(temasxunidad.getNbId());
			} catch (ExcepcionesDAO e) {
				throw new ExcepcionesLogica();
			}			
		}else{
			throw new ExcepcionesLogica();
		}
		
		if(temaxUnidadTmp == null){
			try {
				temasxunidadDao.guardarTemasXUnidad(temasxunidad);
			} catch (ExcepcionesDAO e) {
				throw new ExcepcionesLogica();
			}
		}else{
			throw new ExcepcionesLogica();
		}
	}
	
  /*@Override
	public void guardarTemasxUnidad(List<TbMicTemasxunidad> listaTemasxUnidad) throws ExcepcionesLogica {
		if (listaTemasxUnidad != null){
			for(TbMicTemasxunidad txU : listaTemasxUnidad)
				guardarTemasxUnidad(txU);
		}
		
	}*/

	@Override
	public void actualizarTemaxUnidad(TbMicTemasxunidad temasxunidad) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		/*if(temasxunidad == null){
			throw new ExcepcionesLogica("El objeto temasxunidad está vacio");
		}
		try {
			int id = temasxunidad.getNbId();
			TbAdmPrerrequisitos temasxunidadConsulta = temasxunidadDao.obtenerTemasxunidad(id);
		
			if(temasxunidadConsulta == null){
				throw new ExcepcionesLogica("El prerrequisito a actualizar no existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerTemasxunidad de la clase temasxunidadDao: "+ e);
		}
		
		try {
			
			temasxunidadDao.actualizarTemasxunidad(temasxunidad);
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo actualizarTemasxunidad de la clase temasxunidadDao: "+ e);
		}*/
	}

	

	@Override
	public List<TbMicTemasxunidad> listarTemasxUnidad()
			throws ExcepcionesLogica {
		List<TbMicTemasxunidad> listatemasxunidad = null;
		try {
			listatemasxunidad = temasxunidadDao.ListarTemasXunidad();
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo ListarTemasXunidad de la clase temasxunidadDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(listatemasxunidad == null){
			throw new ExcepcionesLogica("No se encontraron temas x unidad en la tabla TbMicTemasxunidad");
		}else{
			return listatemasxunidad;
		}
	}

	@Override
	public int contarRegistros() throws ExcepcionesLogica {
		int registro = 0;
		
		try {
			registro = temasxunidadDao.contarRegistros();
		} catch (ExcepcionesDAO e) {
			throw new ExcepcionesLogica("NGC : No se pudo obtener un valor v�lido para el numero de Registros.");
		}
		
		return registro;
	}
	
	public List<TbMicTemasxunidad> ListarTemasxUnidadxUnidad(int idUnidad) throws ExcepcionesLogica{
		List<TbMicTemasxunidad> listaTemasxUnidad = null;
		
		TbMicUnidades unidad= null;
		
		try {
			unidad = unidadesDao.obtenerUnidad(idUnidad);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerUnidad de la clase unidadesDao: "+ e);
		}
		
		
		try {
			listaTemasxUnidad = temasxunidadDao.ListarTemasxUnidadxUnidad(unidad);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo ListarTemasxUnidadxUnidad(TbMicUnidades) de la clase temasxunidadDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		return listaTemasxUnidad;
	}

}
