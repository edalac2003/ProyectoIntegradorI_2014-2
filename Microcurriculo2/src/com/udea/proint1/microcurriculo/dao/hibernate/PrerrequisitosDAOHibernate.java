package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.PrerrequisitosDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmCorrequisitos;
import com.udea.proint1.microcurriculo.dto.TbAdmMaterias;
import com.udea.proint1.microcurriculo.dto.TbAdmPrerrequisitos;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class PrerrequisitosDAOHibernate extends HibernateDaoSupport implements PrerrequisitosDAO {

	public PrerrequisitosDAOHibernate() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<TbAdmPrerrequisitos> listarPrerrequisitosxMateria(TbAdmMaterias materia) throws ExcepcionesDAO {
		Session session = null;
        List<TbAdmPrerrequisitos> prerrequisitos = new ArrayList<TbAdmPrerrequisitos>();
       
        try{
               
                session = getSession();	
                               
                Query query = session.createQuery("from TbAdmPrerrequisitos where tbAdmMateriasByVrMateria = :materia");
               
                query.setEntity("materia", materia);
               
                prerrequisitos = query.list();
                
        }catch(HibernateException e){
                throw new ExcepcionesDAO(e);
        }
        return prerrequisitos;
	}

	@Override
	public List<TbAdmPrerrequisitos> listarPrerrequisitos()
			throws ExcepcionesDAO {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TbAdmPrerrequisitos obtenerPrerrequisito() throws ExcepcionesDAO {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void guardarPrerrequisito(TbAdmPrerrequisitos prerrequisito)
			throws ExcepcionesDAO {
		// TODO Auto-generated method stub

	}

	@Override
	public void actualizarPrerrequisito(TbAdmPrerrequisitos prerrequisito)
			throws ExcepcionesDAO {
		// TODO Auto-generated method stub

	}

}
