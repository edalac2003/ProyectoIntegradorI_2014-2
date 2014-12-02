package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.UnidadesAcademicasDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmMaterias;
import com.udea.proint1.microcurriculo.dto.TbAdmPersona;
import com.udea.proint1.microcurriculo.dto.TbAdmUnidadAcademica;
import com.udea.proint1.microcurriculo.dto.TbMicMicrocurriculos;
import com.udea.proint1.microcurriculo.dto.TbMicUnidades;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class UnidadesAcademicasDAOHibernate extends HibernateDaoSupport implements UnidadesAcademicasDAO{

	@Override
	public void guardarUnidad(TbAdmUnidadAcademica unidadAcademica) throws ExcepcionesDAO {
		Session session = null;

		try {
			session = getSession();
			session.save(unidadAcademica);
			session.flush(); 
		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		}
	}

	@Override
	public TbAdmUnidadAcademica obtenerUnidad(String idUnidad) throws ExcepcionesDAO {
		Session session = null;
		TbAdmUnidadAcademica unidad = null;

		try {
			session = getSession();
			unidad = (TbAdmUnidadAcademica) session.load(TbAdmUnidadAcademica.class, idUnidad);

		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		}
		return unidad;
	}

	@Override
	public void modificarUnidad(TbAdmUnidadAcademica unidad) throws ExcepcionesDAO {
		Session session = null;

		try {
			session = getSession();
			this.getHibernateTemplate().update(unidad);

		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		}
	}
	
	@Override
	public List<TbAdmUnidadAcademica> listarUnidades() throws ExcepcionesDAO{
		Session session = null;
        List<TbAdmUnidadAcademica> unidadesAcademicas = new ArrayList<TbAdmUnidadAcademica>();
        
		try {
			session = getSession();
			Criteria criteria = session.createCriteria(TbAdmUnidadAcademica.class);
			
			unidadesAcademicas = criteria.list();
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
			
		}
		return unidadesAcademicas;
	}

}
