package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.udea.proint1.microcurriculo.dao.MicrocurriculosDAO;
import com.udea.proint1.microcurriculo.dao.ObjetivosDAO;
import com.udea.proint1.microcurriculo.dao.ObjetivosxMicroDAO;
import com.udea.proint1.microcurriculo.dto.TbMicBiblioxunidad;
import com.udea.proint1.microcurriculo.dto.TbMicMicrocurriculos;
import com.udea.proint1.microcurriculo.dto.TbMicObjetivosxmicro;
import com.udea.proint1.microcurriculo.dto.TbMicUnidades;
import com.udea.proint1.microcurriculo.ngc.BiblioxunidadNGC;
import com.udea.proint1.microcurriculo.ngc.ObjetivosxMicroNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class ObjetivosxMicroNGCImpl implements ObjetivosxMicroNGC {

	private static Logger log=Logger.getLogger(ObjetivosxMicroNGC.class);
	
	ObjetivosxMicroDAO objetivosxMicroDao;
	
	MicrocurriculosDAO microcurriculosDao;
	
	ObjetivosDAO objetivosDao;
		
	public void setObjetivosxMicroDao(ObjetivosxMicroDAO objetivosxMicroDao) {
		this.objetivosxMicroDao = objetivosxMicroDao;
	}

	public void setMicrocurriculosDao(MicrocurriculosDAO microcurriculosDao) {
		this.microcurriculosDao = microcurriculosDao;
	}

	public void setObjetivosDao(ObjetivosDAO objetivosDao) {
		this.objetivosDao = objetivosDao;
	}

	@Override
	public void guardarObjetivosxMicro(TbMicObjetivosxmicro objetivoxMicro)	throws ExcepcionesLogica {
		TbMicObjetivosxmicro objetivosxMicroTMP = null;
		
		if(objetivoxMicro != null){
			try {
				objetivosxMicroTMP = objetivosxMicroDao.obtenerObjetivoxMicro(objetivoxMicro.getNbId());
			} catch (ExcepcionesDAO e) {
				throw new ExcepcionesLogica("Error al intentar obtener el objeto <ObjetivoxMicro>");
			}
		}else{
			throw new ExcepcionesLogica("El Objeto <ObjetivoxMicro> est� vacio.");
		}
		
		if(objetivosxMicroTMP == null){
			try {
				objetivosxMicroDao.guardarObjetivosxMicro(objetivoxMicro);
			} catch (ExcepcionesDAO e) {
				throw new ExcepcionesLogica("Error al intentar guardar el objeto <ObjetivoxMicro>");
			}
		}else{
			throw new ExcepcionesLogica("El objeto <ObjetivoxMicro> ya Existe.");
		}
	}

	/*@Override
	public void guardarObjetivosxMicro(List<TbMicObjetivosxmicro> listaObjetivoxMicro) throws ExcepcionesLogica {
		if (listaObjetivoxMicro != null){
			for(TbMicObjetivosxmicro objetivoxMicro : listaObjetivoxMicro){
				guardarObjetivosxMicro(objetivoxMicro);				
			}
		}else{
			throw new ExcepcionesLogica("El objeto <Lista ObjetivoxMicrocurriculo no tiene informaci�n v�lida.");
		}
	}*/

	@Override
	public void modificarObjetivoxMicro(TbMicObjetivosxmicro objetivoxMicro)throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(objetivoxMicro == null){
			throw new ExcepcionesLogica("El objeto objetivoxMicro está vacio");
		}
		try {
			int id = objetivoxMicro.getNbId();
			TbMicObjetivosxmicro biblioxUnidadConsulta = objetivosxMicroDao.obtenerObjetivoxMicro(id);
		
			if(biblioxUnidadConsulta == null){
				throw new ExcepcionesLogica("El Objetivo x micro a actualizar no existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerObjetivoxMicro de la clase objetivosxMicroDao: "+ e);
		}
		
		try {
			
			objetivosxMicroDao.modificarObjetivoxMicro(objetivoxMicro);
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo modificarObjetivoxMicro de la clase objetivosxMicroDao: "+ e);
		}
	}

	@Override
	public TbMicObjetivosxmicro obtenerObjetivoxMicro(int id) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el dato id no sea vacio
		 */
		if(id == 0){
			throw new ExcepcionesLogica("No se ha ingresado una identificación de objetivosxMicro, está vacia");
		}
		TbMicObjetivosxmicro objetivosxMicro = null;
		
		try {
			//le pedimos a la clase Dao que nos traiga la ciudad con dicho id
			objetivosxMicro = objetivosxMicroDao.obtenerObjetivoxMicro(id);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerObjetivoxMicro de la clase objetivosxMicroDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(objetivosxMicro == null){
			//si está vacio tira una excepción
			throw new ExcepcionesLogica("No se encontró Objetivos x Micro con el id "+ id);
		}else{
			//si no esta vacio retorna la ciudad
			return objetivosxMicro;
		}
	}
	
	@Override
	public TbMicObjetivosxmicro obtenerObjetivosxMicroxObjetivo(int idObjetivo) throws ExcepcionesLogica {
		TbMicObjetivosxmicro objetivoxMicro = null;
		
		try {
			objetivoxMicro = objetivosxMicroDao.obtenerObjetivoxMicro(idObjetivo);
			if (objetivoxMicro != null)
				return objetivoxMicro;
			else
				return null;
			
		} catch (ExcepcionesDAO e) {
			throw new ExcepcionesLogica("Error al intentar objetener el Objeto <ObjetivoxMicrocurriculo>");
		}
		
	}

	@Override
	public List<TbMicObjetivosxmicro> listarObjetivosxMicro()
			throws ExcepcionesLogica {
		List<TbMicObjetivosxmicro> listaObjetivosxMicro = null;
		try {
			listaObjetivosxMicro = objetivosxMicroDao.listarObjetivosxMicro();
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo listarObjetivosxMicro de la clase objetivosxMicroDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(listaObjetivosxMicro == null){
			throw new ExcepcionesLogica("No se encontraron objetivos x microcurriculos en la tabla TbMicObjetivosxmicro");
		}else{
			return listaObjetivosxMicro;
		}
	}

	@Override
	public List<TbMicObjetivosxmicro> obtenerObjetivosxMicroxMicro(
			String idMicrocurriculo) throws ExcepcionesLogica {
		List<TbMicObjetivosxmicro> listaObjetivosxMicro = null;
		
		TbMicMicrocurriculos microcurriculo= null;
		
		try {
			microcurriculo = microcurriculosDao.obtenerMicrocurriculo(idMicrocurriculo);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerMicrocurriculo de la clase microcurriculosDao: "+ e);
		}
		
		
		try {
			listaObjetivosxMicro = objetivosxMicroDao.obtenerObjetivosxMicroxMicro(microcurriculo);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerObjetivosxMicroxMicro de la clase objetivosxMicroDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		return listaObjetivosxMicro;
	}

	@Override
	public int contarRegistros() throws ExcepcionesLogica {
		int registro = 0;
		
		try {
			registro = objetivosxMicroDao.contarRegistros();
		} catch (ExcepcionesDAO e) {
			throw new ExcepcionesLogica("Se presentaron error al Obtener el numero de Registros de la Tabla Objetivos x Microcurriculo.");
		}		
		
		return registro;
	}

}
