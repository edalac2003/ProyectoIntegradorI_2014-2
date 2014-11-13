package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.EstadosDAO;
import com.udea.proint1.microcurriculo.dto.TbMicEstados;
import com.udea.proint1.microcurriculo.dto.TbMicEvaluaciones;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class EstadosDAOHibernate extends HibernateDaoSupport implements EstadosDAO {

	public EstadosDAOHibernate() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void guardarEstado(TbMicEstados estado) throws ExcepcionesDAO {
		// TODO Auto-generated method stub

	}

	@Override
	public TbMicEstados obtenerEstado(int idEstado) throws ExcepcionesDAO {
		TbMicEstados estado = null;
		Session session = null;
		
		try{
			session = getSession();
			estado = (TbMicEstados)session.load(TbMicEstados.class, idEstado);
			
		}catch(HibernateException e){
			throw new ExcepcionesDAO();
		}
		
		return estado;
	}
	
	

	@Override
	public TbMicEstados obtenerEstadoxNombre(String nombre)
			throws ExcepcionesDAO {
		List<TbMicEstados> listaEstados = new ArrayList<TbMicEstados>();
		TbMicEstados estado = null;
		Session session = null;
		
		try{
			session = getSession();
			Query query = session.createQuery("FROM TbMicEstados tb where tb.vrDescripcion =:nombre");
			
			listaEstados = query.list();
			
		}catch(HibernateException e){
			throw new ExcepcionesDAO();
		}
		
		if(listaEstados != null){
			estado = listaEstados.get(0);
		}
		
		return estado;
	}

	@Override
	public List<TbMicEstados> listarEstados() throws ExcepcionesDAO {
		Session session = null;
		List<TbMicEstados> estados = new ArrayList<TbMicEstados>();
		
		try{
			session = getSession();
			Criteria criteria = session.createCriteria(TbMicEstados.class);
			estados = criteria.list();			
		}catch(HibernateException e){
			throw new ExcepcionesDAO();
		}
		
		return estados;
	}

}
