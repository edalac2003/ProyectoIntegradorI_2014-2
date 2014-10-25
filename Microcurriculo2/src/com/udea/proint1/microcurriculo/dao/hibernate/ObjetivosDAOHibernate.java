package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.ObjetivosDAO;
import com.udea.proint1.microcurriculo.dto.TbMicObjetivos;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class ObjetivosDAOHibernate extends HibernateDaoSupport implements ObjetivosDAO {

	public ObjetivosDAOHibernate() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void guardarObjetivo(TbMicObjetivos objetivo) throws ExcepcionesDAO {
		Session session = null;
		Transaction tx = null;
		
		try{
			session = getSession();
			tx = session.beginTransaction();
			session.save(objetivo);
			tx.commit();
			
		}catch(HibernateException e){
			throw new ExcepcionesDAO();
		}

	}

	@Override
	public TbMicObjetivos obtenerObjetivo(int idObjetivo) throws ExcepcionesDAO {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TbMicObjetivos> listarObjetivosPorMicrocurriculo(
			String idMicrocurriculo) throws ExcepcionesDAO {
		Session session = null;
		List<TbMicObjetivos> objetivos = new ArrayList<TbMicObjetivos>();
		
		try{
			session = getSession();
			Criteria criteria = session.createCriteria(TbMicObjetivos.class);
			
			objetivos = criteria.list();
			
		}catch(HibernateException e){
			throw new ExcepcionesDAO();
		}
		return objetivos;
	}

	@Override
	public List<TbMicObjetivos> listarObjetivosPorTipo(String idMicrocurriculo,
			char tipo) throws ExcepcionesDAO {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modificarObjetivo(TbMicObjetivos objetivo) throws ExcepcionesDAO {
		Session session = null;
		Transaction tx = null;
		
		try{
			session = getSession();
			tx = session.beginTransaction();
			session.update(objetivo);
			tx.commit();
			
		}catch(HibernateException e){
			throw new ExcepcionesDAO();
		}

	}

}
