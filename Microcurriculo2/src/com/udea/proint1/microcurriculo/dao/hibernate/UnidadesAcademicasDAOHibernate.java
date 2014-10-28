package com.udea.proint1.microcurriculo.dao.hibernate;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.UnidadesAcademicasDAO;
import com.udea.proint1.microcurriculo.dto.TbMicUnidades;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class UnidadesAcademicasDAOHibernate extends HibernateDaoSupport implements UnidadesAcademicasDAO{

	@Override
	public void guardarUnidad(TbMicUnidades unidad) throws ExcepcionesDAO {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TbMicUnidades obtenerUnidad(int idUnidad) throws ExcepcionesDAO {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modificarUnidad(TbMicUnidades unidad) throws ExcepcionesDAO {
		// TODO Auto-generated method stub
		
	}

}
