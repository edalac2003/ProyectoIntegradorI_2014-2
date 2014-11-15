package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.TemasXUnidadDAO;
import com.udea.proint1.microcurriculo.dto.TbMicTemasxunidad;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class TemasxUnidadDAOHibernate extends HibernateDaoSupport implements TemasXUnidadDAO {

	public TemasxUnidadDAOHibernate() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void guardarTemasXUnidad(TbMicTemasxunidad temaXunidad)	throws ExcepcionesDAO {
		Session session = null;
		Transaction tx = null;
		
		try{
			session = getSession();
			tx = session.beginTransaction();
			session.save(temaXunidad);
			tx.commit();
			
		}catch(HibernateException e){
			throw new ExcepcionesDAO();
		}
	}
	
	
	@Override
	public void guardarTemasXUnidad(List<TbMicTemasxunidad> listaTemaxUnidad) throws ExcepcionesDAO {
		if(listaTemaxUnidad != null){
			for(TbMicTemasxunidad txU : listaTemaxUnidad)
				guardarTemasXUnidad(txU);
			
		}else{
			throw new ExcepcionesDAO();
		}
	}

	@Override
	public void modificarTemasXUnidad(TbMicTemasxunidad temaXunidad)
			throws ExcepcionesDAO {
		// TODO Auto-generated method stub

	}

	@Override
	public TbMicTemasxunidad obtenerTemaXunidad(int idTema, int idUnidad) throws ExcepcionesDAO {
		return null;
	}
	
	
	@Override
	public TbMicTemasxunidad obtenerTemaXunidad(int idTemaxUnidad)	throws ExcepcionesDAO {
		TbMicTemasxunidad temaxUnidad = null;
		Session session = null;
		
		try{
			session = getSession();
			temaxUnidad = (TbMicTemasxunidad)session.get(TbMicTemasxunidad.class, idTemaxUnidad);
		}catch(HibernateException e){
			throw new ExcepcionesDAO();
		}		
		
		return temaxUnidad;
	}

	@Override
	public List<TbMicTemasxunidad> ListarTemasXunidad(int idUnidad)
			throws ExcepcionesDAO {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TbMicTemasxunidad> ListarTodoTemaXunidad()
			throws ExcepcionesDAO {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int contarRegistros() throws ExcepcionesDAO {
		int registro = 0;
		Session session = null;
		
		try{
			session = getSession();
			Criteria criteria = session.createCriteria(TbMicTemasxunidad.class);
			registro = criteria.list().size();
		}catch(HibernateException e){
			throw new ExcepcionesDAO("DAO : Error al intentar recuperar el Numero de Registros de la Tabla Temas por Unidad.");
		}
		
		return registro;
	}
	
	

}
