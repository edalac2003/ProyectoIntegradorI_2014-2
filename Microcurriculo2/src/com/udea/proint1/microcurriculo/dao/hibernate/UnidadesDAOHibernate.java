package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.UnidadesDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmTipopersona;
import com.udea.proint1.microcurriculo.dto.TbMicUnidades;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class UnidadesDAOHibernate extends HibernateDaoSupport implements UnidadesDAO {

	@Override
	public void guardarUnidad(TbMicUnidades unidad) throws ExcepcionesDAO {
		Session session = null;

		try {
			session = getSession();
			session.save(unidad);
			session.flush(); 
		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		}
	}
	
	@Override
	public TbMicUnidades obtenerUnidad(int idUnidad) throws ExcepcionesDAO {
		Session session = null;
		TbMicUnidades unidad = null;
		
		try{
			session = getSession();
			unidad = (TbMicUnidades)session.get(TbMicUnidades.class, idUnidad);
			
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
		}
		
		return unidad;
	}

	
	@Override
	public void modificarUnidad(TbMicUnidades unidad) throws ExcepcionesDAO {
		Session session = null;

		try {
			session = getSession();
			this.getHibernateTemplate().update(unidad);

		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		}
	}

	@Override
	public int numeroRegistros() throws ExcepcionesDAO {
		Session session = null;
		int registro = 0;
		try {
			session = getSession();
			Criteria criteria = session.createCriteria(UnidadesDAOHibernate.class);
			registro = criteria.list().size();			
		} catch(HibernateException e){
			throw new ExcepcionesDAO("No Devolvió Ningun Numero de Registro "+e);
		}		
		return registro;
	}
	
	@Override
	public List<TbMicUnidades> listarUnidades() throws ExcepcionesDAO{
		Session session = null;
		List<TbMicUnidades> unidades = new ArrayList<TbMicUnidades>();
		
		try{
			session = getSession();
			
			Criteria criteria = session.createCriteria(TbMicUnidades.class);
			
			unidades = criteria.list();
			
		}catch(HibernateException e){
			throw new ExcepcionesDAO();
		}
		
		return unidades;
	}

}
