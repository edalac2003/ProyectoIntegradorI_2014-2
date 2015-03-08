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
import com.udea.proint1.microcurriculo.dto.TbAdmUnidadAcademica;
import com.udea.proint1.microcurriculo.dto.TbMicBibliografia;
import com.udea.proint1.microcurriculo.dto.TbMicBiblioxunidad;
import com.udea.proint1.microcurriculo.dto.TbMicMicrocurriculo;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class BibliografiaDAOHibernate extends HibernateDaoSupport implements BibliografiaDAO {

	public BibliografiaDAOHibernate() {
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
			throw new ExcepcionesDAO(e);
		}

	}

	@Override
	public TbMicBibliografia obtenerBibliografia(int id) throws ExcepcionesDAO{
		Session session = null;
		TbMicBibliografia bibliografia = null;

		try {
			session = getSession();
			bibliografia = (TbMicBibliografia) session.load(TbMicBibliografia.class, id);

		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		}
		return bibliografia;
	}
	
	@Override
	public void modificarBibliografia(TbMicBibliografia bibliografia)
			throws ExcepcionesDAO {
		Session session = null;
		
		try{
			session = getSession();
			this.getHibernateTemplate().update(bibliografia);
			
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
		}

	}

	@Override
	public List<TbMicBibliografia> listarBibliografia(String idMicrocurriculo) throws ExcepcionesDAO {
		Session session = null;
        List<TbMicBibliografia> bibliografias = new ArrayList<TbMicBibliografia>();
        
		try {
			session = getSession();
			Criteria criteria = session.createCriteria(TbMicBibliografia.class);
			
			bibliografias = criteria.list();
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
		}
		
		return bibliografias;
	}

	@Override
	public List<TbMicBibliografia> listarBibliografiaxTipo(char tipo) throws ExcepcionesDAO {
		Session session = null;
		List<TbMicBibliografia> bibliografias = new ArrayList<TbMicBibliografia>();

		try {
			session = getSession();

			Query query = session
					.createQuery("from TbMicBibliografia where blTipo = :tipoBibliografia");

			query.setEntity("tipoBibliografia", tipo);

			bibliografias = query.list();

		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
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
	
	public List<TbMicBibliografia> listarBibliografias() throws ExcepcionesDAO{
		Session session = null;
        List<TbMicBibliografia> bibliografias = new ArrayList<TbMicBibliografia>();
        
		try {
			session = getSession();
			Criteria criteria = session.createCriteria(TbMicBibliografia.class);
			
			bibliografias = criteria.list();
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
			
		}
		return bibliografias;
	}

}
