package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.DependenciasDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmDependencia;
import com.udea.proint1.microcurriculo.dto.TbAdmMaterias;
import com.udea.proint1.microcurriculo.dto.TbMicMicrocurriculos;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class DependenciasDAOHibernate extends HibernateDaoSupport implements DependenciasDAO {

	@Override
	public void guardarDependencia(TbAdmDependencia dependencias)
			throws ExcepcionesDAO {
		Session session = null;
		Transaction tx = null;
		
		try{
			session = getSession();
			
			tx = session.beginTransaction();
			session.save(dependencias);
			tx.commit();
			
		}catch(HibernateException e){
			
		}

		
	}

	@Override
	public TbAdmDependencia obtenerDependencias(String id)
			throws ExcepcionesDAO {
		Session session = null;
		TbAdmDependencia dependencia = null;
		
		try{
			session = getSession();
			dependencia = (TbAdmDependencia)session.get(TbAdmDependencia.class, id);
			
		}catch(HibernateException e){
			throw new ExcepcionesDAO();
		}
		return dependencia;
	}

	@Override
	public List<TbAdmDependencia> listarDependencias() throws ExcepcionesDAO {
		Session session = null;
		List<TbAdmDependencia> dependencia = new ArrayList<TbAdmDependencia>();
		
		try{
			session = getSession();
			
			Criteria criteria = session.createCriteria(TbAdmDependencia.class);
			
			dependencia = criteria.list();
			
		}catch(HibernateException e){
			throw new ExcepcionesDAO();
		}
		
		return dependencia;
	}

}
