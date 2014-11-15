package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.ObjetivosxMicroDAO;
import com.udea.proint1.microcurriculo.dto.TbMicObjetivosxmicro;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class ObjetivosxMicroDAOHibernate extends HibernateDaoSupport implements ObjetivosxMicroDAO {

	public ObjetivosxMicroDAOHibernate() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void guardarObjetivosxMicro(TbMicObjetivosxmicro objetivoxMicro)	throws ExcepcionesDAO {
		Session session = null;
		Transaction tx = null;
		
		try{
			session = getSession();
			tx = session.beginTransaction();
			session.save(objetivoxMicro);
			tx.commit();
		}catch(HibernateException e){
			throw new ExcepcionesDAO("Error al intentar guardar el objeto <ObjetivoxMicrocurriculo>.");
		}

	}
	
	
	@Override
	public void guardarObjetivosxMicro(List<TbMicObjetivosxmicro> listaObjetivoxMicro) throws ExcepcionesDAO {
		if(listaObjetivoxMicro != null){
			for(TbMicObjetivosxmicro objetivoxMicro : listaObjetivoxMicro){
				guardarObjetivosxMicro(objetivoxMicro);
			}
		}else{
			throw new ExcepcionesDAO("El objeto <Lista ObjetivosxMicro> no tiene información válida.");
		}
	}

	@Override
	public void modificarObjetivoxMicro(TbMicObjetivosxmicro objetivoxMicro)
			throws ExcepcionesDAO {
		// TODO Auto-generated method stub

	}

	@Override
	public TbMicObjetivosxmicro obtenerObjetivoxMicro(String idMicrocurriculo, int idObjetivo) throws ExcepcionesDAO {
		// TODO Auto-generated method stub
		return null;
	}
	

	@Override
	public TbMicObjetivosxmicro obtenerObjetivoxMicro(int idObjetivo) throws ExcepcionesDAO {
		TbMicObjetivosxmicro objetivoxmicro = null;
		Session session = null;
		
		try{
			session = getSession();
			objetivoxmicro = (TbMicObjetivosxmicro)session.get(TbMicObjetivosxmicro.class, idObjetivo);
			
		}catch(HibernateException e){
			throw new ExcepcionesDAO();
		}
		
		return objetivoxmicro;
	}

	@Override
	public List<TbMicObjetivosxmicro> listarObjetivosxMicro()
			throws ExcepcionesDAO {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TbMicObjetivosxmicro> listarObjetivosxMicro(
			String idMicrocurriculo) throws ExcepcionesDAO {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int contarRegistros() throws ExcepcionesDAO {
		int registro = 0;
		Session session = null;
		
		try{
			session = getSession();
			Criteria criteria = session.createCriteria(TbMicObjetivosxmicro.class);
			registro = criteria.list().size();
			
		}catch(HibernateException e){
			throw new ExcepcionesDAO("Se produjo un error al calcular los Registros de la Tabla Objetivos x Microcurriculo.");			
		}		
		return registro;
	}

}
