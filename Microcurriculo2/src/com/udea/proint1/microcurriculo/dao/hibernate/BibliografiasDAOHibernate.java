package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.BibliografiaDAO;
import com.udea.proint1.microcurriculo.dto.TbMicBibliografia;
import com.udea.proint1.microcurriculo.dto.TbMicMicrocurriculos;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class BibliografiasDAOHibernate extends HibernateDaoSupport implements BibliografiaDAO {

	public BibliografiasDAOHibernate() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void guardarBibliografia(TbMicBibliografia bibliografia)
			throws ExcepcionesDAO {
		Session session = null;
				
		try{
			session = getSession();			
			//save example - without transaction
	        session.save(bibliografia);
	        session.flush(); //address will not get saved without this
			
		}catch(HibernateException e){
			
		}

	}

	@Override
	public void modificarBibliografia(TbMicBibliografia bibliografia)
			throws ExcepcionesDAO {
		Session session = null;
		
		try{
			session = getSession();
			this.getHibernateTemplate().update(bibliografia);
			
		}catch(HibernateException e){
			throw new ExcepcionesDAO();
		}

	}

	@Override
	public List<TbMicBibliografia> listarBibliografia(String idMicrocurriculo) throws ExcepcionesDAO {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TbMicBibliografia> listarBibliografia(char tipo) throws ExcepcionesDAO {
		Session session = null;
		List<TbMicBibliografia> bibliografias = new ArrayList<TbMicBibliografia>();

		try {
			session = getSession();

			Query query = session
					.createQuery("from TbMicBibliografia where blTipo = :tipoBibliografia");

			query.setEntity("tipoBibliografia", tipo);

			bibliografias = query.list();

		} catch (HibernateException e) {
			throw new ExcepcionesDAO();
		}

		return bibliografias;
	}

	@Override
	public int contarRegistros() throws ExcepcionesDAO {
		int registro = 0;
		Session session = null;
		
		try{
			session = getSession();
			Criteria criteria = session.createCriteria(TbMicBibliografia.class);
			registro = criteria.list().size();
			
		}catch(HibernateException e){
			throw new ExcepcionesDAO("Problemas para contar el numero de registros de la tabla Bibliografias");
		}
		
		
		return registro;
	}
	
	

}
