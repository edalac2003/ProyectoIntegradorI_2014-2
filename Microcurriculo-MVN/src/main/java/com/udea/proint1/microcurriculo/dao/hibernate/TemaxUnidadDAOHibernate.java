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

import com.udea.proint1.microcurriculo.dao.TemaxUnidadDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmPersona;
import com.udea.proint1.microcurriculo.dto.TbMicTemaxunidad;
import com.udea.proint1.microcurriculo.dto.TbMicUnidad;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class TemaxUnidadDAOHibernate extends HibernateDaoSupport implements TemaxUnidadDAO {

	public TemaxUnidadDAOHibernate() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void guardarTemasXUnidad(TbMicTemaxunidad temaXunidad)	throws ExcepcionesDAO {
		Session session = null;

		try {
			session = getSession();
			session.save(temaXunidad);
			session.flush(); 
		} catch (HibernateException e) {

		}
	}

	@Override
	public void modificarTemasXUnidad(TbMicTemaxunidad temaXunidad)
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
	public TbMicTemaxunidad obtenerTemaXunidad(int idTemaxUnidad)	throws ExcepcionesDAO {
		TbMicTemaxunidad temaxUnidad = null;
		Session session = null;
		
		try{
			session = getSession();
			temaxUnidad = (TbMicTemaxunidad)session.get(TbMicTemaxunidad.class, idTemaxUnidad);
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
		}		
		
		return temaxUnidad;
	}

	@Override
	public List<TbMicTemaxunidad> ListarTemasxUnidadxUnidad(TbMicUnidad unidad)
			throws ExcepcionesDAO {
		Session session = null;
        List<TbMicTemaxunidad> temasxUnidad = new ArrayList<TbMicTemaxunidad>();
       
        try{
               
        	session = getSession();
                               
        	Query query = session.createQuery("from TbMicTemaxunidad where tbMicUnidad = :unidad");
               
        	query.setEntity("unidad", unidad);
               
        	temasxUnidad = query.list();
        }catch(HibernateException e){
                throw new ExcepcionesDAO(e);
        }
        return temasxUnidad;
	}

	@Override
	public List<TbMicTemaxunidad> ListarTemasXunidad()
			throws ExcepcionesDAO {
		Session session = null;
		List<TbMicTemaxunidad> temasxUnidad = new ArrayList<TbMicTemaxunidad>();
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
			Criteria criteria = session.createCriteria(TbMicTemaxunidad.class);
			registro = criteria.list().size();
		}catch(HibernateException e){
			throw new ExcepcionesDAO("DAO : Se presentaron problemas al intentar recuperar el Numero de Registros de la Tabla <TB_MIC_TEMAXUNIDAD>. "+e);
		}
		
		return registro;
	}
	
	

}
