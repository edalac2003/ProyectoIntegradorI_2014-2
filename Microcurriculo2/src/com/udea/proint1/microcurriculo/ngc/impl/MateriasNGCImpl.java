package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.udea.proint1.microcurriculo.dao.MateriasDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmDependencia;
import com.udea.proint1.microcurriculo.dto.TbAdmMaterias;
import com.udea.proint1.microcurriculo.ngc.MateriasNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class MateriasNGCImpl implements MateriasNGC {
	
	private static Logger log=Logger.getLogger(MateriasNGCImpl.class);
	
	MateriasDAO materiasDao;
	//NucleoDAO nucleoDao;

	public void setMateriasDao(MateriasDAO materiasDao) {
		this.materiasDao = materiasDao;
	}

	/*public void setNucleoDao(NucleoDAO nucleoDao) {
		this.nucleoDao = nucleoDao;
	}*/

	public MateriasNGCImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void guardarMateria(TbAdmMaterias materia) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(materia == null){
			throw new ExcepcionesLogica("El objeto materias está vacio");
		}
		try {
			String id = materia.getVrIdmateria();
			TbAdmMaterias materiasConsulta = materiasDao.obtenerMateria(id);
		
			if(materiasConsulta != null){
				throw new ExcepcionesLogica("La materia a insertar ya existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenermaterias de la clase materiasDAO: "+ e);
		}
		
		try {
			
			materiasDao.guardarMateria(materia);
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo guardarDependencia de la clase dependenciaDao: "+ e);
		}
	}

	@Override
	public void actualizarMateria(TbAdmMaterias materia) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(materia == null){
			throw new ExcepcionesLogica("El objeto materias está vacio");
		}
		try {
			String id = materia.getVrIdmateria();
			TbAdmMaterias materiaConsulta = materiasDao.obtenerMateria(id);
		
			if(materiaConsulta == null){
				throw new ExcepcionesLogica("El materias a actualizar no existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerMaterias de la clase materiasDao: "+ e);
		}
		
		try {
			
			materiasDao.actualizarMateria(materia);
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo guardarDependencia de la clase dependenciaDao: "+ e);
		}
	}

	@Override
	public TbAdmMaterias obtenerMateria(String id) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el dato id no sea vacio
		 */
		if((id.endsWith(null))||(id.equals(""))){
			throw new ExcepcionesLogica("No se ha ingresado una identificación de ciudad,está vacia");
		}
		TbAdmMaterias materias = null;
		
		try {
			//le pedimos a la clase Dao que nos traiga la ciudad con dicho id
			materias = materiasDao.obtenerMateria(id);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerMaterias de la clase materiasDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(materias == null){
			//si está vacio tira una excepción
			throw new ExcepcionesLogica("No se encontró dependencia con el id "+ id);
		}else{
			//si no esta vacio retorna la ciudad
			return materias;
		}
	}

	@Override
	public List<TbAdmMaterias> listarMaterias() throws ExcepcionesLogica {
		List<TbAdmMaterias> listaMaterias = null;
		try {
			listaMaterias = materiasDao.listarMaterias();
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo listarMaterias de la clase materiasDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(listaMaterias == null){
			throw new ExcepcionesLogica("No se encontraron materias en la tabla TbAdmMaterias");
		}else{
			return listaMaterias;
		}
	}

}
