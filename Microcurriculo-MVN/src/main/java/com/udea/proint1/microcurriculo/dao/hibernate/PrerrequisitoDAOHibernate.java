package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.PrerrequisitoDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmCorrequisito;
import com.udea.proint1.microcurriculo.dto.TbAdmMateria;
import com.udea.proint1.microcurriculo.dto.TbAdmPrerrequisito;
import com.udea.proint1.microcurriculo.dto.TbAdmUnidadAcademica;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class PrerrequisitoDAOHibernate extends HibernateDaoSupport implements PrerrequisitoDAO {

	public PrerrequisitoDAOHibernate() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<TbAdmPrerrequisito> listarPrerrequisitosxMateria(TbAdmMateria materia) throws ExcepcionesDAO {
		Session session = null;
        List<TbAdmPrerrequisito> prerrequisitos = new ArrayList<TbAdmPrerrequisito>();
       
        try{
               
                session = getSession();	
                               
                Query query = session.createQuery("from TbAdmPrerrequisito where tbAdmMateriasByVrMateria = :materia");
               
                query.setEntity("materia", materia);
               
                prerrequisitos = query.list();
                
        }catch(HibernateException e){
                throw new ExcepcionesDAO(e);
        }
        return prerrequisitos;
	}

	@Override
	public List<TbAdmPrerrequisito> listarPrerrequisitos()
			throws ExcepcionesDAO {
		Session session = null;
        List<TbAdmPrerrequisito> prerrequisitos = new ArrayList<TbAdmPrerrequisito>();
        
		try {
			session = getSession();
			Criteria criteria = session.createCriteria(TbAdmPrerrequisito.class);
			
			prerrequisitos = criteria.list();
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
			
		}
		return prerrequisitos;
	}

	@Override
	public TbAdmPrerrequisito obtenerPrerrequisito(int id) throws ExcepcionesDAO {
		Session session = null;
		TbAdmPrerrequisito prerrequisito = null;

		try {
			session = getSession();
			prerrequisito = (TbAdmPrerrequisito) session.load(TbAdmPrerrequisito.class, id);

		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		}
		return prerrequisito;
	}

	@Override
	public void guardarPrerrequisito(TbAdmPrerrequisito prerrequisito)
			throws ExcepcionesDAO {
		Session session = null;

		try {
			session = getSession();
			session.save(prerrequisito);
			session.flush(); 
		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		}
	}

	@Override
	public void actualizarPrerrequisito(TbAdmPrerrequisito prerrequisito)
			throws ExcepcionesDAO {
		Session session = null;

		try {
			session = getSession();
			this.getHibernateTemplate().update(prerrequisito);

		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		}
	}

}
