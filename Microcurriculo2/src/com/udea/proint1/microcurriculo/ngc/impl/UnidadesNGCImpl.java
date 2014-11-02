package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.Date;
import java.util.List;

import com.udea.proint1.microcurriculo.dao.UnidadesDAO;
import com.udea.proint1.microcurriculo.dto.TbMicUnidades;
import com.udea.proint1.microcurriculo.ngc.UnidadesNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class UnidadesNGCImpl implements UnidadesNGC {
	
private static Logger log=Logger.getLogger(UnidadesNGCImpl.class);
	
	UnidadesDAO unidadesDao;
	
	public UnidadesDAO getUnidadesDAO() {
		return unidadesDao;
	}

	public void setunidadesDao(UnidadesDAO unidadesDao) {
		this.unidadesDao = unidadesDao;
	}

	@Override
	public TbMicUnidades obtenerUnicades(int idUnidad) throws ExcepcionesLogica {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void guardarUnidades(TbMicUnidades unidad) throws ExcepcionesLogica {
		// TODO Auto-generated method stub

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

}
