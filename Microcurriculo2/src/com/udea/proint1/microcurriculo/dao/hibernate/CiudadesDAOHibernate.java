package com.udea.proint1.microcurriculo.dao.hibernate;

import mapeos.Ciudades;
import mapeos.Paises;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.CiudadesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class CiudadesDAOHibernate extends HibernateDaoSupport implements CiudadesDAO {

	public CiudadesDAOHibernate() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Ciudades obtenerCiudad(int idCiudad) throws ExcepcionesDAO {
		Session session = null;
		Ciudades ciudad = null;
		
		try{
			session = getSession();
			ciudad = (Ciudades)session.get(Ciudades.class, idCiudad);
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
		}
			
		return ciudad;
	}

}
