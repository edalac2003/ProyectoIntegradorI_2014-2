package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.PersonaDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmPersona;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

/**
 * 
 * @author eacosta
 *
 */
public class PersonaDAOHibernate extends HibernateDaoSupport implements PersonaDAO {

	public PersonaDAOHibernate() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void guardarPersona(TbAdmPersona persona) throws ExcepcionesDAO {
		Session session = null;
		Transaction tx = null;
		
		try{
			session = getSession();
			tx = session.beginTransaction();
			session.save(persona);
			tx.commit();
			
		}catch(HibernateException e){
			throw new ExcepcionesDAO();
			
		}

	}

	@Override
	public void modificarPersona(TbAdmPersona persona) throws ExcepcionesDAO {
		// TODO Auto-generated method stub

	}

	@Override
	public TbAdmPersona obtenerPersona(String idPersona) throws ExcepcionesDAO {
		Session session = null;
		TbAdmPersona persona = null;
		
		try {
			session = getSession();
			persona = (TbAdmPersona)session.get(TbAdmPersona.class, idPersona);
			
		}catch(HibernateException e){
			throw new ExcepcionesDAO();
			
		}
		return persona;
	}

	@Override
	public TbAdmPersona obtenerPersonaPorTipo(String idPersona, int tipoPersona)
			throws ExcepcionesDAO {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TbAdmPersona> listarPersonas() throws ExcepcionesDAO {
		Session session = null;
		List<TbAdmPersona> personas = new ArrayList<TbAdmPersona>();
		try {
			session = getSession();
			Criteria criteria = session.createCriteria(TbAdmPersona.class);
			
			personas = criteria.list();
		}catch(HibernateException e){
			throw new ExcepcionesDAO();
			
		}
		
		return personas;
	}

}
