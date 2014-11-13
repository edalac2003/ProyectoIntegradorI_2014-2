package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.udea.proint1.microcurriculo.dao.MateriasDAO;
import com.udea.proint1.microcurriculo.dao.MicrocurriculosDAO;
import com.udea.proint1.microcurriculo.dao.NucleoDAO;
import com.udea.proint1.microcurriculo.dao.PersonaDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmCorrequisitos;
import com.udea.proint1.microcurriculo.dto.TbAdmDependencia;
import com.udea.proint1.microcurriculo.dto.TbAdmMaterias;
import com.udea.proint1.microcurriculo.dto.TbAdmNucleo;
import com.udea.proint1.microcurriculo.dto.TbAdmPersona;
import com.udea.proint1.microcurriculo.dto.TbMicMicrocurriculos;
import com.udea.proint1.microcurriculo.ngc.MicrocurriculosNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class MicrocurriculosNGCImpl implements MicrocurriculosNGC {

	private static Logger log=Logger.getLogger(DependenciaNGCImpl.class);

	MicrocurriculosDAO microcurriculosDao;
	
	MateriasDAO materiasDao;
	
	NucleoDAO nucleoDao;
	
	PersonaDAO personaDao;
	
	public void setMicrocurriculosDao(MicrocurriculosDAO microcurriculosDao) {
		this.microcurriculosDao = microcurriculosDao;
	}

	public void setMateriasDao(MateriasDAO materiasDao) {
		this.materiasDao = materiasDao;
	}

	public MicrocurriculosNGCImpl() {
		// TODO Auto-generated constructor stub
	}

	public void setNucleoDao(NucleoDAO nucleoDao) {
		this.nucleoDao = nucleoDao;
	}

	public void setPersonaDao(PersonaDAO personaDao) {
		this.personaDao = personaDao;
	}

	@Override
	public TbMicMicrocurriculos obtenerMicrocurriculos(String idMicrocurriculo) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el dato id no sea vacio
		 */
		if((idMicrocurriculo.equals(""))||(idMicrocurriculo.equals(null))){
			throw new ExcepcionesLogica("No se ha ingresado una identificación de microcurriculo, está vacia");
		}
		TbMicMicrocurriculos microcurriculo = null;
		
		try {
			microcurriculo = microcurriculosDao.obtenerMicrocurriculo(idMicrocurriculo);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerMicrocurriculo de la clase microcurriculosDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(microcurriculo == null){
			//si está vacio tira una excepción
			throw new ExcepcionesLogica("No se encontró microcurriculo con el id "+ idMicrocurriculo);
		}else{
			return microcurriculo;
		}
	}

	@Override
	public void guardarMicrocurriculos(TbMicMicrocurriculos microcurriculo) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(microcurriculo == null){
			throw new ExcepcionesLogica("El objeto microcurriculo está vacio");
		}
		try {
			String id = microcurriculo.getVrIdmicrocurriculo();
			TbMicMicrocurriculos microcurriculosConsulta = microcurriculosDao.obtenerMicrocurriculo(id);
		
			if(microcurriculosConsulta != null){
				throw new ExcepcionesLogica("El microcurriculo a insertar ya existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerMicrocurriculo de la clase microcurriculosDao: "+ e);
		}
		
		try {
			
			microcurriculosDao.guardarMicrocurriculo(microcurriculo);
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo guardarMicrocurriculo de la clase microcurriculosDao: "+ e);
		}
	}

	@Override
	public void actualizarMicrocurriculos(TbMicMicrocurriculos microcurriculo) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(microcurriculo == null){
			throw new ExcepcionesLogica("El objeto microcurriculo está vacio");
		}
		try {
			String id = microcurriculo.getVrIdmicrocurriculo();
			TbMicMicrocurriculos microcurriculoConsulta = microcurriculosDao.obtenerMicrocurriculo(id);
		
			if(microcurriculoConsulta == null){
				throw new ExcepcionesLogica("El microcurriculo a actualizar no existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerMicrocurriculo de la clase microcurriculosDao: "+ e);
		}
		
		try {
			
			microcurriculosDao.modificarMicrocurriculo(microcurriculo);
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo modificarMicrocurriculo de la clase microcurriculosDao: "+ e);
		}
	}

	@Override
	public List<TbMicMicrocurriculos> listarMicrocurriculos() throws ExcepcionesLogica {
		List<TbMicMicrocurriculos> listaMicrocurriculos = null;
		try {
			listaMicrocurriculos = microcurriculosDao.listarMicrocurriculos();
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo listarMicrocurriculos de la clase microcurriculosDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(listaMicrocurriculos == null){
			throw new ExcepcionesLogica("No se encontraron microcurriculos en la tabla TbMicMicrocurriculos");
		}else{
			return listaMicrocurriculos;
		}
	}
	
	@Override
	public List<TbMicMicrocurriculos> listarMicrocurriculosPorSemestre(String idSemestre) throws ExcepcionesLogica{
		List<TbMicMicrocurriculos> listaMicrocurriculos = null;
			
		if(idSemestre.equals("")||(idSemestre.equals(null))){
			throw new ExcepcionesLogica("No se envio un id de semestre a consultar"); 
		}
		
		try {
			listaMicrocurriculos = microcurriculosDao.listarMicrocurriculosPorSemestre(idSemestre);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo listarMicrocurriculosPorSemestre de la clase microcurriculosDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		return listaMicrocurriculos;
	}
	
	@Override
	public List<TbMicMicrocurriculos> listarMicrocurriculosPorNucleo(String idNucleo) throws ExcepcionesLogica{
		List<TbMicMicrocurriculos> listaMicrocurriculos = null;
		
		TbAdmNucleo nucleo= null;
		
		if(idNucleo.equals("")||(idNucleo.equals(null))){
			throw new ExcepcionesLogica("No se envio un id de nucleo a consultar"); 
		}
		
		try {
			nucleo = nucleoDao.obtenerNucleo(idNucleo);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerNucleo de la clase nucleoDao: "+ e);
		}
		
		if(nucleo == null){
			throw new ExcepcionesLogica("NO existe nucleo a consultar"); 
		}
		
		try {
			listaMicrocurriculos = microcurriculosDao.listarMicrocurriculosPorNucleo(nucleo);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo listarMicrocurriculosPorNucleo de la clase microcurriculosDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		return listaMicrocurriculos;
	}
	
	@Override
	public List<TbMicMicrocurriculos> listarMicrocurriculosPorMateria(String idMateria) throws ExcepcionesLogica{
		List<TbMicMicrocurriculos> listaMicrocurriculos = null;
		
		TbAdmMaterias materia= null;
		
		try {
			materia = materiasDao.obtenerMateria(idMateria);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerMateria de la clase materiasDao: "+ e);
		}
		
		if(materia == null){
			throw new ExcepcionesLogica("NO existe materia a consultar"); 
		}
		
		try {
			listaMicrocurriculos = microcurriculosDao.listarMicrocurriculosPorMateria(materia);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo listarMicrocurriculosPorMateria de la clase microcurriculosDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		return listaMicrocurriculos;
	}
	
	@Override
	public List<TbMicMicrocurriculos> listarMicrocurriculosPorResponsable(String idResponsable) throws ExcepcionesLogica{
		List<TbMicMicrocurriculos> listaMicrocurriculos = null;
		
		TbAdmPersona responsable= null;
		
		try {
			responsable = personaDao.obtenerPersona(idResponsable);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerPersona de la clase personaDao: "+ e);
		}
		
		if(responsable == null){
			throw new ExcepcionesLogica("NO existe responsable a consultar"); 
		}
		
		try {
			listaMicrocurriculos = microcurriculosDao.listarMicrocurriculosPorResponsable(responsable);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo listarMicrocurriculosPorResponsable de la clase microcurriculosDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		return listaMicrocurriculos;
	}

}
