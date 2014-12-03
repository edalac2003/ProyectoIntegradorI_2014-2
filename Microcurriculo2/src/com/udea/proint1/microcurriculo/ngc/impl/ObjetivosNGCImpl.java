package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.udea.proint1.microcurriculo.dao.MicrocurriculosDAO;
import com.udea.proint1.microcurriculo.dao.ObjetivosDAO;
import com.udea.proint1.microcurriculo.dto.TbMicBiblioxunidad;
import com.udea.proint1.microcurriculo.dto.TbMicMicrocurriculos;
import com.udea.proint1.microcurriculo.dto.TbMicObjetivos;
import com.udea.proint1.microcurriculo.dto.TbMicUnidades;
import com.udea.proint1.microcurriculo.ngc.ObjetivosNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class ObjetivosNGCImpl implements ObjetivosNGC {

	private static Logger log=Logger.getLogger(ObjetivosNGCImpl.class);
	
	ObjetivosDAO objetivosDao;
	
	MicrocurriculosDAO microcurriculosDAO;
	
	public void setObjetivosDao(ObjetivosDAO objetivosDao) {
		this.objetivosDao = objetivosDao;
	}

	public void setMicrocurriculosDAO(MicrocurriculosDAO microcurriculosDAO) {
		this.microcurriculosDAO = microcurriculosDAO;
	}

	public ObjetivosNGCImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public TbMicObjetivos obtenerObjetivo(int id)
			throws ExcepcionesLogica {
		/*
		 * Comprobamos que el dato id no sea vacio
		 */
		if(id == 0){
			throw new ExcepcionesLogica("No se ha ingresado una identificación de objetivo, está vacia");
		}
		TbMicObjetivos objetivo = null;
		
		try {
			//le pedimos a la clase Dao que nos traiga la ciudad con dicho id
			objetivo = objetivosDao.obtenerObjetivo(id);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerObjetivo de la clase objetivosDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(objetivo == null){
			//si está vacio tira una excepción
			throw new ExcepcionesLogica("No se encontró objetivo con el id "+ id);
		}else{
			//si no esta vacio retorna la ciudad
			return objetivo;
		}
	}

	@Override
	public void guardarObjetivo(TbMicObjetivos objetivo) throws ExcepcionesLogica {
		TbMicObjetivos objetivosTMP = null;
		
		if (objetivo != null){
			
			try {
				objetivosTMP = objetivosDao.obtenerObjetivo(objetivo.getNbIdobjetivo());		
			} catch (ExcepcionesDAO e) {
				throw new ExcepcionesLogica("No fue posible comprobar la existencia del Obejtivo.");
			}
			if (objetivosTMP == null){
				try {
					objetivosDao.guardarObjetivo(objetivo);
				} catch (ExcepcionesDAO e) {
					throw new ExcepcionesLogica("Se presentaron problemas al momento de intentar Guardar el registor <OBJETIVO>");
				}
			}else {
				throw new ExcepcionesLogica("El objeto de tipo <Objetivo> ya se Encuentra en la Base de Datos.");
			}
		} else {
			throw new ExcepcionesLogica("EL Objeto <Objetivo> est� vacio.");
		}
	}

/*		
	@Override
	public void guardarObjetivos(List<TbMicObjetivos> listaObjetivo) throws ExcepcionesLogica {
		if (listaObjetivo != null){
			for(TbMicObjetivos objetivo:listaObjetivo){
				guardarObjetivos(objetivo);
			}
		} else{
			throw new ExcepcionesLogica("El objeto <Lista Objetivos> no tiene informaci�n v�lida.");
		}
	}
*/
	
	@Override
	public void actualizarObjetivos(TbMicObjetivos objetivo)
			throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(objetivo == null){
			throw new ExcepcionesLogica("El objeto objetivo está vacio");
		}
		try {
			int id = objetivo.getNbIdobjetivo();
			TbMicObjetivos objetivoConsulta = objetivosDao.obtenerObjetivo(id);
		
			if(objetivoConsulta == null){
				throw new ExcepcionesLogica("El Objetivo a actualizar no existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerObjetivo de la clase objetivosDao: "+ e);
		}
		
		try {
			
			objetivosDao.modificarObjetivo(objetivo);;
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo modificarObjetivo de la clase objetivosDao: "+ e);
		}
	}

	@Override
	public List<TbMicObjetivos> listarObjetivos() throws ExcepcionesLogica {
		List<TbMicObjetivos> listaObjetivos = null;
		try {
			listaObjetivos = objetivosDao.listarObjetivos();
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo listarObjetivos de la clase objetivosDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(listaObjetivos == null){
			throw new ExcepcionesLogica("No se encontraron objetivos en la tabla TbMicObjetivos");
		}else{
			return listaObjetivos;
		}
	}

	@Override
	public int numeroRegistros() throws ExcepcionesLogica {
		int numeroRegistro = 0;
		try {
			numeroRegistro = objetivosDao.numeroRegistros();
		} catch (ExcepcionesDAO e) {
			e.printStackTrace();
		}
		
		return numeroRegistro;
	}

	@Override
	public List<TbMicObjetivos> listarObjetivosPorMicrocurriculo(String idMicrocurriculo) throws ExcepcionesLogica{
		List<TbMicObjetivos> listaObjetivos = null;
		
		TbMicMicrocurriculos microcurriculo = null;
		
		try {
			microcurriculo = microcurriculosDAO.obtenerMicrocurriculo(idMicrocurriculo);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerMicrocurriculo de la clase microcurriculosDAO: "+ e);
		}
		
		try {
			listaObjetivos = objetivosDao.listarObjetivosPorMicrocurriculo(microcurriculo);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo listarObjetivosPorMicrocurriculo(TbMicMicrocurriculos) de la clase objetivosDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		return listaObjetivos;
	}
	
	@Override
	public List<TbMicObjetivos> listarObjetivosPorTipo(char tipo) throws ExcepcionesLogica{
		List<TbMicObjetivos> listaObjetivos = null;
		
		try {
			listaObjetivos = objetivosDao.listarObjetivosPorTipo(tipo);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo listarObjetivosPorTipo(char tipo) de la clase objetivosDao: "+ e);
		}
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		return listaObjetivos;
	}
	
}
