package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.ObjetivosDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmPersona;
import com.udea.proint1.microcurriculo.dto.TbMicMicrocurriculos;
import com.udea.proint1.microcurriculo.dto.TbMicObjetivos;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class ObjetivosDAOHibernate extends HibernateDaoSupport implements ObjetivosDAO {

	public ObjetivosDAOHibernate() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void guardarObjetivo(TbMicObjetivos objetivo) throws ExcepcionesDAO {
		Session session = null;

		try {
			session = getSession();
			session.save(objetivo);
			session.flush(); 
		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		}
	}

	@Override
	public TbMicObjetivos obtenerObjetivo(int idObjetivo) throws ExcepcionesDAO {
		Session session = null;
		TbMicObjetivos objetivo = null;
		
		try{
			session = getSession();
			objetivo = (TbMicObjetivos)session.get(TbMicObjetivos.class, idObjetivo);
			
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
		}
		return objetivo;
	}

	@Override
	public int numeroRegistros() throws ExcepcionesDAO {
		Session session = null;
		int registro = 0;
			
		try{
			session = getSession();
			Criteria criteria = session.createCriteria(TbMicObjetivos.class);
			registro = criteria.list().size();
			
		} catch(HibernateException e){
			throw new ExcepcionesDAO(e);
		}
		
		return registro;
	}
	
	@Override
	public List<TbMicObjetivos> listarObjetivosPorMicrocurriculo(
			TbMicMicrocurriculos microcurriculo) throws ExcepcionesDAO {
		Session session = null;
        List<TbMicObjetivos> objetivos = new ArrayList<TbMicObjetivos>();
       
        try{
               
        	session = getSession();
                               
        	Query query = session.createQuery("from TbMicObjetivos where tbMicMicrocurriculos = :microcurriculo");
               
        	query.setEntity("microcurriculo", microcurriculo);
               
        	objetivos = query.list();
        }catch(HibernateException e){
                throw new ExcepcionesDAO(e);
        }
        return objetivos;
	}

	@Override
	public List<TbMicObjetivos> listarObjetivosPorTipo(char tipo) throws ExcepcionesDAO {
		Session session = null;
        List<TbMicObjetivos> objetivos = new ArrayList<TbMicObjetivos>();
       
        try{
               
        	session = getSession();
                               
        	Query query = session.createQuery("from TbMicObjetivos where blTipo = :tipo");
               
        	query.setCharacter("tipo", tipo);
               
        	objetivos = query.list();
        }catch(HibernateException e){
                throw new ExcepcionesDAO(e);
        }
        return objetivos;
	}
	
	@Override
	public List<TbMicObjetivos> listarObjetivos() throws ExcepcionesDAO{
		Session session = null;
		List<TbMicObjetivos> objetivos = new ArrayList<TbMicObjetivos>();
		try {
			session = getSession();
			Criteria criteria = session.createCriteria(TbMicObjetivos.class);
			
			objetivos = criteria.list();
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
		}
		
		return objetivos;
	}

	@Override
	public void modificarObjetivo(TbMicObjetivos objetivo) throws ExcepcionesDAO {
		Session session = null;
		Transaction tx = null;
		
		try{
			session = getSession();
			tx = session.beginTransaction();
			session.update(objetivo);
			tx.commit();
			
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
		}
	}

}
