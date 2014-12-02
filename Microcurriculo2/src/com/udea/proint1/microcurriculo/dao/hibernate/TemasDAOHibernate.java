package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.TemasDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmPersona;
import com.udea.proint1.microcurriculo.dto.TbMicTemas;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

/**
 * 
 * @author eacosta
 *
 */
public class TemasDAOHibernate extends HibernateDaoSupport implements TemasDAO {

	public TemasDAOHibernate() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void guardarTema(TbMicTemas tema) throws ExcepcionesDAO {
		Session session = null;

		try {
			session = getSession();
			session.save(tema);
			session.flush(); 
		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		}
	}

	@Override
	public void modificarTema(TbMicTemas tema) throws ExcepcionesDAO {
		Session session = null;
		Transaction tx = null;
		
		try {
			session = getSession();
			tx = session.beginTransaction();
			session.update(tema);
			tx.commit();
			
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
		}
	}

	@Override
	public TbMicTemas obtenerTema(int idTema) throws ExcepcionesDAO {
		Session session = null;
		TbMicTemas tema = null;
		
		try{
			session = getSession();
			tema = (TbMicTemas)session.get(TbMicTemas.class, idTema);			
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
		}				
		return tema;
	}

	
	
	@Override
	public List<TbMicTemas> obtenerTemaxNombre(String nombre) throws ExcepcionesDAO {
		Session session = null;
        List<TbMicTemas> temas = new ArrayList<TbMicTemas>();
       
        try{
               
        	session = getSession();
                               
        	Query query = session.createQuery("from TbMicTemas where vrDescripcion = :nombre");
               
        	query.setString("nombre", nombre);
               
        	temas = query.list();
        }catch(HibernateException e){
                throw new ExcepcionesDAO(e);
        }
        return temas;
	}

	@Override
	public List<TbMicTemas> listarTemas() throws ExcepcionesDAO {
		Session session = null;
		List<TbMicTemas> temas = new ArrayList<TbMicTemas>();
		
		try{
			session = getSession();
			Criteria criteria = session.createCriteria(TbMicTemas.class);
			temas = criteria.list();
			
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
			
		}
		
		return temas;
	}

	@Override
	public int contarRegistros() throws ExcepcionesDAO {
		int registro = 0;
		Session session = null;
		
		try{
			session = getSession();
			Criteria criteria = session.createCriteria(TbMicTemas.class);
			registro = criteria.list().size();
			
		} catch(HibernateException e){
			throw new ExcepcionesDAO("DAO : No es posible retornar un valor numerico de los registros. "+e);
		}	
		
		return registro;
	}

}
