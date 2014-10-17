package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.udea.proint1.microcurriculo.dao.MicrocurriculosDAO;
import com.udea.proint1.microcurriculo.dto.Microcurriculos;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations = "classpath:configuracion-spring.xml")

/**
 * 
 * @author eacosta
 *
 */
public class MicrocurriculosDAOHibernate extends HibernateDaoSupport implements MicrocurriculosDAO {
	
	public MicrocurriculosDAOHibernate() {
		
	}

	@Override
	public void guardarMicrocurriculo(Microcurriculos microcurriculo)
			throws ExcepcionesDAO {
		Session session = null;
		Transaction tx = null;
		
		try{
			session = getSession();
			
			tx = session.beginTransaction();
			session.save(microcurriculo);
			tx.commit();
			
		}catch(HibernateException e){
			
		}

	}

	@Override
	public Microcurriculos obtenerMicrocurriculo(String IdMicrocurriculo)
			throws ExcepcionesDAO {
		Session session = null;
		Microcurriculos microcurriculo = null;
		
		try{
			session = getSession();
			microcurriculo = (Microcurriculos)session.get(Microcurriculos.class, IdMicrocurriculo);
			
		}catch(HibernateException e){
			throw new ExcepcionesDAO();
		}
		return microcurriculo;
	}

	@Override
	public void modificarMicrocurriculo(Microcurriculos microcurriculo)
			throws ExcepcionesDAO {
		Session session = null;
		Transaction tx = null;
		
		try{
			session = getSession();
			tx = session.beginTransaction();
			session.update(microcurriculo);
			tx.commit();
			
		}catch(HibernateException e){
			throw new ExcepcionesDAO();
		}
	}

	@Override
	public List<Microcurriculos> listarMicrocurriculos() throws ExcepcionesDAO {
		Session session = null;
		List<Microcurriculos> microcurriculos = new ArrayList<Microcurriculos>();
		
		try{
			session = getSession();
			
			Criteria criteria = session.createCriteria(Microcurriculos.class);
			
			microcurriculos = criteria.list();
			
		}catch(HibernateException e){
			throw new ExcepcionesDAO();
		}
		
		return microcurriculos;
	}

	@Override
	public List<Microcurriculos> listarMicrocurriculosPorSemestre(String idSemestre)
			throws ExcepcionesDAO {
		Session session = null;
		List<Microcurriculos> microcurriculos = new ArrayList<Microcurriculos>();
		
		try{
			session = getSession();
			
			Query query = session.createQuery("from Microcurriculos where idSemestre = :semestre");
			
			query.setEntity("Semestre", idSemestre);
			
			microcurriculos = query.list();
			
		}catch(HibernateException e){
			throw new ExcepcionesDAO();
		}
		
		return microcurriculos;
	}

	@Override
	public List<Microcurriculos> listarMicrocurriculosPorNucleo(String idNucleo)
			throws ExcepcionesDAO {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Microcurriculos> listarMicrocurriculosPorMateria(String idMateria)
			throws ExcepcionesDAO {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Microcurriculos> listarMicrocurriculosPorResponsable(String idResponsable)
			throws ExcepcionesDAO {
		// TODO Auto-generated method stub
		return null;
	}

}
