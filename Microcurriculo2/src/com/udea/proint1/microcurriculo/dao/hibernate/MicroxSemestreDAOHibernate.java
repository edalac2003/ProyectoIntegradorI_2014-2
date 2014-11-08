package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.MicroxSemestreDAO;
import com.udea.proint1.microcurriculo.dto.TbMicEvaluacionxmicro;
import com.udea.proint1.microcurriculo.dto.TbMicMicroxsemestre;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class MicroxSemestreDAOHibernate extends HibernateDaoSupport implements MicroxSemestreDAO {

	public MicroxSemestreDAOHibernate() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void guardarMicroxsemestre(TbMicMicroxsemestre microxSemestre)
			throws ExcepcionesDAO {
		Session session = null;
		
		try{
			session = getSession();
			
			session = getSession();
			session.save(microxSemestre);
			session.flush();
			
		}catch(HibernateException e){
			
		}
	}

	@Override
	public void actualizarMicroxsemestre(TbMicMicroxsemestre microxSemestre)
			throws ExcepcionesDAO {
		Session session = null;

		try {
			session = getSession();

			session = getSession();
			this.getHibernateTemplate().update(microxSemestre);

		} catch (HibernateException e) {
			throw new ExcepcionesDAO("No se pudo ejecutar la operacion DAO, Actualizar");
		}
	}

	@Override
	public TbMicMicroxsemestre obtenerMicroxsemestre(int id)
			throws ExcepcionesDAO {
		Session session = null;
		TbMicMicroxsemestre microxSemestre = null;
		
		try{
			session = getSession();
			microxSemestre = (TbMicMicroxsemestre)session.load(TbMicMicroxsemestre.class, id);
			
		}catch(HibernateException e){
			throw new ExcepcionesDAO();
		}
		return microxSemestre;
	}

	@Override
	public List<TbMicMicroxsemestre> listarMicroxsemestre()
			throws ExcepcionesDAO {
		Session session = null;
		List<TbMicMicroxsemestre> microsxsemestre = new ArrayList<TbMicMicroxsemestre>();
		
		try{
			session = getSession();
			Criteria criteria = session.createCriteria(TbMicMicroxsemestre.class);
			microsxsemestre = criteria.list();			
		}catch(HibernateException e){
			throw new ExcepcionesDAO();
		}
		
		return microsxsemestre;
	}

}