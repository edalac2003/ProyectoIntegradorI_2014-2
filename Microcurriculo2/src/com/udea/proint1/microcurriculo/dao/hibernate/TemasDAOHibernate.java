package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.TemasDAO;
import com.udea.proint1.microcurriculo.dto.Temas;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

/**
 * 
 * @author eacosta
 *
 */
public class TemasDAOHibernate extends HibernateDaoSupport implements TemasDAO {

	public TemasDAOHibernate() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	@Override
	public void guardarTema(Temas tema) throws ExcepcionesDAO {
		Session session = null;
		Transaction tx = null;
		
		try {
			session = getSession();
			tx = session.beginTransaction();
			session.save(tema);
			tx.commit();
			
		}catch(HibernateException e){
			throw new ExcepcionesDAO();
		}

	}

	
	/**
	 * 
	 */
	@Override
	public void modificarTema(Temas tema) throws ExcepcionesDAO {
		Session session = null;
		Transaction tx = null;
		
		try {
			session = getSession();
			tx = session.beginTransaction();
			session.update(tema);
			tx.commit();
			
		}catch(HibernateException e){
			throw new ExcepcionesDAO();
		}
	}

	/**
	 * 
	 */
	@Override
	public Temas obtenerTema(int idTema) throws ExcepcionesDAO {
		Session session = null;
		Temas tema = null;
		
		try{
			session = getSession();
			tema = (Temas)session.get(Temas.class, idTema);
			
		}catch(HibernateException e){
			throw new ExcepcionesDAO();
		}
				
		return tema;
	}

	/**
	 * 
	 */
	@Override
	public List<Temas> listarTemas() throws ExcepcionesDAO {
		Session session = null;
		List<Temas> temas = new ArrayList<Temas>();
		
		try{
			session = getSession();
			Criteria criteria = session.createCriteria(Temas.class);
			temas = criteria.list();
			
		}catch(HibernateException e){
			throw new ExcepcionesDAO();
			
		}
		
		return temas;
	}

}
