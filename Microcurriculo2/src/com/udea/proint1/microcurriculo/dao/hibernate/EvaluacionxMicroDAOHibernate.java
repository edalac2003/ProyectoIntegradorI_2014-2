package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.EvaluacionxMicroDAO;
import com.udea.proint1.microcurriculo.dto.TbMicEvaluacion;
import com.udea.proint1.microcurriculo.dto.TbMicEvaluacionxmicro;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class EvaluacionxMicroDAOHibernate extends HibernateDaoSupport implements EvaluacionxMicroDAO {

	public EvaluacionxMicroDAOHibernate() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void guardarEvaluacionesxmicro(TbMicEvaluacionxmicro evaluacionxMicro) throws ExcepcionesDAO {
		Session session = null;
		
		try{			
			session = getSession();
			session.save(evaluacionxMicro);
			session.flush();
			
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
		}
	}

	@Override
	public TbMicEvaluacionxmicro obtenerEvaluacionesxmicro(int id) throws ExcepcionesDAO {
		Session session = null;
		TbMicEvaluacionxmicro evaluacionxMicro = null;
		
		try{
			session = getSession();
			evaluacionxMicro = (TbMicEvaluacionxmicro)session.load(TbMicEvaluacionxmicro.class, id);
			
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
		}
		return evaluacionxMicro;
	}

	@Override
	public List<TbMicEvaluacionxmicro> listarEvaluacionesxmicro() throws ExcepcionesDAO {
		Session session = null;
		List<TbMicEvaluacionxmicro> evaluacionesxMicro = new ArrayList<TbMicEvaluacionxmicro>();
		
		try{
			session = getSession();
			Criteria criteria = session.createCriteria(TbMicEvaluacionxmicro.class);
			evaluacionesxMicro = criteria.list();			
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
		}
		
		return evaluacionesxMicro;
	}

	@Override
	public void actualizarEvaluacionesxmicro(TbMicEvaluacionxmicro evaluacionxMicro) throws ExcepcionesDAO {
		Session session = null;

		try {
			session = getSession();

			session = getSession();
			this.getHibernateTemplate().update(evaluacionxMicro);

		} catch (HibernateException e) {
			throw new ExcepcionesDAO("No se pudo ejecutar la operacion DAO, Actualizar "+e);
		}
	}

}
