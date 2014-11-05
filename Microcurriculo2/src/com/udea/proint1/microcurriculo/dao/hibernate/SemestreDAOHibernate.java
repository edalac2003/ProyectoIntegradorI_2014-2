package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.SemestreDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmPersona;
import com.udea.proint1.microcurriculo.dto.TbAdmSemestre;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class SemestreDAOHibernate extends HibernateDaoSupport implements SemestreDAO {

	public SemestreDAOHibernate() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void guardarSemestre(TbAdmSemestre semestre) throws ExcepcionesDAO {
		// TODO Auto-generated method stub

	}

	@Override
	public List<TbAdmSemestre> listarSemestres() throws ExcepcionesDAO {
		Session session = null;
		
		List<TbAdmSemestre> listaSemestre = new ArrayList<TbAdmSemestre>();
		try {
			session= getSession();
			Criteria criteria = session.createCriteria(TbAdmSemestre.class);
			listaSemestre = criteria.list();
		} catch (HibernateException e) {
			throw new ExcepcionesDAO();
		}
		return listaSemestre;
	}	
}
