package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.PrerrequisitosDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmCorrequisitos;
import com.udea.proint1.microcurriculo.dto.TbAdmMaterias;
import com.udea.proint1.microcurriculo.dto.TbAdmPrerrequisitos;
import com.udea.proint1.microcurriculo.dto.TbAdmUnidadAcademica;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class PrerrequisitosDAOHibernate extends HibernateDaoSupport implements PrerrequisitosDAO {

	public PrerrequisitosDAOHibernate() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<TbAdmPrerrequisitos> listarPrerrequisitosxMateria(TbAdmMaterias materia) throws ExcepcionesDAO {
		Session session = null;
        List<TbAdmPrerrequisitos> prerrequisitos = new ArrayList<TbAdmPrerrequisitos>();
       
        try{
               
                session = getSession();	
                               
                Query query = session.createQuery("from TbAdmPrerrequisitos where tbAdmMateriasByVrMateria = :materia");
               
                query.setEntity("materia", materia);
               
                prerrequisitos = query.list();
                
        }catch(HibernateException e){
                throw new ExcepcionesDAO(e);
        }
        return prerrequisitos;
	}

	@Override
	public List<TbAdmPrerrequisitos> listarPrerrequisitos()
			throws ExcepcionesDAO {
		Session session = null;
        List<TbAdmPrerrequisitos> prerrequisitos = new ArrayList<TbAdmPrerrequisitos>();
        
		try {
			session = getSession();
			Criteria criteria = session.createCriteria(TbAdmPrerrequisitos.class);
			
			prerrequisitos = criteria.list();
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
			
		}
		return prerrequisitos;
	}

	@Override
	public TbAdmPrerrequisitos obtenerPrerrequisito(int id) throws ExcepcionesDAO {
		Session session = null;
		TbAdmPrerrequisitos prerrequisito = null;

		try {
			session = getSession();
			prerrequisito = (TbAdmPrerrequisitos) session.load(TbAdmPrerrequisitos.class, id);

		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		}
		return prerrequisito;
	}

	@Override
	public void guardarPrerrequisito(TbAdmPrerrequisitos prerrequisito)
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
	public void actualizarPrerrequisito(TbAdmPrerrequisitos prerrequisito)
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
