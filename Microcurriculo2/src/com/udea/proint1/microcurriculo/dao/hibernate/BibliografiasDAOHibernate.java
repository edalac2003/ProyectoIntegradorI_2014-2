package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.BibliografiaDAO;
import com.udea.proint1.microcurriculo.dto.TbMicBibliografia;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class BibliografiasDAOHibernate extends HibernateDaoSupport implements BibliografiaDAO {

	public BibliografiasDAOHibernate() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void guardarBibliografia(TbMicBibliografia bibliografia)
			throws ExcepcionesDAO {
		Session session = null;
		Transaction tx = null;
		
		try{
			session = getSession();
			
			tx = session.beginTransaction();
			session.save(bibliografia);
			tx.commit();
			
		}catch(HibernateException e){
			
		}

	}

	@Override
	public void modificarBibliografia(TbMicBibliografia bibliografia)
			throws ExcepcionesDAO {
		Session session = null;
		Transaction tx = null;
		
		try{
			session = getSession();
			tx = session.beginTransaction();
			session.update(bibliografia);
			tx.commit();
			
		}catch(HibernateException e){
			throw new ExcepcionesDAO();
		}

	}

	@Override
	public List<TbMicBibliografia> listarBibliografiaPorMicrocurriculo(String idMicrocurriculo) throws ExcepcionesDAO {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TbMicBibliografia> listarBibliografiaPorTipo(
			String idMicrocurriculo, char tipo) throws ExcepcionesDAO {
		// TODO Auto-generated method stub
		return null;
	}

}
