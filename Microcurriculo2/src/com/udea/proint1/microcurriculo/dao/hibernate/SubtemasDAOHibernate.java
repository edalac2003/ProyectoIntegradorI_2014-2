package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.SubtemasDAO;
import com.udea.proint1.microcurriculo.dto.Subtemas;
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
	public void guardarSubtema(Subtemas subtema) throws ExcepcionesDAO {
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
	public void modificarSubtema(Subtemas subtema) throws ExcepcionesDAO {
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
	public Subtemas obtenerSubtemas(int idTema) throws ExcepcionesDAO {
		Session session = null;
		Subtemas subtema = null;
		
		try{
			session = getSession();
			subtema = (Subtemas)session.get(Subtemas.class, idTema);
			
		}catch(HibernateException e){
			throw new ExcepcionesDAO();
		}
		
		return subtema;
	}

	@Override
	public List<Subtemas> listarSubtemas() throws ExcepcionesDAO {
		Session session = null;
		List<Subtemas> subtemas = new ArrayList<Subtemas>();
		
		try{
			session = getSession();
			Criteria criteria = session.createCriteria(Subtemas.class);
			subtemas = criteria.list();
			
		}catch(HibernateException e){
			throw new ExcepcionesDAO();
		}
		return subtemas;
	}

	@Override
	public List<Subtemas> listarSubtemasPorTema(int idTema)
			throws ExcepcionesDAO {
		Session session = null;
		List<Subtemas> subtemas = new ArrayList<Subtemas>();
		
		return null;
	}

}
