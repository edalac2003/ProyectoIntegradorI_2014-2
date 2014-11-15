package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.UnidadesDAO;
import com.udea.proint1.microcurriculo.dto.TbMicUnidades;
import com.udea.proint1.microcurriculo.ngc.UnidadesNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class UnidadesNGCImpl extends HibernateDaoSupport implements UnidadesNGC {
	
private static Logger log = Logger.getLogger(UnidadesNGCImpl.class);
	
	UnidadesDAO unidadesDao;
	
	public void setunidadesDao(UnidadesDAO unidadesDao) {
		this.unidadesDao = unidadesDao;
	}

	
	@Override
	public void guardarUnidades(TbMicUnidades unidad) throws ExcepcionesLogica {
		if (unidad != null){
			TbMicUnidades unidadTmp = null;
			try {
				unidadTmp = unidadesDao.obtenerUnidad(unidad.getNbIdunidad());				
			} catch (ExcepcionesDAO e) {
				throw new ExcepcionesLogica();
			}
			if (unidadTmp == null){
				try {
					unidadesDao.guardarUnidad(unidad);
				} catch (ExcepcionesDAO e) {
					throw new ExcepcionesLogica();
				}
			}else
				throw new ExcepcionesLogica();
			
		}else{
			throw new ExcepcionesLogica();
		}
		

	}

	@Override
	public void guardarUnidades(List<TbMicUnidades> unidad)	throws ExcepcionesLogica {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TbMicUnidades obtenerUnidades(int idUnidad) throws ExcepcionesLogica {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public void actualizarUnidades(TbMicUnidades unidad) throws ExcepcionesLogica {
		// TODO Auto-generated method stub

	}

	@Override
	public List<TbMicUnidades> listarUnidades() throws ExcepcionesLogica {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int numeroRegistros() throws ExcepcionesLogica {
		int registro = 0;
		try {
			registro = unidadesDao.numeroRegistros();
		} catch (ExcepcionesDAO e) {
			throw new ExcepcionesLogica("Se produjo un Error al Contar los Registros de la Tabla Unidades.");
		}
		
		return registro;
	}
	
	

}
