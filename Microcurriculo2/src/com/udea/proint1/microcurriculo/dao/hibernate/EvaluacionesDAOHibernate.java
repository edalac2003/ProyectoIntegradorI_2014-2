package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.EvaluacionesDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmMaterias;
import com.udea.proint1.microcurriculo.dto.TbMicEvaluaciones;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class EvaluacionesDAOHibernate extends HibernateDaoSupport implements EvaluacionesDAO {

	public EvaluacionesDAOHibernate() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void guardarEvaluaciones(TbMicEvaluaciones evaluacion) throws ExcepcionesDAO {
		Session session = null;
		
		try{
			session = getSession();
			
			session = getSession();
			session.save(evaluacion);
			session.flush();
			
		}catch(HibernateException e){
			
		}
	}

	@Override
	public TbMicEvaluaciones obtenerEvaluaciones(int id) throws ExcepcionesDAO {
		Session session = null;
		TbMicEvaluaciones evaluacion = null;
		
		try{
			session = getSession();
			evaluacion = (TbMicEvaluaciones)session.load(TbMicEvaluaciones.class, id);
			
		}catch(HibernateException e){
			throw new ExcepcionesDAO();
		}
		return evaluacion;
	}

	@Override
	public List<TbMicEvaluaciones> listarEvaluaciones() throws ExcepcionesDAO {
		Session session = null;
		List<TbMicEvaluaciones> evaluaciones = new ArrayList<TbMicEvaluaciones>();
		
		try{
			session = getSession();
			Criteria criteria = session.createCriteria(TbMicEvaluaciones.class);
			evaluaciones = criteria.list();			
		}catch(HibernateException e){
			throw new ExcepcionesDAO();
		}
		
		return evaluaciones;
	}

	@Override
	public void actualizarEvaluaciones(TbMicEvaluaciones evaluacion) throws ExcepcionesDAO {
		Session session = null;

		try {
			session = getSession();

			session = getSession();
			this.getHibernateTemplate().update(evaluacion);

		} catch (HibernateException e) {
			throw new ExcepcionesDAO("No se pudo ejecutar la operacion DAO, Actualizar");
		}
	}

}
