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

import com.udea.proint1.microcurriculo.dao.MicrocurriculosDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmMaterias;
import com.udea.proint1.microcurriculo.dto.TbAdmNucleo;
import com.udea.proint1.microcurriculo.dto.TbAdmPersona;
import com.udea.proint1.microcurriculo.dto.TbMicBibliografia;
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
public class MicrocurriculosDAOHibernate extends HibernateDaoSupport implements
		MicrocurriculosDAO {

	public MicrocurriculosDAOHibernate() {

	}

	@Override
	public void guardarMicrocurriculo(TbMicMicrocurriculos microcurriculo)
			throws ExcepcionesDAO {
		Session session = null;

		try {
			session = getSession();
			session.save(microcurriculo);
			session.flush(); 
		} catch (HibernateException e) {
			throw new ExcepcionesDAO("Error al Intentar guardar el Registro Microcurriculo en la Base de Datos.");			
		}

	}

	@Override
	public TbMicMicrocurriculos obtenerMicrocurriculo(String IdMicrocurriculo)
			throws ExcepcionesDAO {
		Session session = null;
		TbMicMicrocurriculos microcurriculo = null;

		try {
			session = getSession();
			microcurriculo = (TbMicMicrocurriculos) session.load(
					TbMicMicrocurriculos.class, IdMicrocurriculo);

		} catch (HibernateException e) {
			throw new ExcepcionesDAO();
		}
		return microcurriculo;
	}

	@Override
	public void modificarMicrocurriculo(TbMicMicrocurriculos microcurriculo)
			throws ExcepcionesDAO {
		Session session = null;

		try {
			session = getSession();
			this.getHibernateTemplate().update(microcurriculo);

		} catch (HibernateException e) {
			throw new ExcepcionesDAO();
		}
	}

	@Override
	public List<TbMicMicrocurriculos> listarMicrocurriculos()
			throws ExcepcionesDAO {
		Session session = null;
		List<TbMicMicrocurriculos> microcurriculos = new ArrayList<TbMicMicrocurriculos>();

		try {
			session = getSession();

			Criteria criteria = session
					.createCriteria(TbMicMicrocurriculos.class);

			microcurriculos = criteria.list();

		} catch (HibernateException e) {
			throw new ExcepcionesDAO();
		}

		return microcurriculos;
	}

	@Override
	public List<TbMicMicrocurriculos> listarMicrocurriculosPorSemestre(
			String idSemestre) throws ExcepcionesDAO {
		Session session = null;
		List<TbMicMicrocurriculos> microcurriculos = new ArrayList<TbMicMicrocurriculos>();

		try {
			session = getSession();

			Query query = session
					.createQuery("from TbMicMicrocurriculos where idSemestre = :semestre");

			query.setString("Semestre", idSemestre);

			microcurriculos = query.list();

		} catch (HibernateException e) {
			throw new ExcepcionesDAO();
		}

		return microcurriculos;
	}

	@Override
	public List<TbMicMicrocurriculos> listarMicrocurriculosPorNucleo(
			TbAdmNucleo nucleo) throws ExcepcionesDAO {
		Session session = null;
		List<TbMicMicrocurriculos> microcurriculos = new ArrayList<TbMicMicrocurriculos>();

		try {

			session = getSession();

			Query query = session
					.createQuery("from TbMicMicrocurriculos where tbAdmNucleo = :buscarNucleo");

			query.setEntity("buscarNucleo", nucleo);

			microcurriculos = query.list();
		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		}
		return microcurriculos;
	}

	@Override
	public List<TbMicMicrocurriculos> listarMicrocurriculosPorMateria(
			TbAdmMaterias materia) throws ExcepcionesDAO {
		Session session = null;
		List<TbMicMicrocurriculos> microcurriculos = new ArrayList<TbMicMicrocurriculos>();

		try {

			session = getSession();

			Query query = session
					.createQuery("from TbMicMicrocurriculos where tbAdmMaterias = :buscarMateria");

			query.setEntity("buscarMateria", materia);

			microcurriculos = query.list();
		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		}
		return microcurriculos;

	}

	@Override
	public List<TbMicMicrocurriculos> listarMicrocurriculosPorResponsable(
			TbAdmPersona responsable) throws ExcepcionesDAO {
		Session session = null;
		List<TbMicMicrocurriculos> microcurriculos = new ArrayList<TbMicMicrocurriculos>();

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
