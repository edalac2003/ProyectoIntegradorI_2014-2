package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.Date;
import java.util.List;

import com.udea.proint1.microcurriculo.dao.CiudadesDAO;
import com.udea.proint1.microcurriculo.dto.TbMicTemasxunidad;
import com.udea.proint1.microcurriculo.ngc.TemasxUnidadNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class TemasxUnidadNGCimpl implements TemasxunidadNGC {
	
	private static Logger log=Logger.getLogger(TemasxUnidadNGCImpl.class);
	
	TemasxUnidadDAO temasxunidadDao;
	
	public TemasxUnidadDAO getTemasxUnidadDAO() {
		return temasxunidadDao;
	}

	public void setTemasxUnidadDao(TemasxUnidadDAO temasxUnidadDao) {
		this.temasxunidadDao = temasxUnidadDao;
	}

	@Override
	public TbMicTemasxunidad obtenerTemasxUnidad(int id)
			throws ExcepcionesLogica {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void guardarTemasxUnidad(int id, int idUnidad, int idTemas,
			int semanasRequeridas, String usuario, Date fecha)
			throws ExcepcionesLogica {
		// TODO Auto-generated method stub

	}

	@Override
	public void actualizarTemaxUnidad(int idUnidad, int idTemas,
			int semanasRequeridas, String usuario, Date fecha)
			throws ExcepcionesLogica {
		// TODO Auto-generated method stub

	}

	@Override
	public List<TbMicTemasxunidad> listarTemasxUnidad()
			throws ExcepcionesLogica {
		// TODO Auto-generated method stub
		return null;
	}

}
