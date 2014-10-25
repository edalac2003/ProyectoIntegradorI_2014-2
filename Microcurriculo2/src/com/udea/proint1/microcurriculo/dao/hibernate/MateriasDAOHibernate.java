package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.MateriasDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmMaterias;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class MateriasDAOHibernate extends HibernateDaoSupport implements MateriasDAO {

	public MateriasDAOHibernate() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void guardarMateria(TbAdmMaterias materia) throws ExcepcionesDAO {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TbAdmMaterias obtenerMateria(String id) throws ExcepcionesDAO {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TbAdmMaterias> listarMaterias() throws ExcepcionesDAO {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TbAdmMaterias> listarMateriasPorNucleo(String nucleo)
			throws ExcepcionesDAO {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TbAdmMaterias> listarMateriasPorSemestre(int semestre)
			throws ExcepcionesDAO {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizarMateria(TbAdmMaterias materia) throws ExcepcionesDAO {
		// TODO Auto-generated method stub
		
	}

}
