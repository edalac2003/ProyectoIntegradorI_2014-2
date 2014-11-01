package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.MateriasDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmMaterias;
import com.udea.proint1.microcurriculo.dto.TbMicMateriasxpensum;
import com.udea.proint1.microcurriculo.dto.TbMicMicrocurriculos;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class MateriasDAOHibernate extends HibernateDaoSupport implements MateriasDAO {

	public MateriasDAOHibernate() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void guardarMateria(TbAdmMaterias materia) throws ExcepcionesDAO {
		Session session = null;
		
		try{
			session = getSession();
			
			session = getSession();
			session.save(materia);
			session.flush();
			
		}catch(HibernateException e){
			
		}
		
	}

	@Override
	public TbAdmMaterias obtenerMateria(String idMateria) throws ExcepcionesDAO {
		Session session = null;
		TbAdmMaterias materia = null;
		
		try{
			session = getSession();
			materia = (TbAdmMaterias)session.load(TbAdmMaterias.class, idMateria);
			
		}catch(HibernateException e){
			throw new ExcepcionesDAO();
		}
		return materia;
	}

	@Override
	public List<TbAdmMaterias> listarMaterias() throws ExcepcionesDAO {
		// TODO Auto-generated method stub
		Session session = null;
		List<TbAdmMaterias> materias = new ArrayList<TbAdmMaterias>();
		
		try{
			session = getSession();
			
			Criteria criteria = session.createCriteria(TbAdmMaterias.class);
			
			materias = criteria.list();
			
		}catch(HibernateException e){
			throw new ExcepcionesDAO();
		}
		
		return materias;
	}


	@Override
	public List<TbAdmMaterias> listarMateriasPorNucleo(String nucleo)
			throws ExcepcionesDAO {
		Session session = null;
		
		try {
			session = getSession(true);
			List<TbAdmMaterias> materias = new ArrayList<TbAdmMaterias>();
			Query q = session.createQuery("FROM TbAdmMaterias where tbAdmNucleo.vrIdnucleo = " + nucleo);
			q.executeUpdate();
			materias = q.list();
			return materias;
			
		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		} 
		
	}

	@Override
	public List<TbAdmMaterias> listarMateriasPorSemestre(int semestre)
			throws ExcepcionesDAO {
		Session session = null;
        List<TbAdmMaterias> materias = new ArrayList<TbAdmMaterias>();
       
        try{
               
                session = getSession();	
                               
                Query query = session.createQuery("from TbMicMicrocurriculos where nbSemestre = :nroSemestre");
               
                query.setInteger("nroSemestre", semestre);
               
                materias = query.list();
                
        }catch(HibernateException e){
                throw new ExcepcionesDAO(e);
        }
        return materias;
	}

	@Override
	public void actualizarMateria(TbAdmMaterias materia) throws ExcepcionesDAO {
		Session session = null;

		try {
			session = getSession();

			session = getSession();
			this.getHibernateTemplate().update(materia);

		} catch (HibernateException e) {
			throw new ExcepcionesDAO("No se pudo ejecutar la operacion DAO, editar");
		}
	}

}
