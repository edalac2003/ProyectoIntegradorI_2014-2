package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.SubtemaxTemaDAO;
import com.udea.proint1.microcurriculo.dto.TbMicSubtemaxtema;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class SubtemaxTemaDAOHibernate extends HibernateDaoSupport implements SubtemaxTemaDAO {

//	public SubtemaxTemaDAOHibernate() {
//		// TODO Auto-generated constructor stub
//	}

	@Override
	public void guardar(TbMicSubtemaxtema subtemaxTema) throws ExcepcionesDAO {
		Session session = null;
		
		try{
			session = getSession();
			session.save(subtemaxTema);
			session.flush();
			
		}catch(HibernateException e){
			throw new ExcepcionesDAO("DAO : Se presentaron problemas al guardar registro de <SubtemaxTema>.  "+e.getMessage());
		}

	}

	@Override
	public void modificar(TbMicSubtemaxtema subtemaxTema) throws ExcepcionesDAO {
		// TODO Auto-generated method stub

	}

	@Override
	public TbMicSubtemaxtema obtenerSubtema(int idSubtema)
			throws ExcepcionesDAO {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TbMicSubtemaxtema obtenerSubtema_Tema(int idTema)
			throws ExcepcionesDAO {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TbMicSubtemaxtema> listarSubtemaxTema() throws ExcepcionesDAO {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TbMicSubtemaxtema> listarSubtemaxTema_Tema(int idTema)
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
			Criteria criteria = session.createCriteria(TbMicSubtemaxtema.class);
			registro = criteria.list().size();
			
		}catch(HibernateException e){
			throw new ExcepcionesDAO("DAO: Se generaron problemas al contar los registros de la tabla <SubtemaxTema>"+e.getMessage());
		}	
		
		return registro;
	}

}
