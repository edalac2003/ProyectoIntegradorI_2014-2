package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.udea.proint1.microcurriculo.dao.CiudadesDAO;
import com.udea.proint1.microcurriculo.dto.TbMicTemasxunidad;
import com.udea.proint1.microcurriculo.ngc.TemasxUnidadNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class TemasxUnidadNGCImpl implements TemasxUnidadNGC {
	
	private static Logger log=Logger.getLogger(TemasxUnidadNGCImpl.class);
	
	TemasxUnidadDAO temasxunidadDao;
	
	UnidadesDAO unidadesDao;
	
	TemasDAO temasDao;

	public void setTemasxUnidadDao(TemasxUnidadDAO temasxUnidadDao) {
		this.temasxunidadDao = temasxUnidadDao;
	}

	public void setUnidadesDao(UnidadesDAO unidadesDao) {
		this.unidadesDao = unidadesDao;
	}

	public void setTemasDao(TemasDAO temasDao) {
		this.temasDao = temasDao;
	}

	@Override
	public TbMicTemasxunidad obtenerTemasxUnidad(int id)throws ExcepcionesLogica {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void guardarTemasxUnidad(TbMicTemasxunidad temasxunidad) throws ExcepcionesLogica {
		// TODO Auto-generated method stub

	}

	@Override
	public void actualizarTemaxUnidad(TbMicTemasxunidad tbMicTemasxunidad) throws ExcepcionesLogica {
		// TODO Auto-generated method stub

	}

	@Override
	public List<TbMicTemasxunidad> listarTemasxUnidad() throws ExcepcionesLogica {
		// TODO Auto-generated method stub
		return null;
	}

}
