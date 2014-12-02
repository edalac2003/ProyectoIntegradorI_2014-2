package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.udea.proint1.microcurriculo.ctrl.ValidarDatosCtrl;
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

	private static Logger logger = Logger.getLogger(ValidarDatosCtrl.class);
	
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
		
		System.out.println("COMPROBANDO EL CONTENIDO");
		System.out.println("MICROCURRICULOS");
		//System.out.println(microcurriculo.getVrIdmicrocurriculo()+" "+microcurriculo.getVrJustificacion()+
		//		" "+microcurriculo.getVrModusuario()+" "+microcurriculo.getDtModfecha());
		
		
/*		Session session = null;
		Transaction tx = null;
		
		try{
			session = getSession();
			tx = session.beginTransaction();
			System.out.println("1");
			session.save(microcurriculo);
			
			System.out.println("2");
			session.save(microxEstados);
			System.out.println("3");
			session.save(microxSemestre);
			
			for(TbMicTemas tema:temas){
				session.save(tema);
			}
			
			for(TbMicBibliografia biblio:bibliografia){
				session.save(biblio);
			}
			
			for(TbMicSubtemas subtema:subtemas){
				session.save(subtema);
			}
			
//			for(TbMicAutores autor:autores){
//				session.save(autor);
//			}
			
			for(TbMicUnidades unidad:unidades){
				session.save(unidad);
			}
			
			for(TbMicTemasxunidad temasxUnidad:temasxunidades){
				session.save(temasxUnidad);
			}
			
			for(TbMicBiblioxunidad biblioxunidad:biblioxunidades){
				session.save(biblioxunidad);
			}
			
//			for(TbMicAutorxbiblio autorxbiblio:autorxbiblios){
//				session.save(autorxbiblio);
//			}
			
			for(TbMicUnidadesxmicro unidadesxmicro:unidadesxmicros){
				session.save(unidadesxmicro);
			}
			
			for(TbMicObjetivos objetivo:objetivos){
				session.save(objetivo);
			}
			
			for(TbMicObjetivosxmicro objetivosxmicro:objetivosxmicros){
				session.save(objetivosxmicro);
			}
			
			tx.commit();
			
		}catch(HibernateException e){
			tx.rollback();
			throw new ExcepcionesDAO("No fue posible guardar la información del Microcurriculo. \n Por favor verifique la información ingresada. \n" + 
					"Cualquier cambio en la Base de Datos fue Revertido Satisfactoriamente. "+e);
		}*/
	}

	
	@Override
	public void guardarMicroMiniLote(TbMicMicrocurriculos microcurriculo,
			TbMicMicroxestado microxEstado, TbMicMicroxsemestre microxSemestre,
			List<TbMicObjetivos> listaObjetivos,
			List<TbMicObjetivosxmicro> listaObjetivosxMicro)
			throws ExcepcionesDAO {
/*		Session session = null;
		Transaction tx = null;
		
		try{
			session = getSession();
			tx = session.beginTransaction();
			
			session.save(microcurriculo);
			session.save(microxEstado);
			session.save(microxSemestre);
			for(TbMicObjetivos objetivo : listaObjetivos){
				session.save(objetivo);
			}
			
			for(TbMicObjetivosxmicro objetivoxMicro : listaObjetivosxMicro){
				session.save(objetivoxMicro);
			}
			
			tx.commit();			
		}catch(HibernateException e){
			tx.rollback();
			throw new ExcepcionesDAO("No fue posible guardar la información del Microcurriculo. \n Por favor verifique la información ingresada. \n" + 
					"Cualquier cambio en la Base de Datos fue Revertido Satisfactoriamente. "+e);
		}	*/	
	}
}
