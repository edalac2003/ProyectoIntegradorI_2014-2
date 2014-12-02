package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.ObjetivosxMicroDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmPersona;
import com.udea.proint1.microcurriculo.dto.TbAdmUnidadAcademica;
import com.udea.proint1.microcurriculo.dto.TbMicMicrocurriculos;
import com.udea.proint1.microcurriculo.dto.TbMicObjetivos;
import com.udea.proint1.microcurriculo.dto.TbMicObjetivosxmicro;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class ObjetivosxMicroDAOHibernate extends HibernateDaoSupport implements ObjetivosxMicroDAO {

	public ObjetivosxMicroDAOHibernate() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void guardarObjetivosxMicro(TbMicObjetivosxmicro objetivoxMicro)	throws ExcepcionesDAO {
		Session session = null;

		try {
			session = getSession();
			session.save(objetivoxMicro);
			session.flush(); 
		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		}
	}

	@Override
	public void modificarObjetivoxMicro(TbMicObjetivosxmicro objetivoxMicro)
			throws ExcepcionesDAO {
		Session session = null;

		try {
			session = getSession();
			this.getHibernateTemplate().update(objetivoxMicro);

		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		}
	}

	@Override
	public TbMicObjetivosxmicro obtenerObjetivoxMicro(int id) throws ExcepcionesDAO {
		Session session = null;
		TbMicObjetivosxmicro objetivosxMicro = null;

		try {
			session = getSession();
			objetivosxMicro = (TbMicObjetivosxmicro) session.load(TbMicObjetivosxmicro.class, id);

		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		}
		return objetivosxMicro;
	}
	

	@Override
	public List<TbMicObjetivosxmicro> obtenerObjetivosxMicroxObjetivo(TbMicObjetivos objetivo) throws ExcepcionesDAO {
		Session session = null;
        List<TbMicObjetivosxmicro> objetivosxMicro = new ArrayList<TbMicObjetivosxmicro>();
       
        try{
               
        	session = getSession();
                               
        	Query query = session.createQuery("from TbMicObjetivosxmicro where tbMicObjetivos = :objetivo");
               
        	query.setEntity("objetivo", objetivo);
               
        	objetivosxMicro = query.list();
        }catch(HibernateException e){
                throw new ExcepcionesDAO(e);
        }
        return objetivosxMicro;
	}
	
	@Override
	public List<TbMicObjetivosxmicro> obtenerObjetivosxMicroxMicro(
			TbMicMicrocurriculos microcurriculo) throws ExcepcionesDAO {
		Session session = null;
        List<TbMicObjetivosxmicro> objetivosxMicro = new ArrayList<TbMicObjetivosxmicro>();
       
        try{
               
        	session = getSession();
                               
        	Query query = session.createQuery("from TbMicObjetivosxmicro where tbMicMicrocurriculos = :microcurriculo");
               
        	query.setEntity("microcurriculo", microcurriculo);
               
        	objetivosxMicro = query.list();
        }catch(HibernateException e){
                throw new ExcepcionesDAO(e);
        }
        return objetivosxMicro;
	}
	
	@Override
	public List<TbMicObjetivosxmicro> listarObjetivosxMicro()
			throws ExcepcionesDAO {
		Session session = null;
        List<TbMicObjetivosxmicro> objetivosxMicro = new ArrayList<TbMicObjetivosxmicro>();
        
		try {
			session = getSession();
			Criteria criteria = session.createCriteria(TbMicObjetivosxmicro.class);
			
			objetivosxMicro = criteria.list();
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
			
		}
		return objetivosxMicro;
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
			throw new ExcepcionesDAO("Se produjo un error al calcular los Registros de la Tabla Objetivos x Microcurriculo. "+e);			
		}		
		return registro;
	}

}
