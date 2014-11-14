package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.MicroxEstadoDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmPersona;
import com.udea.proint1.microcurriculo.dto.TbMicEstados;
import com.udea.proint1.microcurriculo.dto.TbMicMicroxestado;
import com.udea.proint1.microcurriculo.dto.TbMicMicroxsemestre;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class MicroxEstadoDAOHibernate extends HibernateDaoSupport implements MicroxEstadoDAO {

	@Override
	public void guardarMicroxestado(TbMicMicroxestado microxEstado)
			throws ExcepcionesDAO {
		Session session = null;
		
		try{
			session = getSession();
			
			session = getSession();
			session.save(microxEstado);
			session.flush();
			
		}catch(HibernateException e){
			
		}

	}

	@Override
	public void actualizarMicroxestado(TbMicMicroxestado microxEstado)
			throws ExcepcionesDAO {
		Session session = null;

		try {
			session = getSession();

			session = getSession();
			this.getHibernateTemplate().update(microxEstado);

		} catch (HibernateException e) {
			throw new ExcepcionesDAO("No se pudo ejecutar la operacion DAO, Actualizar");
		}
	}

	@Override
	public TbMicMicroxestado obtenerMicroxestado(int id) throws ExcepcionesDAO {
		Session session = null;
		TbMicMicroxestado microxEstado = null;
		
		try{
			session = getSession();
			microxEstado = (TbMicMicroxestado)session.load(TbMicMicroxestado.class, id);
			
		}catch(HibernateException e){
			throw new ExcepcionesDAO();
		}
		return microxEstado;
	}

	@Override
	public List<TbMicMicroxestado> listarMicroxestado() throws ExcepcionesDAO {
		Session session = null;
		List<TbMicMicroxestado> microsxestado = new ArrayList<TbMicMicroxestado>();
		
		try{
			session = getSession();
			Criteria criteria = session.createCriteria(TbMicMicroxestado.class);
			microsxestado = criteria.list();			
		}catch(HibernateException e){
			throw new ExcepcionesDAO();
		}
		
		return microsxestado;
	}

	@Override
	public List<TbMicMicroxestado> listarMicrosxestado(TbMicEstados estado) throws ExcepcionesDAO {
		Session session = null;
		List<TbMicMicroxestado> microsxEstado = new ArrayList<TbMicMicroxestado>();
        try{
               
        	session = getSession();
            
        	Query query = session.createQuery("from TbMicMicroxestado where tbMicEstados = :estado");
               
        	query.setEntity("estado", estado);
               
        	microsxEstado = query.list();
            
        }catch(HibernateException e){
                throw new ExcepcionesDAO(e);
        }
		return microsxEstado;
	}

}
