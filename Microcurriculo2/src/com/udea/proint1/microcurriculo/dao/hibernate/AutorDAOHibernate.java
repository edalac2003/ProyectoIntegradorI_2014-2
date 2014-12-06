package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.AutorDao;
import com.udea.proint1.microcurriculo.dto.TbAdmUnidadAcademica;
import com.udea.proint1.microcurriculo.dto.TbMicAutor;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class AutorDAOHibernate extends HibernateDaoSupport implements AutorDao {

	@Override
	public void guardarAutores(TbMicAutor autores) throws ExcepcionesDAO {
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
	public TbMicAutor obtenerAutores(int id) throws ExcepcionesDAO {
		Session session = null;
		TbMicAutor autor = null;

		try {
			session = getSession();
			autor = (TbMicAutor) session.load(TbMicAutor.class, id);

		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		}
		return autor;
	}

	@Override
	public List<TbMicAutor> listarAutores() throws ExcepcionesDAO {
		Session session = null;
        List<TbMicAutor> autores = new ArrayList<TbMicAutor>();
        
		try {
			session = getSession();
			Criteria criteria = session.createCriteria(TbMicAutor.class);
			
			autores = criteria.list();
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
			
		}
		return autores;
	}

	@Override
	public void actualizarAutores(TbMicAutor autor) throws ExcepcionesDAO {
		Session session = null;

		try {
			session = getSession();
			this.getHibernateTemplate().update(autor);

		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		}
	}

}
