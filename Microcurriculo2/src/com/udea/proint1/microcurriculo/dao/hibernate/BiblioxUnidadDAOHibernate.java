package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.BiblioxUnidadDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmPersona;
import com.udea.proint1.microcurriculo.dto.TbAdmUnidadAcademica;
import com.udea.proint1.microcurriculo.dto.TbMicBiblioxunidad;
import com.udea.proint1.microcurriculo.dto.TbMicUnidades;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class BiblioxUnidadDAOHibernate extends HibernateDaoSupport implements BiblioxUnidadDAO {

	public BiblioxUnidadDAOHibernate() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void guardarBiblioxUnidad(TbMicBiblioxunidad biblioxUnidad)
			throws ExcepcionesDAO {
		Session session = null;

		try {
			session = getSession();
			session.save(biblioxUnidad);
			session.flush(); 
		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		}
	}

	@Override
	public void modificarBiblioxUnidad(TbMicBiblioxunidad biblioxUnidad)
			throws ExcepcionesDAO {
		Session session = null;

		try {
			session = getSession();
			this.getHibernateTemplate().update(biblioxUnidad);

		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		}
	}

	@Override
	public TbMicBiblioxunidad obtenerBiblioxUnidad(int id) throws ExcepcionesDAO {
		Session session = null;
		TbMicBiblioxunidad BiblioxUnidad = null;

		try {
			session = getSession();
			BiblioxUnidad = (TbMicBiblioxunidad) session.load(TbMicBiblioxunidad.class, id);

		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		}
		return BiblioxUnidad;
	}

	@Override
	public List<TbMicBiblioxunidad> listadoBiblioxUnidad()
			throws ExcepcionesDAO {
		Session session = null;
        List<TbMicBiblioxunidad> BibliosxUnidad = new ArrayList<TbMicBiblioxunidad>();
        
		try {
			session = getSession();
			Criteria criteria = session.createCriteria(TbMicBiblioxunidad.class);
			
			BibliosxUnidad = criteria.list();
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
			
		}
		return BibliosxUnidad;
	}

	@Override
	public List<TbMicBiblioxunidad> listadoBiblioxUnidad(TbMicUnidades unidad)
			throws ExcepcionesDAO {
		Session session = null;
        List<TbMicBiblioxunidad> bibliosxUnidad = new ArrayList<TbMicBiblioxunidad>();
       
        try{
               
        	session = getSession();
                               
        	Query query = session.createQuery("from TbMicBiblioxunidad where tbMicUnidades = :unidad");
               
        	query.setEntity("unidad", unidad);
               
        	bibliosxUnidad = query.list();
        }catch(HibernateException e){
                throw new ExcepcionesDAO(e);
        }
        return bibliosxUnidad;
	}

	@Override
	public int contarRegistros() throws ExcepcionesDAO {
		int registro = 0;
		Session session = null;
		
		try{
			session = getSession();
			Criteria criteria = session.createCriteria(TbMicBiblioxunidad.class);
			
			registro = criteria.list().size();
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
		}	
		
		return registro;
	}

}
