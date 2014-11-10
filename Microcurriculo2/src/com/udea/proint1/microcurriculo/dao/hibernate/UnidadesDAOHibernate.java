package com.udea.proint1.microcurriculo.dao.hibernate;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.UnidadesDAO;
import com.udea.proint1.microcurriculo.dto.TbMicUnidades;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class UnidadesDAOHibernate extends HibernateDaoSupport implements UnidadesDAO {

	public UnidadesDAOHibernate() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void guardarUnidad(TbMicUnidades unidad) throws ExcepcionesDAO {
		Session session = null;
		Transaction tx = null;
		
		try{
			session = getSession();
			tx = session.beginTransaction();
			session.save(unidad);
			tx.commit();
			
		}catch(HibernateException e){
			throw new ExcepcionesDAO();
		}

	}

	@Override
	public TbMicUnidades obtenerUnidad(int idUnidad) throws ExcepcionesDAO {
		Session session = null;
		TbMicUnidades unidad = null;
		
		try{
			session = getSession();
			unidad = (TbMicUnidades)session.get(TbMicUnidades.class, idUnidad);
			
		}catch(HibernateException e){
			throw new ExcepcionesDAO();
		}
		
		return unidad;
	}

	
	@Override
	public void modificarUnidad(TbMicUnidades unidad) throws ExcepcionesDAO {
		Session session = null;
		Transaction tx = null;
		
		try{
			session = getSession();
			tx = session.beginTransaction();
			session.update(unidad);
			tx.commit();
			
		}catch(HibernateException e){
			throw new ExcepcionesDAO();
		}
	}

	@Override
	public int numeroRegistros() throws ExcepcionesDAO {
		Session session = null;
		int registro = 0;
		try {
			session = getSession();
			Criteria criteria = session.createCriteria(UnidadesDAOHibernate.class);
			registro = criteria.list().size();			
		} catch(HibernateException e){
			throw new ExcepcionesDAO("No Devolvió Ningun Numero de Registro");
		}		
		return registro;
	}
	
	

}
