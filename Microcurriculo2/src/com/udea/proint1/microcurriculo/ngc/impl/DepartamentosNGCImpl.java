package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.udea.proint1.microcurriculo.dao.DepartamentosDAO;
import com.udea.proint1.microcurriculo.dao.PaisesDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmDepartamentos;
import com.udea.proint1.microcurriculo.ngc.DepartamentosNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class DepartamentosNGCImpl implements DepartamentosNGC {
	
	private static Logger log=Logger.getLogger(DepartamentosNGCImpl.class);
	
	DepartamentosDAO departamentosDao;
	PaisesDAO paisesDao;

	public DepartamentosNGCImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<TbAdmDepartamentos> listarDepartamentos()
			throws ExcepcionesLogica {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TbAdmDepartamentos obtenerDepartamentos(int id)
			throws ExcepcionesLogica {
		// TODO Auto-generated method stub
		return null;
	}

}
