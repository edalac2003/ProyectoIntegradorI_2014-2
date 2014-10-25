package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.DepartamentosDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmDepartamentos;
import com.udea.proint1.microcurriculo.dto.TbMicMicrocurriculos;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class DepartamentosDAOHibernate extends HibernateDaoSupport implements DepartamentosDAO {

	private static Logger log=Logger.getLogger(DepartamentosDAOHibernate.class);
	
	public DepartamentosDAOHibernate() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public TbAdmDepartamentos obtenerDepartamento(int id) throws ExcepcionesDAO {
		Session session = null;
		TbAdmDepartamentos departamento = null;
		
		try{
			log.info("***********Se está obteniendo Departamento por Id*********");
			session = getSession();
			departamento = (TbAdmDepartamentos)session.get(TbAdmDepartamentos.class, id);
			
		}catch(HibernateException e){
			log.error("Falló al obtener departamento", e);
			throw new ExcepcionesDAO();	
		}
				
		return departamento;
	}

	@Override
	public List<TbAdmDepartamentos> listarDepartamentos() throws ExcepcionesDAO {
		Session session = null;
		List<TbAdmDepartamentos> departamentos = new ArrayList<TbAdmDepartamentos>();
		
		try{
			session = getSession();
			
			Criteria criteria = session.createCriteria(TbMicMicrocurriculos.class);
			
			log.info("********Obteniendo listado de Departamentos*********");
			departamentos = criteria.list();
			
		}catch(HibernateException e){
			log.error("Falló al obtener lista de departamentos", e);
			throw new ExcepcionesDAO();
		}
		
		return departamentos;
	}

	@Override
	public void modificarDepartamentos(TbAdmDepartamentos departamento) throws ExcepcionesDAO {
		Session session = null;
		Transaction tx = null;
		
		try{
			session = getSession();
			tx = session.beginTransaction();
			log.info("********Se está actualizando Departamento*********");
			session.update(departamento);
			tx.commit();
			
		}catch(HibernateException e){
			tx.rollback();
			log.error("Hubo error al momento de actualizar Departamento", e);
			throw new ExcepcionesDAO();
			
		}
	}

}
