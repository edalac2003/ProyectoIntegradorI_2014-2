package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.ObjetivoxMicroDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmPersona;
import com.udea.proint1.microcurriculo.dto.TbAdmUnidadAcademica;
import com.udea.proint1.microcurriculo.dto.TbMicMicrocurriculo;
import com.udea.proint1.microcurriculo.dto.TbMicObjetivo;
import com.udea.proint1.microcurriculo.dto.TbMicObjetivoxmicro;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class ObjetivoxMicroDAOHibernate extends HibernateDaoSupport implements ObjetivoxMicroDAO {

	public ObjetivoxMicroDAOHibernate() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void guardarObjetivosxMicro(TbMicObjetivoxmicro objetivoxMicro)	throws ExcepcionesDAO {
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
	public void modificarObjetivoxMicro(TbMicObjetivoxmicro objetivoxMicro)
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
	public TbMicObjetivoxmicro obtenerObjetivoxMicro(int id) throws ExcepcionesDAO {
		Session session = null;
		TbMicObjetivoxmicro objetivosxMicro = null;

		try {
			session = getSession();
			objetivosxMicro = (TbMicObjetivoxmicro) session.load(TbMicObjetivoxmicro.class, id);

		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		}
		return objetivosxMicro;
	}
	

	@Override
	public List<TbMicObjetivoxmicro> obtenerObjetivosxMicroxObjetivo(TbMicObjetivo objetivo) throws ExcepcionesDAO {
		Session session = null;
        List<TbMicObjetivoxmicro> objetivosxMicro = new ArrayList<TbMicObjetivoxmicro>();
       
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
	public List<TbMicObjetivoxmicro> obtenerObjetivosxMicroxMicro(
			TbMicMicrocurriculo microcurriculo) throws ExcepcionesDAO {
		Session session = null;
        List<TbMicObjetivoxmicro> objetivosxMicro = new ArrayList<TbMicObjetivoxmicro>();
       
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
	public List<TbMicObjetivoxmicro> listarObjetivosxMicro()
			throws ExcepcionesDAO {
		Session session = null;
        List<TbMicObjetivoxmicro> objetivosxMicro = new ArrayList<TbMicObjetivoxmicro>();
        
		try {
			session = getSession();
			Criteria criteria = session.createCriteria(TbMicObjetivoxmicro.class);
			
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
			Criteria criteria = session.createCriteria(TbMicObjetivoxmicro.class);
			registro = criteria.list().size();
			
		}catch(HibernateException e){
			throw new ExcepcionesDAO("Se produjo un error al calcular los Registros de la Tabla Objetivos x Microcurriculo. "+e);			
		}		
		return registro;
	}

}
