package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.CiudadesDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmCiudades;
import com.udea.proint1.microcurriculo.dto.TbMicMicrocurriculos;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class CiudadesDAOHibernate extends HibernateDaoSupport implements CiudadesDAO {

	public CiudadesDAOHibernate() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public TbAdmCiudades obtenerCiudad(int idCiudad) throws ExcepcionesDAO {
		Session session = null;
		TbAdmCiudades ciudad = null;
		
		try{
			session = getSession();
			ciudad = (TbAdmCiudades)session.get(TbAdmCiudades.class, idCiudad);
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
		}
			
		return ciudad;
	}

	@Override
	public List<TbAdmCiudades> listarCiudades() throws ExcepcionesDAO {
		Session session = null;
		List<TbAdmCiudades> ciudades = new ArrayList<TbAdmCiudades>();
		
		try{
			session = getSession();
			
			Criteria criteria = session.createCriteria(TbMicMicrocurriculos.class);
			
			ciudades = criteria.list();
			
		}catch(HibernateException e){
			throw new ExcepcionesDAO();
		}
		
		return ciudades;
	}

}
