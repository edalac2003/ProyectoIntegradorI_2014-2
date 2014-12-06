package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.UnidadXMicroDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmPersona;
import com.udea.proint1.microcurriculo.dto.TbAdmUnidadAcademica;
import com.udea.proint1.microcurriculo.dto.TbMicMicrocurriculo;
import com.udea.proint1.microcurriculo.dto.TbMicUnidadxmicro;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class UnidadxMicroDAOHibernate extends HibernateDaoSupport implements UnidadXMicroDAO {

	public UnidadxMicroDAOHibernate() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void guardarUnidadXmicro(TbMicUnidadxmicro unidadXmicro) throws ExcepcionesDAO {
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
	public void modificarUnidadXmicro(TbMicUnidadxmicro unidadXmicro)
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
	public TbMicUnidadxmicro obtenerUnidadXmicro(int idUnidadxMicro) throws ExcepcionesDAO {
		TbMicUnidadxmicro unidadxMicro = null;
		Session session = null;
		
		try{
			session = getSession();
			unidadxMicro = (TbMicUnidadxmicro)session.get(TbMicUnidadxmicro.class, idUnidadxMicro);
			if (unidadxMicro != null)
				return unidadxMicro;
			else
				return null;
			
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
		}
	}

	@Override
	public List<TbMicUnidadxmicro> listarUnidadesXMicroxMicro(TbMicMicrocurriculo microcurriculo) throws ExcepcionesDAO {
		Session session = null;
        List<TbMicUnidadxmicro> unidadesXMicro = new ArrayList<TbMicUnidadxmicro>();
       
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
	public List<TbMicUnidadxmicro> listarUnidadesXmicro()
			throws ExcepcionesDAO {
		Session session = null;
        List<TbMicUnidadxmicro> unidadesXMicro = new ArrayList<TbMicUnidadxmicro>();
        
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
			Criteria criteria = session.createCriteria(TbMicUnidadxmicro.class);
			registro = criteria.list().size();
		}catch(HibernateException e){
			throw new ExcepcionesDAO("Se produjo un Error al Intentar contar los Registros de la Tabla Unidades x Microcurriculo. "+e);
		}
	
		return registro;
	}
	
	

}
