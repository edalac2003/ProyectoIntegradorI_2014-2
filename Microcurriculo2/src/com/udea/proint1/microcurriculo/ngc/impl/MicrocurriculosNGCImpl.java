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
	
	
	public MicrocurriculosNGCImpl() {
		// TODO Auto-generated constructor stub
	}
	
	
	public void setMicrocurriculosDao(MicrocurriculosDAO microcurriculosDao) {
		this.microcurriculosDao = microcurriculosDao;
	}

	public void setMateriasDao(MateriasDAO materiasDao) {
		this.materiasDao = materiasDao;
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
		TbMicMicrocurriculos microcurriculo = null;
		
		if(!("".equals(idMicrocurriculo)) && (idMicrocurriculo.trim().length() > 0) ){
			try {
				microcurriculo = microcurriculosDao.obtenerMicrocurriculo(idMicrocurriculo);
			} catch (ExcepcionesDAO e) {
				throw new ExcepcionesLogica("NGC : Ocurri� un error al intentar obtener el microcurriculo.");
			}			
		}else{
			throw new ExcepcionesLogica("La informaci�n de IdMicrocurriculo no es v�lida o est� vacia.");
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		System.out.println("El valor del microcurriculo a retornar es : "+ microcurriculo);
		return microcurriculo;
	}

	
	@Override
	public void guardarMicrocurriculos(TbMicMicrocurriculos microcurriculo) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto Microcurriculo no est� Vacio.
		 */
		System.out.println("INGRESO AL GUARDAR MICROCURRICULO EN LA PARTE DE NEGOCIO.");
		
		if(microcurriculo != null){
			try {
				TbMicMicrocurriculos microTMP = microcurriculosDao.obtenerMicrocurriculo(microcurriculo.getVrIdmicrocurriculo().toString());
				if (microTMP == null){
					microcurriculosDao.guardarMicrocurriculo(microcurriculo);
				}else{
					throw new ExcepcionesLogica("El Microcurriculo que desea guardar ya se encuentra en la Base de Datos.");
				}
			} catch (ExcepcionesDAO e) {
				throw new ExcepcionesLogica();
			}			
		}else{
			throw new ExcepcionesLogica("No es posible guardar. El objeto Microcurriculo no contiene informaci�n v�lida.");
		}
	}
	

	@Override
	public void actualizarMicrocurriculos(TbMicMicrocurriculos microcurriculo) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
//		if(microcurriculo == null){
//			throw new ExcepcionesLogica("El objeto microcurriculo está vacio");
//		}
//		try {
//			String id = microcurriculo.getVrIdmicrocurriculo();
//			TbMicMicrocurriculos microcurriculoConsulta = microcurriculosDao.obtenerMicrocurriculo(id);
//		
//			if(microcurriculoConsulta == null){
//				throw new ExcepcionesLogica("El microcurriculo a actualizar no existe");
//			}
//		
//		} catch (ExcepcionesDAO e) {
//			log.error("falló al invocar el metodo obtenerMicrocurriculo de la clase microcurriculosDao: "+ e);
//		}
//		
//		try {
//			
//			microcurriculosDao.modificarMicrocurriculo(microcurriculo);
//		
//		} catch (ExcepcionesDAO e) {
//			log.error("falló al invocar el metodo modificarMicrocurriculo de la clase microcurriculosDao: "+ e);
//		}
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
