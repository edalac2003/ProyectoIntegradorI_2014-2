package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.SubtemasDAO;
import com.udea.proint1.microcurriculo.dto.TbMicSubtemas;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

/**
 * 
 * @author eacosta
 *
 */
public class SubtemasDAOHibernate extends HibernateDaoSupport implements SubtemasDAO {

	public SubtemasDAOHibernate() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void guardarSubtema(TbMicSubtemas subtema) throws ExcepcionesDAO {
		Session session = null;
		Transaction tx = null;
		
		try{
			session = getSession();
			tx = session.beginTransaction();
			session.save(subtema);
			tx.commit();
			
		}catch(HibernateException e){
			throw new ExcepcionesDAO();
		}

	}

	@Override
	public void modificarSubtema(TbMicSubtemas subtema) throws ExcepcionesDAO {
		Session session = null;
		Transaction tx = null;
		
		try{
			session = getSession();
			tx = session.beginTransaction();
			session.update(subtema);
			tx.commit();
			
		}catch(HibernateException e){
			throw new ExcepcionesDAO();
		}

	}
	

	@Override
	public TbMicSubtemas obtenerSubtemas(int idTema) throws ExcepcionesDAO {
		Session session = null;
		TbMicSubtemas subtema = null;
		
		try{
			session = getSession();
			subtema = (TbMicSubtemas)session.get(TbMicSubtemas.class, idTema);
			
		}catch(HibernateException e){
			throw new ExcepcionesDAO();
		}
		
		return subtema;
	}

	@Override
	public List<TbMicSubtemas> listarSubtemas() throws ExcepcionesDAO {
		Session session = null;
		List<TbMicSubtemas> subtemas = new ArrayList<TbMicSubtemas>();
		
		try{
			session = getSession();
			Criteria criteria = session.createCriteria(TbMicSubtemas.class);
			subtemas = criteria.list();
			
		}catch(HibernateException e){
			throw new ExcepcionesDAO();
		}
		return subtemas;
	}

	@Override
	public List<TbMicSubtemas> listarSubtemasPorTema(int idTema)
			throws ExcepcionesDAO {
		Session session = null;
		List<TbMicSubtemas> subtemas = new ArrayList<TbMicSubtemas>();
		
		return null;
	}

}
