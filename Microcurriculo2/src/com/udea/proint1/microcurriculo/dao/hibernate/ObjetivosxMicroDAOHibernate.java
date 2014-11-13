package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.ObjetivosxMicroDAO;
import com.udea.proint1.microcurriculo.dto.TbMicObjetivosxmicro;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class ObjetivosxMicroDAOHibernate extends HibernateDaoSupport implements ObjetivosxMicroDAO {

	public ObjetivosxMicroDAOHibernate() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void guardarObjetivosxMicro(TbMicObjetivosxmicro objetivoxMicro)
			throws ExcepcionesDAO {
		// TODO Auto-generated method stub

	}

	@Override
	public void modificarObjetivoxMicro(TbMicObjetivosxmicro objetivoxMicro)
			throws ExcepcionesDAO {
		// TODO Auto-generated method stub

	}

	@Override
	public TbMicObjetivosxmicro obtenerObjetivoxMicro(String idMicrocurriculo,
			int idObjetivo) throws ExcepcionesDAO {
		// TODO Auto-generated method stub
		return null;
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
