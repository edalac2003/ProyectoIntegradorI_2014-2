package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.UnidadesXMicroDAO;
import com.udea.proint1.microcurriculo.dto.TbMicUnidadesxmicro;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class UnidadesxMicroDAOHibernate extends HibernateDaoSupport implements UnidadesXMicroDAO {

	public UnidadesxMicroDAOHibernate() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void guardarUnidadXmicro(TbMicUnidadesxmicro unidadXmicro)
			throws ExcepcionesDAO {
		// TODO Auto-generated method stub

	}

	@Override
	public void modificarUnidadXmicro(TbMicUnidadesxmicro unidadXmicro)
			throws ExcepcionesDAO {
		// TODO Auto-generated method stub

	}

	@Override
	public TbMicUnidadesxmicro obtenerUnidadXmicro(String idMicrocurriculo,
			int idUnidad) throws ExcepcionesDAO {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TbMicUnidadesxmicro> listarUnidadesXmicro(
			String idMicrocurriculo) throws ExcepcionesDAO {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TbMicUnidadesxmicro> listarTodoUnidadesXmicro()
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
			Criteria criteria = session.createCriteria(TbMicUnidadesxmicro.class);
			registro = criteria.list().size();
		}catch(HibernateException e){
			throw new ExcepcionesDAO("Se produjo un Error al Intentar contar los Registros de la Tabla Unidades x Microcurriculo.");
		}
				
		
		return registro;
	}
	
	

}
