package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.DependenciaDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmDependencia;
import com.udea.proint1.microcurriculo.dto.TbAdmMateria;
import com.udea.proint1.microcurriculo.dto.TbAdmUnidadAcademica;
import com.udea.proint1.microcurriculo.dto.TbMicMicrocurriculo;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class DependenciaDAOHibernate extends HibernateDaoSupport implements DependenciaDAO {

	@Override
	public void guardarDependencia(TbAdmDependencia dependencias)
			throws ExcepcionesDAO {
		Session session = null;

		try {
			session = getSession();
			session.save(dependencias);
			session.flush(); 
		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		} finally{
			session.close();
		}
	}

	@Override
	public TbAdmDependencia obtenerDependencias(String id)
			throws ExcepcionesDAO {
		Session session = null;
		TbAdmDependencia dependencia = null;
		
		try{
			session = getSession();
			dependencia = (TbAdmDependencia)session.get(TbAdmDependencia.class, id);
			
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
		} finally{
			session.close();
		}
		return dependencia;
	}

	

	@Override
	public void actualizarDependencias(TbAdmDependencia dependencias) throws ExcepcionesDAO {
		Session session = null;
		
		try{
			session = getSession();
			this.getHibernateTemplate().update(dependencias);
			
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
		} finally{
			session.close();
		}
		
	}

	
	@Override
	public List<TbAdmDependencia> listarDependencias() throws ExcepcionesDAO {
		Session session = null;
		List<TbAdmDependencia> dependencia = new ArrayList<TbAdmDependencia>();
		
		try{
			session = getSession();
			Criteria criteria = session.createCriteria(TbAdmDependencia.class);
			dependencia = criteria.list();
			
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
		} finally{
			session.close();
		}
		
		return dependencia;
	}
	
	@Override
	public List<TbAdmDependencia> listarDependenciasPorUnidad(String unidad) throws ExcepcionesDAO {
		Session session = null;
        List<TbAdmDependencia> dependencias = new ArrayList<TbAdmDependencia>();        
        try{               
            session = getSession();	
            Query query = session.createQuery("from TbAdmDependencia where tbAdmUnidadAcademica  like :unidad");
            query.setString("unidad", unidad);               
            dependencias = query.list();                
        }catch(HibernateException e){
            throw new ExcepcionesDAO("DAO: Se presentaron errores al intentar Listar las Dependencias por Unidad. "+e);
        } finally{
			session.close();
		}
        return dependencias;
	}
	
	
	
	@Override
	public List<TbAdmDependencia> listarDependenciasPorUnidad(TbAdmUnidadAcademica unidad) throws ExcepcionesDAO {
		List<TbAdmDependencia> listaDependencias = null;
		Session session = null;
		try {
			session = getSession();
			Query query = session.createQuery("from TbAdmDependencia where tbAdmUnidadAcademica = :unidad");
			query.setEntity("unidad", unidad);
			listaDependencias = query.list();
		} catch (HibernateException e) {
			throw new ExcepcionesDAO("Se presentaron problemas al intentar obtener listado de Dependencias por Unidad.");
		} finally {
			session.close();
		}
				
		return listaDependencias;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TbAdmDependencia> buscarDependencias(String buscar) throws ExcepcionesDAO{
		Session session = null;
        List<TbAdmDependencia> dependencias = new ArrayList<TbAdmDependencia>();
        try{               
            session = getSession();           
        	Query query = session.createQuery("from TbAdmDependencia where vrIddependencia  like :dependencia");
        	query.setString("dependencia", buscar);               
            dependencias = query.list();
        }catch(HibernateException e){
            throw new ExcepcionesDAO(e);
        } finally{
			session.close();
		}
        return dependencias;
	}
}
