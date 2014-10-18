package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.UnidadesDAO;
import com.udea.proint1.microcurriculo.dto.Unidades;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class UnidadesDAOHibernate extends HibernateDaoSupport implements UnidadesDAO {

	public UnidadesDAOHibernate() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void guardarUnidad(Unidades unidad) throws ExcepcionesDAO {
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
	public Unidades obtenerUnidad(int idUnidad) throws ExcepcionesDAO {
		Session session = null;
		Unidades unidad = null;
		
		try{
			session = getSession();
			unidad = (Unidades)session.get(Unidades.class, idUnidad);
			
		}catch(HibernateException e){
			throw new ExcepcionesDAO();
		}
		
		return unidad;
	}

	
	@Override
	public void modificarUnidad(Unidades unidad) throws ExcepcionesDAO {
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

}
