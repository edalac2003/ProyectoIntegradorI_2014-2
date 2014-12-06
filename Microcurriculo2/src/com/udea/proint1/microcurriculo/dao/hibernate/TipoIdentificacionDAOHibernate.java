package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.TipoIdentificacionDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmTipoidentificacion;
import com.udea.proint1.microcurriculo.dto.TbAdmTipopersona;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class TipoIdentificacionDAOHibernate extends HibernateDaoSupport implements TipoIdentificacionDAO {

	@Override
	public void guardarTipoIdentificacion(
			TbAdmTipoidentificacion tipoIdentificacion) throws ExcepcionesDAO {
		Session session = null;

		try {
			session = getSession();
			session.save(tipoIdentificacion);
			session.flush(); 
		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		}
	}

	@Override
	public TbAdmTipoidentificacion obtenerTipoIdentificacion(int id)
			throws ExcepcionesDAO {
		Session session = null;
		TbAdmTipoidentificacion tipoIdentificacion = null;
		
		try{
			session = getSession();
			tipoIdentificacion = (TbAdmTipoidentificacion)session.load(TbAdmTipoidentificacion.class, id);
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
		}
		return tipoIdentificacion;
	}

	@Override
	public List<TbAdmTipoidentificacion> listarTipoIdentificacion()
			throws ExcepcionesDAO {
		Session session = null;
		List<TbAdmTipoidentificacion> listaTipoIdentificacion = new ArrayList<TbAdmTipoidentificacion>();
		
		try{
			session = getSession();
			
			Criteria criteria = session.createCriteria(TbAdmTipoidentificacion.class);
			
			listaTipoIdentificacion = criteria.list();
			
		}catch(HibernateException e){
			throw new ExcepcionesDAO();
		}
		
		return listaTipoIdentificacion;
	}

	@Override
	public void actualizarTipoIdentificacion(
			TbAdmTipoidentificacion tipoIdentificacion) throws ExcepcionesDAO {
		Session session = null;

		try {
			session = getSession();
			this.getHibernateTemplate().update(tipoIdentificacion);

		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		}
	}

}
