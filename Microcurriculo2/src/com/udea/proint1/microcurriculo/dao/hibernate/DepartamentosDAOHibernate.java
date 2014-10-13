package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.DepartamentosDAO;
import com.udea.proint1.microcurriculo.dto.Departamentos;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class DepartamentosDAOHibernate extends HibernateDaoSupport implements DepartamentosDAO {

	public DepartamentosDAOHibernate() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void guardarDepartamento(Departamentos departamento)
			throws ExcepcionesDAO {
		// TODO Auto-generated method stub

	}

	@Override
	public Departamentos obtenerDepartamento(int id) throws ExcepcionesDAO {
		Session session = null;
		Departamentos departamento = null;
		
		try{
			session = getSession();
			departamento = (Departamentos)session.get(Departamentos.class, id);
			
		}catch(HibernateException e){
			throw new ExcepcionesDAO();
			
		}
				
		return departamento;
	}

	@Override
	public List<Departamentos> listarDepartamentos() throws ExcepcionesDAO {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modificarDepartamentos(Departamentos departamento)
			throws ExcepcionesDAO {
		// TODO Auto-generated method stub

	}

}
