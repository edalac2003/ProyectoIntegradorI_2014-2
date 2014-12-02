package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.AutoresDao;
import com.udea.proint1.microcurriculo.dto.TbAdmUnidadAcademica;
import com.udea.proint1.microcurriculo.dto.TbMicAutores;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class AutoresDAOHibernate extends HibernateDaoSupport implements AutoresDao {

	@Override
	public void guardarAutores(TbMicAutores autores) throws ExcepcionesDAO {
		Session session = null;

		try {
			session = getSession();
			session.save(autores);
			session.flush(); 
		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		}
	}

	@Override
	public TbMicAutores obtenerAutores(int id) throws ExcepcionesDAO {
		Session session = null;
		TbMicAutores autor = null;

		try {
			session = getSession();
			autor = (TbMicAutores) session.load(TbMicAutores.class, id);

		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		}
		return autor;
	}

	@Override
	public List<TbMicAutores> listarAutores() throws ExcepcionesDAO {
		Session session = null;
        List<TbMicAutores> autores = new ArrayList<TbMicAutores>();
        
		try {
			session = getSession();
			Criteria criteria = session.createCriteria(TbMicAutores.class);
			
			autores = criteria.list();
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
			
		}
		return autores;
	}

	@Override
	public void actualizarAutores(TbMicAutores autor) throws ExcepcionesDAO {
		Session session = null;

		try {
			session = getSession();
			this.getHibernateTemplate().update(autor);

		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		}
	}

}
