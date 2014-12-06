package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.CiudadDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmCiudad;
import com.udea.proint1.microcurriculo.dto.TbMicMicrocurriculo;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class CiudadDAOHibernate extends HibernateDaoSupport implements CiudadDAO {

	public CiudadDAOHibernate() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public TbAdmCiudad obtenerCiudad(int idCiudad) throws ExcepcionesDAO {
		Session session = null;
		TbAdmCiudad ciudad = null;
		
		try{
			session = getSession();
			ciudad = (TbAdmCiudad)session.load(TbAdmCiudad.class, idCiudad);
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
		}
			
		return ciudad;
	}

	@Override
	public List<TbAdmCiudad> listarCiudades() throws ExcepcionesDAO {
		Session session = null;
		List<TbAdmCiudad> ciudades = new ArrayList<TbAdmCiudad>();
		
		try{
			session = getSession();
			
			Criteria criteria = session.createCriteria(TbMicMicrocurriculo.class);
			
			ciudades = criteria.list();
			
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
		}
		
		return ciudades;
	}

}
