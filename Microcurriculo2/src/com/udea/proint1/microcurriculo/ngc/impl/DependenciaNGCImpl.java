package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.udea.proint1.microcurriculo.dao.DependenciasDAO;
import com.udea.proint1.microcurriculo.dao.UnidadesAcademicasDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmDependencia;
import com.udea.proint1.microcurriculo.ngc.DependenciaNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class DependenciaNGCImpl implements DependenciaNGC {
	
	private static Logger log=Logger.getLogger(DependenciaNGCImpl.class);
	
	DependenciasDAO dependenciaDao;
	
	UnidadesAcademicasDAO unidadAcademicaDao;

	public void setDependenciaDao(DependenciasDAO dependenciaDao) {
		this.dependenciaDao = dependenciaDao;
	}

	public void setUnidadAcademicaDao(UnidadesAcademicasDAO unidadAcademicaDao) {
		this.unidadAcademicaDao = unidadAcademicaDao;
	}

	public DependenciaNGCImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void guardarDependencia(TbAdmDependencia dependencia) throws ExcepcionesLogica {
		// TODO Auto-generated method stub

	}

	@Override
	public void actualizarDependencia(TbAdmDependencia dependencia) throws ExcepcionesLogica {
		// TODO Auto-generated method stub

	}

	@Override
	public TbAdmDependencia obtenerDependencia(String id)
			throws ExcepcionesLogica {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TbAdmDependencia> actualizarDependencia()
			throws ExcepcionesLogica {
		// TODO Auto-generated method stub
		return null;
	}

}
