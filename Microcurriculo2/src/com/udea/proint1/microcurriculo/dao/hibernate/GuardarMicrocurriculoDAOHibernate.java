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
import com.udea.proint1.microcurriculo.dto.TbMicAutor;
import com.udea.proint1.microcurriculo.dto.TbMicAutorxbiblio;
import com.udea.proint1.microcurriculo.dto.TbMicBibliografia;
import com.udea.proint1.microcurriculo.dto.TbMicBiblioxunidad;
import com.udea.proint1.microcurriculo.dto.TbMicEvaluacion;
import com.udea.proint1.microcurriculo.dto.TbMicEvaluacionxmicro;
import com.udea.proint1.microcurriculo.dto.TbMicMicrocurriculo;
import com.udea.proint1.microcurriculo.dto.TbMicMicroxestado;
import com.udea.proint1.microcurriculo.dto.TbMicMicroxsemestre;
import com.udea.proint1.microcurriculo.dto.TbMicObjetivo;
import com.udea.proint1.microcurriculo.dto.TbMicObjetivoxmicro;
import com.udea.proint1.microcurriculo.dto.TbMicSubtema;
import com.udea.proint1.microcurriculo.dto.TbMicTema;
import com.udea.proint1.microcurriculo.dto.TbMicTemaxunidad;
import com.udea.proint1.microcurriculo.dto.TbMicUnidad;
import com.udea.proint1.microcurriculo.dto.TbMicUnidadxmicro;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class GuardarMicrocurriculoDAOHibernate extends HibernateDaoSupport implements GuardarMicrocurriculoDAO {

	private static Logger logger = Logger.getLogger(ValidarDatosCtrl.class);
	
//	@Override
//	public void guardarMicroxlotes(List<TbMicTema> temas,
//			List<TbMicTemaxunidad> temasxunidades, List<TbMicAutor> autores,
//			List<TbMicSubtema> subtemas, List<TbMicUnidad> unidades,
//			List<TbMicUnidadxmicro> unidadesxmicros,
//			List<TbMicBiblioxunidad> biblioxunidades,
//			List<TbMicAutorxbiblio> autorxbiblios,
//			List<TbMicObjetivo> objetivos,
//			List<TbMicObjetivoxmicro> objetivosxmicros,
//			List<TbMicBibliografia> bibliografia,
//			TbMicMicrocurriculo microcurriculo,
//			TbMicMicroxestado microxEstados, TbMicMicroxsemestre microxSemestre)
//			throws ExcepcionesDAO {
//		
//		System.out.println("COMPROBANDO EL CONTENIDO");
//		System.out.println("MICROCURRICULOS");
//		//System.out.println(microcurriculo.getVrIdmicrocurriculo()+" "+microcurriculo.getVrJustificacion()+
//		//		" "+microcurriculo.getVrModusuario()+" "+microcurriculo.getDtModfecha());
//		
//		
///*		Session session = null;
//		Transaction tx = null;
//		
//		try{
//			session = getSession();
//			tx = session.beginTransaction();
//			System.out.println("1");
//			
//			System.out.println("2");
//			
//			System.out.println("3");
//			
//			
//			
			
//			for(TbMicTemasxunidad temasxUnidad:temasxunidades){
//				session.save(temasxUnidad);
//			}
//			
//			for(TbMicBiblioxunidad biblioxunidad:biblioxunidades){
//				session.save(biblioxunidad);
//			}
//			
////			for(TbMicAutorxbiblio autorxbiblio:autorxbiblios){
////				session.save(autorxbiblio);
////			}
		
//			tx.commit();
//			
//		}catch(HibernateException e){
//			tx.rollback();
//			throw new ExcepcionesDAO("No fue posible guardar la información del Microcurriculo. \n Por favor verifique la información ingresada. \n" + 
//					"Cualquier cambio en la Base de Datos fue Revertido Satisfactoriamente. "+e);
//		}*/
//	}

	@Override
	public void guardarMicroxlotes(TbMicMicrocurriculo microcurriculo,
			TbMicMicroxestado microxEstado, TbMicMicroxsemestre microxSemestre,
			List<TbMicTema> temas, List<TbMicSubtema> subtemas,
			List<TbMicTemaxunidad> temasxunidad, List<TbMicAutor> autores,
			List<TbMicUnidad> unidades, List<TbMicUnidadxmicro> unidadesxmicro,
			List<TbMicObjetivo> objetivos,
			List<TbMicObjetivoxmicro> objetivosxmicro,
			List<TbMicBibliografia> bibliografia,
			List<TbMicBiblioxunidad> biblioxunidad,
			List<TbMicAutorxbiblio> autorxbiblio,
			List<TbMicEvaluacion> evaluaciones,
			List<TbMicEvaluacionxmicro> evaluacionxMicro)
			throws ExcepcionesDAO {
		
		Session session = null;
		Transaction tx = null;
		
		try {
			session = getSession();
			tx = session.beginTransaction();
			
			session.save(microcurriculo);
			session.save(microxSemestre);
			session.save(microxEstado);
			
			if (unidades != null){
				for(TbMicUnidad unidad:unidades)
					session.save(unidad);
			}
			
			if (temas != null){
				for(TbMicTema tema:temas)
					session.save(tema);	
			}
			
			if (objetivos != null){
				for(TbMicObjetivo objetivo:objetivos)
					session.save(objetivo);	
			}
			
			if (evaluaciones != null){
				for(TbMicEvaluacion evalua:evaluaciones)
					session.save(evalua);
			}
			
			if (subtemas != null){
				for(TbMicSubtema subtema:subtemas)
					session.save(subtema);
			}
			
			if (bibliografia != null){
				for(TbMicBibliografia biblio:bibliografia)
					session.save(biblio);	
			}
			
			if(autores != null){
				for(TbMicAutor autor:autores)
					session.save(autor);	
			}
			

			if (unidadesxmicro != null){
				for(TbMicUnidadxmicro unidadxmicro:unidadesxmicro)
					session.save(unidadxmicro);	
			}
			
			if(objetivosxmicro != null){
				for(TbMicObjetivoxmicro objetivoxmicro:objetivosxmicro)
					session.save(objetivoxmicro);	
			}
			
			if (temasxunidad != null){
				for(TbMicTemaxunidad temasxUnidad:temasxunidad)
					session.save(temasxUnidad);	
			}
			
			if (evaluacionxMicro != null){
				for(TbMicEvaluacionxmicro exM : evaluacionxMicro)
					session.save(exM);			
			}
					
			tx.commit();
			
		} catch (HibernateException e){
			tx.rollback();
			throw new ExcepcionesDAO("No fue posible guardar la información del Microcurriculo. \n Por favor verifique la información ingresada. \n" + 
					"Los Cambios realizados en la Base de Datos fueron Revertidos Satisfactoriamente.   "+e.getMessage());
		}
	}
	
	
	
	
	@Override
	public void guardarMicroMiniLote(TbMicMicrocurriculo microcurriculo,
			TbMicMicroxestado microxEstado, TbMicMicroxsemestre microxSemestre,
			List<TbMicObjetivo> listaObjetivos,
			List<TbMicObjetivoxmicro> listaObjetivosxMicro)
			throws ExcepcionesDAO {
			Session session = null;
			Transaction tx = null;
			
			try{
				session = getSession();
				tx = session.beginTransaction();
				
				session.save(microcurriculo);
				session.save(microxEstado);
				session.save(microxSemestre);
				for(TbMicObjetivo objetivo : listaObjetivos){
					session.save(objetivo);
				}
				
				for(TbMicObjetivoxmicro objetivoxMicro : listaObjetivosxMicro){
					session.save(objetivoxMicro);
				}
				
				tx.commit();			
			}catch(HibernateException e){
				tx.rollback();
				throw new ExcepcionesDAO("No fue posible guardar la información del Microcurriculo. \n Por favor verifique la información ingresada. \n" + 
						"Cualquier cambio en la Base de Datos fue Revertido Satisfactoriamente. "+e);
			}		
	}

	
}
