package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.MateriasxPensumDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmUnidadAcademica;
import com.udea.proint1.microcurriculo.dto.TbMicMateriasxpensum;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class MateriasxPensumDAOHibernate extends HibernateDaoSupport implements MateriasxPensumDAO {

	@Override
	public void guardarMateriasxPensum(TbMicMateriasxpensum materiasxPensum)
			throws ExcepcionesDAO {
		Session session = null;

		try {
			session = getSession();
			session.save(materiasxPensum);
			session.flush(); 
		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		}
	}

	@Override
	public TbMicMateriasxpensum obtenerMateriasxPensum(int id)
			throws ExcepcionesDAO {
		Session session = null;
		TbMicMateriasxpensum materiasxPensum = null;

		try {
			session = getSession();
			materiasxPensum = (TbMicMateriasxpensum) session.load(TbMicMateriasxpensum.class, id);

		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		}
		return materiasxPensum;
	}

	@Override
	public List<TbMicMateriasxpensum> listarMateriasxPensum()
			throws ExcepcionesDAO {
		Session session = null;
        List<TbMicMateriasxpensum> materiasxPensum = new ArrayList<TbMicMateriasxpensum>();
        
		try {
			session = getSession();
			Criteria criteria = session.createCriteria(TbMicMateriasxpensum.class);
			
			materiasxPensum = criteria.list();
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
			
		}
		return materiasxPensum;
	}

	@Override
	public void actualizarMateriasxPensum(TbMicMateriasxpensum materiasxPensum)
			throws ExcepcionesDAO {
		Session session = null;

		try {
			session = getSession();
			this.getHibernateTemplate().update(materiasxPensum);

		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		}
	}

}
