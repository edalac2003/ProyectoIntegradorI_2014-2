package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.CorrequisitosDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmCorrequisitos;
import com.udea.proint1.microcurriculo.dto.TbAdmMaterias;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class CorrequisitosDAOHibernate extends HibernateDaoSupport implements CorrequisitosDAO{

	@Override
	public void guardarCorrequisito(TbAdmCorrequisitos correquisitos)
			throws ExcepcionesDAO {
		Session session = null;
		Transaction tx = null;
		
		try{
			session = getSession();
			
			tx = session.beginTransaction();
			session.save(correquisitos);
			tx.commit();
			
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
		}
		
	}
	
	@Override
	public void actualizarCorrequisito(TbAdmCorrequisitos correquisitos) throws ExcepcionesDAO{
		Session session = null;
		
		try{
			session = getSession();
			this.getHibernateTemplate().update(correquisitos);
			
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
		}
	}

	@Override
	public TbAdmCorrequisitos obtenerCorrequisitos(int id)
			throws ExcepcionesDAO {
		Session session = null;
		TbAdmCorrequisitos correquisitos = null;
		
		try{
			session = getSession();
			correquisitos = (TbAdmCorrequisitos)session.get(TbAdmCorrequisitos.class, id);
			
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
		}
		return correquisitos;
	}

	@Override
	public List<TbAdmCorrequisitos> listarCorrequisitos() throws ExcepcionesDAO {
		Session session = null;
		List<TbAdmCorrequisitos> correquisitos = new ArrayList<TbAdmCorrequisitos>();
		
		try{
			session = getSession();
			
			Criteria criteria = session.createCriteria(TbAdmCorrequisitos.class);
			
			correquisitos = criteria.list();
			
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
		}
		
		return correquisitos;
	}

	public List<TbAdmCorrequisitos> listarCorrequisitosxmateria(TbAdmMaterias materia) throws ExcepcionesDAO{
		Session session = null;
        List<TbAdmCorrequisitos> correquisitos = new ArrayList<TbAdmCorrequisitos>();
       
        try{
               
                session = getSession();	
                               
                Query query = session.createQuery("from TbAdmCorrequisitos where tbAdmMateriasByVrMateria = :materia");
               
                query.setEntity("materia", materia);
               
                correquisitos = query.list();
                
        }catch(HibernateException e){
                throw new ExcepcionesDAO(e);
        }
        return correquisitos;
	}
}
