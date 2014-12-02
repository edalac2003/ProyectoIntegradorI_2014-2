package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.TemasXUnidadDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmPersona;
import com.udea.proint1.microcurriculo.dto.TbMicTemasxunidad;
import com.udea.proint1.microcurriculo.dto.TbMicUnidades;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class TemasxUnidadDAOHibernate extends HibernateDaoSupport implements TemasXUnidadDAO {

	public TemasxUnidadDAOHibernate() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void guardarTemasXUnidad(TbMicTemasxunidad temaXunidad)	throws ExcepcionesDAO {
		Session session = null;

		try {
			session = getSession();
			session.save(temaXunidad);
			session.flush(); 
		} catch (HibernateException e) {

		}
	}

	@Override
	public void modificarTemasXUnidad(TbMicTemasxunidad temaXunidad)
			throws ExcepcionesDAO {
		Session session = null;

		try {
			session = getSession();
			this.getHibernateTemplate().update(temaXunidad);

		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		}
	}
	
	@Override
	public TbMicTemasxunidad obtenerTemaXunidad(int idTemaxUnidad)	throws ExcepcionesDAO {
		TbMicTemasxunidad temaxUnidad = null;
		Session session = null;
		
		try{
			session = getSession();
			temaxUnidad = (TbMicTemasxunidad)session.get(TbMicTemasxunidad.class, idTemaxUnidad);
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
		}		
		
		return temaxUnidad;
	}

	@Override
	public List<TbMicTemasxunidad> ListarTemasxUnidadxUnidad(TbMicUnidades unidad)
			throws ExcepcionesDAO {
		Session session = null;
        List<TbMicTemasxunidad> temasxUnidad = new ArrayList<TbMicTemasxunidad>();
       
        try{
               
        	session = getSession();
                               
        	Query query = session.createQuery("from TbMicTemasxunidad where tbMicUnidades = :unidad");
               
        	query.setEntity("unidad", unidad);
               
        	temasxUnidad = query.list();
        }catch(HibernateException e){
                throw new ExcepcionesDAO(e);
        }
        return temasxUnidad;
	}

	@Override
	public List<TbMicTemasxunidad> ListarTemasXunidad()
			throws ExcepcionesDAO {
		Session session = null;
		List<TbMicTemasxunidad> temasxUnidad = new ArrayList<TbMicTemasxunidad>();
		try {
			session = getSession();
			Criteria criteria = session.createCriteria(TbAdmPersona.class);
			
			temasxUnidad = criteria.list();
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
		}
		
		return temasxUnidad;
	}

	@Override
	public int contarRegistros() throws ExcepcionesDAO {
		int registro = 0;
		Session session = null;
		
		try{
			session = getSession();
			Criteria criteria = session.createCriteria(TbMicTemasxunidad.class);
			registro = criteria.list().size();
		}catch(HibernateException e){
			throw new ExcepcionesDAO("DAO : Error al intentar recuperar el Numero de Registros de la Tabla Temas por Unidad. "+e);
		}
		
		return registro;
	}
	
	

}
