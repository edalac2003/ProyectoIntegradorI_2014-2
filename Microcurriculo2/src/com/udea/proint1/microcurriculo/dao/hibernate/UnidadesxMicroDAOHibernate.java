package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.UnidadesXMicroDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmPersona;
import com.udea.proint1.microcurriculo.dto.TbAdmUnidadAcademica;
import com.udea.proint1.microcurriculo.dto.TbMicMicrocurriculos;
import com.udea.proint1.microcurriculo.dto.TbMicUnidadesxmicro;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class UnidadesxMicroDAOHibernate extends HibernateDaoSupport implements UnidadesXMicroDAO {

	public UnidadesxMicroDAOHibernate() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void guardarUnidadXmicro(TbMicUnidadesxmicro unidadXmicro) throws ExcepcionesDAO {
		Session session = null;

		try {
			session = getSession();
			session.save(unidadXmicro);
			session.flush(); 
		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		}	
	}
	
	@Override
	public void modificarUnidadXmicro(TbMicUnidadesxmicro unidadXmicro)
			throws ExcepcionesDAO {
		Session session = null;

		try {
			session = getSession();
			this.getHibernateTemplate().update(unidadXmicro);

		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		}
	}

	@Override
	public TbMicUnidadesxmicro obtenerUnidadXmicro(int idUnidadxMicro) throws ExcepcionesDAO {
		TbMicUnidadesxmicro unidadxMicro = null;
		Session session = null;
		
		try{
			session = getSession();
			unidadxMicro = (TbMicUnidadesxmicro)session.get(TbMicUnidadesxmicro.class, idUnidadxMicro);
			if (unidadxMicro != null)
				return unidadxMicro;
			else
				return null;
			
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
		}
	}

	@Override
	public List<TbMicUnidadesxmicro> listarUnidadesXMicroxMicro(TbMicMicrocurriculos microcurriculo) throws ExcepcionesDAO {
		Session session = null;
        List<TbMicUnidadesxmicro> unidadesXMicro = new ArrayList<TbMicUnidadesxmicro>();
       
        try{
               
        	session = getSession();
                               
        	Query query = session.createQuery("from TbMicUnidadesxmicro where tbMicMicrocurriculos = :microcurriculo");
               
        	query.setEntity("microcurriculo", microcurriculo);
               
        	unidadesXMicro = query.list();
        }catch(HibernateException e){
                throw new ExcepcionesDAO(e);
        }
        return unidadesXMicro;
	}

	@Override
	public List<TbMicUnidadesxmicro> listarUnidadesXmicro()
			throws ExcepcionesDAO {
		Session session = null;
        List<TbMicUnidadesxmicro> unidadesXMicro = new ArrayList<TbMicUnidadesxmicro>();
        
		try {
			session = getSession();
			Criteria criteria = session.createCriteria(TbAdmUnidadAcademica.class);
			
			unidadesXMicro = criteria.list();
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
			
		}
		return unidadesXMicro;
	}

	@Override
	public int contarRegistros() throws ExcepcionesDAO {
		int registro = 0;
		Session session = null;
		
		try{
			session = getSession();
			Criteria criteria = session.createCriteria(TbMicUnidadesxmicro.class);
			registro = criteria.list().size();
		}catch(HibernateException e){
			throw new ExcepcionesDAO("Se produjo un Error al Intentar contar los Registros de la Tabla Unidades x Microcurriculo. "+e);
		}
	
		return registro;
	}
	
	

}
