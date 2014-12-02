package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.DocentesxNucleoDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmDocentesxnucleo;
import com.udea.proint1.microcurriculo.dto.TbAdmUnidadAcademica;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class DocentesxNucleoDAOHibernate extends HibernateDaoSupport implements DocentesxNucleoDAO {

	@Override
	public void guardarDocentesxNucleo(TbAdmDocentesxnucleo docentesxNucleo)
			throws ExcepcionesDAO {
		Session session = null;

		try {
			session = getSession();
			session.save(docentesxNucleo);
			session.flush(); 
		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		}
	}

	@Override
	public TbAdmDocentesxnucleo obtenerDocentesxNucleo(int id)
			throws ExcepcionesDAO {
		Session session = null;
		TbAdmDocentesxnucleo docentesxnucleo = null;

		try {
			session = getSession();
			docentesxnucleo = (TbAdmDocentesxnucleo) session.load(TbAdmDocentesxnucleo.class, id);

		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		}
		return docentesxnucleo;
	}

	@Override
	public List<TbAdmDocentesxnucleo> listarDocentesxNucleo()
			throws ExcepcionesDAO {
		Session session = null;
        List<TbAdmDocentesxnucleo> docentesxnucleo = new ArrayList<TbAdmDocentesxnucleo>();
        
		try {
			session = getSession();
			Criteria criteria = session.createCriteria(TbAdmDocentesxnucleo.class);
			
			docentesxnucleo = criteria.list();
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
			
		}
		return docentesxnucleo;
	}

	@Override
	public void actualizarDocentesxNucleo(TbAdmDocentesxnucleo docentesxNucleo)
			throws ExcepcionesDAO {
		Session session = null;

		try {
			session = getSession();
			this.getHibernateTemplate().update(docentesxNucleo);

		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		}
	}

}
