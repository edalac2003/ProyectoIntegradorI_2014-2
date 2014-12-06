package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.ObservacionxMicroDAO;
import com.udea.proint1.microcurriculo.dto.TbMicObservacionxmicro;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class ObservacionxMicroDAOHibernate extends HibernateDaoSupport implements ObservacionxMicroDAO {

	@Override
	public void guardarObservacionxMicro(
			TbMicObservacionxmicro observacionxMicro) throws ExcepcionesDAO {
		Session session = null;

		try {
			session = getSession();
			session.save(observacionxMicro);
			session.flush(); 
		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		}
	}

	@Override
	public TbMicObservacionxmicro obtenerObservacionxMicro(int id)
			throws ExcepcionesDAO {
		Session session = null;
		TbMicObservacionxmicro observacionxmicro = null;

		try {
			session = getSession();
			observacionxmicro = (TbMicObservacionxmicro) session.load(TbMicObservacionxmicro.class, id);

		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		}
		return observacionxmicro;
	}

	@Override
	public List<TbMicObservacionxmicro> listarObservacionxMicro()
			throws ExcepcionesDAO {
		Session session = null;
        List<TbMicObservacionxmicro> observacionxmicro = new ArrayList<TbMicObservacionxmicro>();
        
		try {
			session = getSession();
			Criteria criteria = session.createCriteria(TbMicObservacionxmicro.class);
			
			observacionxmicro = criteria.list();
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
			
		}
		return observacionxmicro;
	}

	@Override
	public void actualizarObservacionxMicro(
			TbMicObservacionxmicro observacionxMicro) throws ExcepcionesDAO {
		Session session = null;

		try {
			session = getSession();
			this.getHibernateTemplate().update(observacionxMicro);

		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		}
	}

}
