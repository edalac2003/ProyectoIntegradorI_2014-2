package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.MicrocurriculosDAO;
import com.udea.proint1.microcurriculo.dto.Microcurriculos;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class MicrocurriculosDAOHibernate extends HibernateDaoSupport implements MicrocurriculosDAO {

	MicrocurriculosDAO microcurriculosDAO;
	
	public MicrocurriculosDAOHibernate() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void guardarMicrocurriculo(Microcurriculos microcurriculo)
			throws ExcepcionesDAO {
		// TODO Auto-generated method stub

	}

	@Override
	public Microcurriculos obtenerMicrocurriculo(String idMicrocurriculo)
			throws ExcepcionesDAO {
		
		Session session = null;
		Microcurriculos microcurriculo = null;
		
		try{
			session = getSession();
			microcurriculo = (Microcurriculos)session.get(Microcurriculos.class, idMicrocurriculo);
			
		}catch(HibernateException e){
			throw new ExcepcionesDAO();
		}
		return microcurriculo;
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
	public void modificarMicrocurriculo(String idMicrocurriculo)
			throws ExcepcionesDAO {
		// TODO Auto-generated method stub

	}

}
