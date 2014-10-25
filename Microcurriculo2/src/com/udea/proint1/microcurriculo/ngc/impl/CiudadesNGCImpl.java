package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.udea.proint1.microcurriculo.dao.CiudadesDAO;
import com.udea.proint1.microcurriculo.dao.hibernate.DepartamentosDAOHibernate;
import com.udea.proint1.microcurriculo.dto.TbAdmCiudades;
import com.udea.proint1.microcurriculo.ngc.CiudadesNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class CiudadesNGCImpl implements CiudadesNGC {

	private static Logger log=Logger.getLogger(CiudadesNGCImpl.class);
	
	CiudadesDAO ciudadesDao;
	
	public CiudadesDAO getCiudadesDao() {
		return ciudadesDao;
	}

	public void setCiudadesDao(CiudadesDAO ciudadesDao) {
		this.ciudadesDao = ciudadesDao;
	}

	public CiudadesNGCImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public TbAdmCiudades obtenerCiudad(int id) throws ExcepcionesLogica {
		if(id==0){
			throw new ExcepcionesLogica("No se ha ingresado una identificación de ciudad, este está vacio");
		}
		TbAdmCiudades ciudad = null;
		ciudad = ciudadesDao.obtenerCiudad(id);
		return ciudad;
	}

	@Override
	public List<TbAdmCiudades> listarCiudades() throws ExcepcionesLogica {
		List<TbAdmCiudades> listaCiudades = null;
		listaCiudades = ciudadesDao.listarCiudades();
		return listaCiudades;
	}

}
