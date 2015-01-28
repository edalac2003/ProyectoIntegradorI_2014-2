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
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.udea.proint1.microcurriculo.dao.MicrocurriculoDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmMateria;
import com.udea.proint1.microcurriculo.dto.TbAdmNucleo;
import com.udea.proint1.microcurriculo.dto.TbAdmPersona;
import com.udea.proint1.microcurriculo.dto.TbMicBibliografia;
import com.udea.proint1.microcurriculo.dto.TbMicMicrocurriculo;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
//@ContextConfiguration(locations = "classpath:configuracion-spring.xml")
/**
 * 
 * @author eacosta
 *
 */
public class MicrocurriculoDAOHibernate extends HibernateDaoSupport implements MicrocurriculoDAO {

	@Override
	public void guardarMicrocurriculo(TbMicMicrocurriculo microcurriculo)
			throws ExcepcionesDAO {
		Session session = null;

		try {
			session = getSession();
			session.save(microcurriculo);
			session.flush(); 
		} catch (HibernateException e) {
			throw new ExcepcionesDAO("Error al Intentar guardar el Registro Microcurriculo en la Base de Datos. "+e);			
		}

	}

	

	@Override
	public TbMicMicrocurriculo obtenerMicrocurriculo(String idMicrocurriculo) throws ExcepcionesDAO {
		Session session = null;
		TbMicMicrocurriculo microcurriculo = null;;
		try{
			session = getSession();
			microcurriculo = (TbMicMicrocurriculo)session.get(TbMicMicrocurriculo.class, idMicrocurriculo);
		
		} catch (HibernateException e){
			throw new ExcepcionesDAO("DAO : Error al Intentar Obtener el Registro Microcurriculo en la Base de Datos."+e);
		}

		return microcurriculo;
	}


	@Override
	public void modificarMicrocurriculo(TbMicMicrocurriculo microcurriculo) throws ExcepcionesDAO {
		Session session = null;
		try {
			session = getSession();
			this.getHibernateTemplate().update(microcurriculo);
		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		}
	}

	@Override
	public List<TbMicMicrocurriculo> listarMicrocurriculos() throws ExcepcionesDAO {
		Session session = null;
		List<TbMicMicrocurriculo> microcurriculos = new ArrayList<TbMicMicrocurriculo>();

		try {
			session = getSession();
			Criteria criteria = session.createCriteria(TbMicMicrocurriculo.class);
			microcurriculos = criteria.list();
		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		}

		return microcurriculos;
	}

	@Override
	public List<TbMicMicrocurriculo> listarMicrocurriculosPorSemestre(String idSemestre) throws ExcepcionesDAO {
		Session session = null;
		List<TbMicMicrocurriculo> microcurriculos = new ArrayList<TbMicMicrocurriculo>();

		try {
			session = getSession();
			Query query = session.createQuery("from TbMicMicrocurriculos where idSemestre = :semestre");
			query.setString("Semestre", idSemestre);
			microcurriculos = query.list();

		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		}

		return microcurriculos;
	}

	@Override
	public List<TbMicMicrocurriculo> listarMicrocurriculosPorNucleo(
			TbAdmNucleo nucleo) throws ExcepcionesDAO {
		Session session = null;
		List<TbMicMicrocurriculo> microcurriculos = new ArrayList<TbMicMicrocurriculo>();

		try {
			session = getSession();
			Query query = session.createQuery("from TbMicMicrocurriculos where tbAdmNucleo = :buscarNucleo");
			query.setEntity("buscarNucleo", nucleo);
			microcurriculos = query.list();
		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		}
		return microcurriculos;
	}

	@Override
	public List<TbMicMicrocurriculo> listarMicrocurriculosPorMateria(
			TbAdmMateria materia) throws ExcepcionesDAO {
		Session session = null;
		List<TbMicMicrocurriculo> microcurriculos = new ArrayList<TbMicMicrocurriculo>();
		
		try {
			session = getSession();
			Query query = session.createQuery("from TbMicMicrocurriculos where tbAdmMaterias = :buscarMateria");
			query.setEntity("buscarMateria", materia);
			microcurriculos = query.list();
		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		}
		return microcurriculos;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<TbMicMicrocurriculo> listarMicrocurriculosPorMateria(String materia) throws ExcepcionesDAO {
		Session session = null;
		List<TbMicMicrocurriculo> microcurriculos = new ArrayList<TbMicMicrocurriculo>();
		
		try {
			session = getSession();
			Query query = session.createQuery("from TbMicMicrocurriculos where tbAdmMaterias = :buscarMateria");
			query.setEntity("buscarMateria", materia);
			microcurriculos = query.list();
		} catch (HibernateException e) {
			throw new ExcepcionesDAO("Se presentaron problemas al intentar Listar los Microcurriculos por Materia.  ");
		}
		return microcurriculos;
	}

	@Override
	public List<TbMicMicrocurriculo> listarMicrocurriculosPorResponsable(
			TbAdmPersona responsable) throws ExcepcionesDAO {
		Session session = null;
		List<TbMicMicrocurriculo> microcurriculos = new ArrayList<TbMicMicrocurriculo>();

		try {

			session = getSession();

			Query query = session
					.createQuery("from TbMicMicrocurriculos where tbAdmPersona= :buscarResponsable");

			query.setEntity("buscarResponsable", responsable);

			microcurriculos = query.list();
		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		}
		return microcurriculos;
	}

}
