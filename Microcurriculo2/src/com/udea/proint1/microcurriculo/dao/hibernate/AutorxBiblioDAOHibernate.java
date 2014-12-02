package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.AutorxBiblioDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmUnidadAcademica;
import com.udea.proint1.microcurriculo.dto.TbMicAutorxbiblio;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class AutorxBiblioDAOHibernate extends HibernateDaoSupport implements AutorxBiblioDAO {

	@Override
	public void guardarAutorxBibliografia(TbMicAutorxbiblio autorxBibliografia)
			throws ExcepcionesDAO {
		Session session = null;

		try {
			session = getSession();
			session.save(autorxBibliografia);
			session.flush(); 
		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		}
	}

	@Override
	public TbMicAutorxbiblio obtenerAutorxBibliografia(int id)
			throws ExcepcionesDAO {
		Session session = null;
		TbMicAutorxbiblio autorxBibliografia = null;

		try {
			session = getSession();
			autorxBibliografia = (TbMicAutorxbiblio) session.load(TbMicAutorxbiblio.class, id);

		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		}
		return autorxBibliografia;
	}

	@Override
	public List<TbMicAutorxbiblio> listarAutorxBibliografia()
			throws ExcepcionesDAO {
		Session session = null;
        List<TbMicAutorxbiblio> autoresxBibliografia = new ArrayList<TbMicAutorxbiblio>();
        
		try {
			session = getSession();
			Criteria criteria = session.createCriteria(TbMicAutorxbiblio.class);
			
			autoresxBibliografia = criteria.list();
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
			
		}
		return autoresxBibliografia;
	}

	@Override
	public void actualizarAutorxBibliografia(
			TbMicAutorxbiblio autorxBibliografia) throws ExcepcionesDAO {
		Session session = null;

		try {
			session = getSession();
			this.getHibernateTemplate().update(autorxBibliografia);

		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		}
	}

}
