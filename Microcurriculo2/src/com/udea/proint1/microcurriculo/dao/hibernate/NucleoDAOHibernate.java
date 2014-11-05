package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.NucleoDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmNucleo;
import com.udea.proint1.microcurriculo.dto.TbMicMicrocurriculos;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class NucleoDAOHibernate extends HibernateDaoSupport implements NucleoDAO {

	public NucleoDAOHibernate() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void guardarNucleo(TbAdmNucleo nucleo) throws ExcepcionesDAO {
		Session session = null;

		try {
			session = getSession();
			session.save(nucleo);
			session.flush(); 
		} catch (HibernateException e) {

		}
	}

	@Override
	public void actualizarNucleo(TbAdmNucleo nucleo) throws ExcepcionesDAO {
		Session session = null;

		try {
			session = getSession();
			this.getHibernateTemplate().update(nucleo);

		} catch (HibernateException e) {
			throw new ExcepcionesDAO();
		}
	}

	@Override
	public TbAdmNucleo obtenerNucleo(String id) throws ExcepcionesDAO {
		Session session = null;
		TbAdmNucleo nucleo = null;

		try {
			session = getSession();
			nucleo = (TbAdmNucleo) session.load(TbAdmNucleo.class, id);

		} catch (HibernateException e) {
			throw new ExcepcionesDAO();
		}
		return nucleo;
	}

	@Override
	public List<TbAdmNucleo> listarNucleos() throws ExcepcionesDAO {
		Session session = null;
		List<TbAdmNucleo> nucleos = new ArrayList<TbAdmNucleo>();

		try {
			session = getSession();
			Criteria criteria = session.createCriteria(TbAdmNucleo.class);
			nucleos = criteria.list();
		} catch (HibernateException e) {
			throw new ExcepcionesDAO();
		}

		return nucleos;
	}

}
