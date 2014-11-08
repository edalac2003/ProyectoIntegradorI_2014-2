package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.dao.GuardarMicrocurriculoDAO;
import com.udea.proint1.microcurriculo.dto.TbMicAutores;
import com.udea.proint1.microcurriculo.dto.TbMicAutorxbiblio;
import com.udea.proint1.microcurriculo.dto.TbMicBibliografia;
import com.udea.proint1.microcurriculo.dto.TbMicBiblioxunidad;
import com.udea.proint1.microcurriculo.dto.TbMicMicrocurriculos;
import com.udea.proint1.microcurriculo.dto.TbMicMicroxestado;
import com.udea.proint1.microcurriculo.dto.TbMicMicroxsemestre;
import com.udea.proint1.microcurriculo.dto.TbMicObjetivos;
import com.udea.proint1.microcurriculo.dto.TbMicObjetivosxmicro;
import com.udea.proint1.microcurriculo.dto.TbMicSubtemas;
import com.udea.proint1.microcurriculo.dto.TbMicTemas;
import com.udea.proint1.microcurriculo.dto.TbMicTemasxunidad;
import com.udea.proint1.microcurriculo.dto.TbMicUnidades;
import com.udea.proint1.microcurriculo.dto.TbMicUnidadesxmicro;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class GuardarMicrocurriculoDAOHibernate extends HibernateDaoSupport implements GuardarMicrocurriculoDAO {

	public GuardarMicrocurriculoDAOHibernate() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void guardarMicroxlotes(List<TbMicTemas> temas,
			List<TbMicTemasxunidad> temasxunidades, List<TbMicAutores> autores,
			List<TbMicSubtemas> subtemas, List<TbMicUnidades> unidades,
			List<TbMicUnidadesxmicro> unidadesxmicros,
			List<TbMicBiblioxunidad> biblioxunidades,
			List<TbMicAutorxbiblio> autorxbiblios,
			List<TbMicObjetivos> objetivos,
			List<TbMicObjetivosxmicro> objetivosxmicros,
			List<TbMicBibliografia> bibliografia,
			TbMicMicrocurriculos microcurriculo,
			TbMicMicroxestado microxEstados, TbMicMicroxsemestre microxSemestre)
			throws ExcepcionesDAO {
		
		Session session = null;
		Transaction tx = null;
		
		try{
			session = getSession();
			tx = session.beginTransaction();
			
			session.save(microcurriculo);
			
			for(TbMicTemas tema:temas){
				session.save(tema);
			}
			for(TbMicBibliografia biblio:bibliografia){
				session.save(biblio);
			}
			for(TbMicSubtemas subtema:subtemas){
				session.save(subtema);
			}
			for(TbMicAutores autor:autores){
				session.save(autor);
			}
			for(TbMicUnidades unidad:unidades){
				session.save(unidad);
			}
			for(TbMicTemasxunidad temasxUnidad:temasxunidades){
				session.save(temasxUnidad);
			}
			for(TbMicBiblioxunidad biblioxunidad:biblioxunidades){
				session.save(biblioxunidad);
			}
			for(TbMicAutorxbiblio autorxbiblio:autorxbiblios){
				session.save(autorxbiblio);
			}
			for(TbMicUnidadesxmicro unidadesxmicro:unidadesxmicros){
				session.save(unidadesxmicro);
			}
			for(TbMicObjetivos objetivo:objetivos){
				session.save(objetivo);
			}
			for(TbMicObjetivosxmicro objetivosxmicro:objetivosxmicros){
				session.save(objetivosxmicro);
			}
			
			session.save(microxEstados);
			
			session.save(microxSemestre);

			tx.commit();
			
		}catch(HibernateException e){
			tx.rollback();
		}

	}

}
