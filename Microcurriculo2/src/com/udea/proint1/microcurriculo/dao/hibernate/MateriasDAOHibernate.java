package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.MateriasDAO;
import com.udea.proint1.microcurriculo.dto.Materias;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class MateriasDAOHibernate extends HibernateDaoSupport implements MateriasDAO {

	public MateriasDAOHibernate() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void guardarMateria(Materias materia) throws ExcepcionesDAO {
		Session session = null;
		Transaction tx = null;
		
		try{
			session = getSession();
			tx = session.beginTransaction();
			session.save(materia);
			
		}catch (HibernateException e){
			throw new ExcepcionesDAO();
		}
	}

	@Override
	public Materias obtenerMateria(String id) throws ExcepcionesDAO {
		Session session = null;
		Materias materia = null;
		
		try{
			session = getSession();
			materia = (Materias)session.get(Materias.class, id);
			
		}catch(HibernateException e){
			throw new ExcepcionesDAO();
			
		}		
		return materia;
	}

	@Override
	public List<Materias> listarMaterias() throws ExcepcionesDAO {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Materias> listarMateriasPorNucleo(String nucleo)
			throws ExcepcionesDAO {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Materias> listarMateriasPorSemestre(int semestre)
			throws ExcepcionesDAO {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizarMateria(Materias materia) throws ExcepcionesDAO {
		// TODO Auto-generated method stub

	}

}
