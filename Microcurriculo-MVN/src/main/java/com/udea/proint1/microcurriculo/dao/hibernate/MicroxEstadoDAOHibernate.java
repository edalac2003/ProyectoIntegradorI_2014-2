package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.MicroxEstadoDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmPersona;
import com.udea.proint1.microcurriculo.dto.TbMicEstado;
import com.udea.proint1.microcurriculo.dto.TbMicMicroxestado;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class MicroxEstadoDAOHibernate extends HibernateDaoSupport implements MicroxEstadoDAO {

	@Override
	public void guardarMicroxestado(TbMicMicroxestado microxEstado) throws ExcepcionesDAO {
		Session session = null;

		try {
			session = getSession();
			session.save(microxEstado);
			session.flush(); 
		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		}
	}
	
	@Override
	public void actualizarMicroxestado(TbMicMicroxestado microxEstado)
			throws ExcepcionesDAO {
		Session session = null;

		try {
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
			throw new ExcepcionesDAO(e);
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
			throw new ExcepcionesDAO(e);
		}
		
		return microsxestado;
	}

	@Override
	public List<TbMicMicroxestado> listarMicrosxestado(TbMicEstado estado) throws ExcepcionesDAO {
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
	

	@Override
	public int contarRegistros() throws ExcepcionesDAO {
		int registro = 0;
		Session session = null;
		
		try{
			session = getSession();
			Query query =  session.createQuery("select count(*) from TbMicMicroxestado");
			registro = Integer.parseInt(query.uniqueResult().toString());
		}catch(HibernateException e){
			throw new ExcepcionesDAO("DAO : Error al Contar el numero de registros de la Tabla MicroxEstado.");
		}
	
		return registro;
	}
	
	

}
