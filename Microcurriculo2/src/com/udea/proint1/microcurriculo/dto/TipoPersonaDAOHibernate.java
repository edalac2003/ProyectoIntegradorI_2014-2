package com.udea.proint1.microcurriculo.dto;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.TipoPersonaDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class TipoPersonaDAOHibernate extends HibernateDaoSupport implements TipoPersonaDAO {

	@Override
	public TbAdmTipopersona obtenerTipoPersona(int id) throws ExcepcionesDAO {
		Session session = null;
		TbAdmTipopersona tipoPersona = null;

		try {
			session = getSession();
			tipoPersona = (TbAdmTipopersona) session.load(TbAdmTipopersona.class, id);

		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		}
		return tipoPersona;
	}

	@Override
	public List<TbAdmTipopersona> listarTipoPersonas() throws ExcepcionesDAO {
		Session session = null;
        List<TbAdmTipopersona> tiposPersona = new ArrayList<TbAdmTipopersona>();
        
		try {
			session = getSession();
			Criteria criteria = session.createCriteria(TbAdmTipopersona.class);
			
			tiposPersona = criteria.list();
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
			
		}
		return tiposPersona;
	}

}
