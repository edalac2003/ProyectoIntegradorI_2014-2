package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.UsuariosDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmUnidadAcademica;
import com.udea.proint1.microcurriculo.dto.TbAdmUsuarios;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class UsuariosDAOHibernate extends HibernateDaoSupport implements UsuariosDAO {

	@Override
	public void guardarUsuarios(TbAdmUsuarios usuario) throws ExcepcionesDAO {
		Session session = null;

		try {
			session = getSession();
			session.save(usuario);
			session.flush(); 
		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		}
	}

	@Override
	public TbAdmUsuarios obtenerUsuarios(int id) throws ExcepcionesDAO {
		Session session = null;
		TbAdmUsuarios usuario = null;

		try {
			session = getSession();
			usuario = (TbAdmUsuarios) session.load(TbAdmUsuarios.class, id);

		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		}
		return usuario;
	}

	@Override
	public List<TbAdmUsuarios> listarUsuarios() throws ExcepcionesDAO {
		Session session = null;
        List<TbAdmUsuarios> usuarios = new ArrayList<TbAdmUsuarios>();
        
		try {
			session = getSession();
			Criteria criteria = session.createCriteria(TbAdmUsuarios.class);
			
			usuarios = criteria.list();
		}catch(HibernateException e){
			throw new ExcepcionesDAO(e);
			
		}
		return usuarios;
	}

	@Override
	public void actualizarUsuarios(TbAdmUsuarios usuario) throws ExcepcionesDAO {
		Session session = null;

		try {
			session = getSession();
			this.getHibernateTemplate().update(usuario);

		} catch (HibernateException e) {
			throw new ExcepcionesDAO(e);
		}
	}

}
