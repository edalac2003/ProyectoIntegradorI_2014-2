package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.udea.proint1.microcurriculo.dao.CiudadesDAO;
import com.udea.proint1.microcurriculo.dao.TemasDAO;
import com.udea.proint1.microcurriculo.dao.TemasXUnidadDAO;
import com.udea.proint1.microcurriculo.dao.UnidadesDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmPrerrequisitos;
import com.udea.proint1.microcurriculo.dto.TbMicTemasxunidad;
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
	public TbMicTemasxunidad obtenerTemasxUnidad(int id)
			throws ExcepcionesLogica {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void guardarTemasxUnidad(TbMicTemasxunidad temasxunidad) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no est茅 vacio
		 */
		/*if(temasxunidad == null){
			throw new ExcepcionesLogica("El objeto temasxunidad est谩 vacio");
		}
		try {
			int id = temasxunidad.getNbId();
			TbMicTemasxunidad temasxunidadConsulta = temasxunidadDao.obtenerTemasxunidad(id);
		
			if(temasxunidadConsulta != null){
				throw new ExcepcionesLogica("El temasxunidad a insertar ya existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("fall贸 al invocar el metodo obtenerPrerrequisito de la clase prerrequisitosDao: "+ e);
		}
		
		try {
			
			prerrequisitosDao.guardarPrerrequisito(prerrequisito);
		
		} catch (ExcepcionesDAO e) {
			log.error("fall贸 al invocar el metodo obtenerTemasxunidad de la clase temasxunidadDao: "+ e);
		}*/
	}

	@Override
	public void actualizarTemaxUnidad(TbMicTemasxunidad temasxunidad) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no est茅 vacio
		 */
		/*if(temasxunidad == null){
			throw new ExcepcionesLogica("El objeto temasxunidad est谩 vacio");
		}
		try {
			int id = temasxunidad.getNbId();
			TbAdmPrerrequisitos temasxunidadConsulta = temasxunidadDao.obtenerTemasxunidad(id);
		
			if(temasxunidadConsulta == null){
				throw new ExcepcionesLogica("El prerrequisito a actualizar no existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("fall贸 al invocar el metodo obtenerTemasxunidad de la clase temasxunidadDao: "+ e);
		}
		
		try {
			
			temasxunidadDao.actualizarTemasxunidad(temasxunidad);
		
		} catch (ExcepcionesDAO e) {
			log.error("fall贸 al invocar el metodo actualizarTemasxunidad de la clase temasxunidadDao: "+ e);
		}*/
	}

	

	@Override
	public List<TbMicTemasxunidad> listarTemasxUnidad()
			throws ExcepcionesLogica {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int contarRegistros() throws ExcepcionesLogica {
		int registro = 0;
		
		try {
			registro = temasxunidadDao.contarRegistros();
		} catch (ExcepcionesDAO e) {
			throw new ExcepcionesLogica("NGC : No se pudo obtener un valor v醠ido para el numero de Registros.");
		}
		
		return registro;
	}
	
	

}
