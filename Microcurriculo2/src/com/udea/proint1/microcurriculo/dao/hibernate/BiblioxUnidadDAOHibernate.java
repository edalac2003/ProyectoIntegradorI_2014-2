package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.BiblioxUnidadDAO;
import com.udea.proint1.microcurriculo.dto.TbMicBiblioxunidad;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class BiblioxUnidadDAOHibernate extends HibernateDaoSupport implements BiblioxUnidadDAO {

	public BiblioxUnidadDAOHibernate() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void guardarBiblioxUnidad(TbMicBiblioxunidad biblioxUnidad)
			throws ExcepcionesDAO {
		// TODO Auto-generated method stub

	}

	@Override
	public void modificarBiblioxUnidad(TbMicBiblioxunidad biblioxUnidad)
			throws ExcepcionesDAO {
		// TODO Auto-generated method stub

	}

	@Override
	public TbMicBiblioxunidad obtenerBiblioxUnidad(int idUnidad,
			int idBibliografia) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TbMicBiblioxunidad> listadoBiblioxUnidad()
			throws ExcepcionesDAO {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TbMicBiblioxunidad> listadoBiblioxUnidad(int idUnidad)
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
			Criteria criteria = session.createCriteria(TbMicBiblioxunidad.class);
			
			registro = criteria.list().size();
		}catch(HibernateException e){
			throw new ExcepcionesDAO();
		}	
		
		return registro;
	}

}
