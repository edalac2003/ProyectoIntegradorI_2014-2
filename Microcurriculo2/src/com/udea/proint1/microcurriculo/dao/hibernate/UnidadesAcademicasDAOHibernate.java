package com.udea.proint1.microcurriculo.dao.hibernate;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.UnidadesAcademicasDAO;
import com.udea.proint1.microcurriculo.dto.TbMicMicrocurriculos;
import com.udea.proint1.microcurriculo.dto.TbMicUnidades;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class UnidadesAcademicasDAOHibernate extends HibernateDaoSupport implements UnidadesAcademicasDAO{

	@Override
	public void guardarUnidad(TbMicUnidades unidad) throws ExcepcionesDAO {
		Session session = null;

		try {
			session = getSession();
			session.save(unidad);
			session.flush(); 
		} catch (HibernateException e) {

		}
		
	}

	@Override
	public TbMicUnidades obtenerUnidad(int idUnidad) throws ExcepcionesDAO {
		Session session = null;
		TbMicUnidades unidad = null;

		try {
			session = getSession();
			unidad = (TbMicUnidades) session.load(TbMicUnidades.class, idUnidad);

		} catch (HibernateException e) {
			throw new ExcepcionesDAO();
		}
		return unidad;
	}

	@Override
	public void modificarUnidad(TbMicUnidades unidad) throws ExcepcionesDAO {
		Session session = null;

		try {
			session = getSession();
			this.getHibernateTemplate().update(unidad);

		} catch (HibernateException e) {
			throw new ExcepcionesDAO();
		}
		
	}

}
