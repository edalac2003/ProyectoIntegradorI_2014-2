package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.ObjetivoDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmPersona;
import com.udea.proint1.microcurriculo.dto.TbMicMicrocurriculo;
import com.udea.proint1.microcurriculo.dto.TbMicObjetivo;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class ObjetivoDAOHibernate extends HibernateDaoSupport implements ObjetivoDAO {

	public ObjetivoDAOHibernate() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void guardarObjetivo(TbMicObjetivo objetivo) throws ExcepcionesDAO {
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
	public TbMicObjetivo obtenerObjetivo(int idObjetivo) throws ExcepcionesDAO {
		Session session = null;
		TbMicObjetivo objetivo = null;
		
		try{
			session = getSession();
			objetivo = (TbMicObjetivo)session.get(TbMicObjetivo.class, idObjetivo);			
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
			Criteria criteria = session.createCriteria(TbMicObjetivo.class);
			registro = criteria.list().size();			
		} catch(HibernateException e){
			throw new ExcepcionesDAO(e);
		}		
		return registro;
	}
	
	@Override
	public List<TbMicObjetivo> listarObjetivosPorMicrocurriculo(
			TbMicMicrocurriculo microcurriculo) throws ExcepcionesDAO {
		Session session = null;
        List<TbMicObjetivo> objetivos = new ArrayList<TbMicObjetivo>();
       
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
	public List<TbMicObjetivo> listarObjetivosPorTipo(char tipo) throws ExcepcionesDAO {
		Session session = null;
        List<TbMicObjetivo> objetivos = new ArrayList<TbMicObjetivo>();
       
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
	public List<TbMicObjetivo> listarObjetivos() throws ExcepcionesDAO{
		Session session = null;
		List<TbMicObjetivo> objetivos = new ArrayList<TbMicObjetivo>();
		try {
			session = getSession();
			Criteria criteria = session.createCriteria(TbMicObjetivo.class);			
			objetivos = criteria.list();
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
		}		
		return objetivos;
	}
	

	@Override
	public void modificarObjetivo(TbMicObjetivo objetivo) throws ExcepcionesDAO {
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
