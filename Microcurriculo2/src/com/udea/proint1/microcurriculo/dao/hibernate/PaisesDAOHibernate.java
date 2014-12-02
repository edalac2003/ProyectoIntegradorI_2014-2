package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.PaisesDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmCiudades;
import com.udea.proint1.microcurriculo.dto.TbAdmPaises;
import com.udea.proint1.microcurriculo.dto.TbMicMicrocurriculos;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class PaisesDAOHibernate extends HibernateDaoSupport implements PaisesDAO{

	@Override
	public TbAdmPaises obtenerPais(int idPais) throws ExcepcionesDAO {
		Session session = null;
		TbAdmPaises pais = null;
		
		try{
			session = getSession();
			pais = (TbAdmPaises)session.get(TbAdmPaises.class, idPais);
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
		}
			
		return pais;
	}

	@Override
	public List<TbAdmPaises> listarPaises() throws ExcepcionesDAO {
		Session session = null;
		List<TbAdmPaises> paises = new ArrayList<TbAdmPaises>();
		
		try{
			session = getSession();
			Criteria criteria = session.createCriteria(TbAdmPaises.class);
			paises = criteria.list();			
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
		}
		
		return paises;
	}

}
