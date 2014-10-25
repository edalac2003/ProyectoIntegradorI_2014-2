package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.runner.RunWith;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.udea.proint1.microcurriculo.dao.MicrocurriculosDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmMaterias;
import com.udea.proint1.microcurriculo.dto.TbAdmNucleo;
import com.udea.proint1.microcurriculo.dto.TbAdmPersona;
import com.udea.proint1.microcurriculo.dto.TbMicMicrocurriculos;
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
	public void guardarMicrocurriculo(TbMicMicrocurriculos microcurriculo)
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
	public TbMicMicrocurriculos obtenerMicrocurriculo(String IdMicrocurriculo)
			throws ExcepcionesDAO {
		Session session = null;
		TbMicMicrocurriculos microcurriculo = null;
		
		try{
			session = getSession();
			microcurriculo = (TbMicMicrocurriculos)session.get(TbMicMicrocurriculos.class, IdMicrocurriculo);
			
		}catch(HibernateException e){
			throw new ExcepcionesDAO();
		}
		return microcurriculo;
	}

	@Override
	public void modificarMicrocurriculo(TbMicMicrocurriculos microcurriculo) throws ExcepcionesDAO {
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
	public List<TbMicMicrocurriculos> listarMicrocurriculos() throws ExcepcionesDAO {
		Session session = null;
		List<TbMicMicrocurriculos> microcurriculos = new ArrayList<TbMicMicrocurriculos>();
		
		try{
			session = getSession();
			
			Criteria criteria = session.createCriteria(TbMicMicrocurriculos.class);
			
			microcurriculos = criteria.list();
			
		}catch(HibernateException e){
			throw new ExcepcionesDAO();
		}
		
		return microcurriculos;
	}

	@Override
	public List<TbMicMicrocurriculos> listarMicrocurriculosPorSemestre(String idSemestre)
			throws ExcepcionesDAO {
		Session session = null;
		List<TbMicMicrocurriculos> microcurriculos = new ArrayList<TbMicMicrocurriculos>();
		
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
	public List<TbMicMicrocurriculos> listarMicrocurriculosPorNucleo(TbAdmNucleo nucleo) throws ExcepcionesDAO {
		Session session = null;
        List<TbMicMicrocurriculos> microcurriculos = new ArrayList<TbMicMicrocurriculos>();
       
        try{
               
                session = getSession();
                               
                Query query = session.createQuery("from Microcurriculos as mic, Nucleo as nuc, Materias as mat where materia = :buscarMateria");
               
                query.setEntity("buscarNucleo", nucleo);
               
                microcurriculos = query.list();
        }catch(HibernateException e){
                throw new ExcepcionesDAO(e);
        }
        return microcurriculos;
	}

	@Override
	public List<TbMicMicrocurriculos> listarMicrocurriculosPorMateria(TbAdmMaterias materia) throws ExcepcionesDAO {
		Session session = null;
        List<TbMicMicrocurriculos> microcurriculos = new ArrayList<TbMicMicrocurriculos>();
       
        try{
               
                session = getSession();
                               
                Query query = session.createQuery("from Microcurriculos where materia = :buscarMateria");
               
                query.setEntity("buscarMateria", materia);
               
                microcurriculos = query.list();
        }catch(HibernateException e){
                throw new ExcepcionesDAO(e);
        }
        return microcurriculos;

	}

	@Override
	public List<TbMicMicrocurriculos> listarMicrocurriculosPorResponsable(TbAdmPersona responsable) throws ExcepcionesDAO {
		Session session = null;
        List<TbMicMicrocurriculos> microcurriculos = new ArrayList<TbMicMicrocurriculos>();
       
        try{
               
                session = getSession();
                               
                Query query = session.createQuery("from Microcurriculos where responsable = :buscarResponsable");
               
                query.setEntity("buscarResponsable", responsable);
               
                microcurriculos = query.list();
        }catch(HibernateException e){
                throw new ExcepcionesDAO(e);
        }
        return microcurriculos;
	}

}
