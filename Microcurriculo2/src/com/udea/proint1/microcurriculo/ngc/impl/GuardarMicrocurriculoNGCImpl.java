package com.udea.proint1.microcurriculo.ngc.impl;


import java.util.List;

import org.apache.log4j.Logger;

import com.udea.proint1.microcurriculo.ctrl.ValidarDatosCtrl;
import com.udea.proint1.microcurriculo.dao.GuardarMicrocurriculoDAO;
import com.udea.proint1.microcurriculo.dao.MicrocurriculoDAO;
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
import com.udea.proint1.microcurriculo.ngc.GuardarMicrocurriculoNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class GuardarMicrocurriculoNGCImpl implements GuardarMicrocurriculoNGC {

	private static Logger logger = Logger.getLogger(ValidarDatosCtrl.class);
	
	MicrocurriculoDAO microcurriculoDao;
	GuardarMicrocurriculoDAO guardarMicrocurriculoDao;
	
	public void setMicrocurriculoDao(MicrocurriculoDAO microcurriculoDao) {
		this.microcurriculoDao = microcurriculoDao;
	}
	
	public void setGuardarMicrocurriculoDao(GuardarMicrocurriculoDAO guardarMicrocurriculoDao) {
		this.guardarMicrocurriculoDao = guardarMicrocurriculoDao;
	}

	
	

//	@Override
//	public void guardarMicroxlotes(List<TbMicTema> temas,
//			List<TbMicTemaxunidad> temasxunidad, 
//			List<TbMicAutor> autores,
//			List<TbMicSubtema> subtemas, 
//			List<TbMicUnidad> unidades,
//			List<TbMicUnidadxmicro> unidadesxmicro,
//			List<TbMicBiblioxunidad> biblioxunidad,
//			List<TbMicAutorxbiblio> autorxbiblio,
//			List<TbMicObjetivo> objetivos,
//			List<TbMicObjetivoxmicro> objetivosxmicro,
//			List<TbMicBibliografia> bibliografia,
//			TbMicMicrocurriculo microcurriculo,
//			TbMicMicroxestado microxEstado, 
//			TbMicMicroxsemestre microxSemestre)	throws ExcepcionesLogica {
//		
//		String idMicro;
//		TbMicMicrocurriculo consulta = null;
//		System.out.println("NGC : ESTOY EN EL METODO PARA GUARDAR MICROCURRICULOS POR LOTE");
//		try{			
//			idMicro = microcurriculo.getVrIdmicrocurriculo();
//			consulta = microcurriculoDao.obtenerMicrocurriculo(idMicro);
//			//System.out.println("El valor del Microcurriculo en Guardar x Lote : " + microConsulta);
//			
//			System.out.println("Estoy listo para llamar el metodo guardar DAO.");
//			if(microcurriculo != null){
//				//SI YA EXISTE, ACTUALICELO!!!!
//				new ExcepcionesLogica("El microcurriculo a guardar ya existe");
//			} 
//			guardarMicrocurriculoDao.guardarMicroxlotes(temas, temasxunidad, autores, subtemas, unidades, unidadesxmicro, biblioxunidad, 
//					autorxbiblio, objetivos, objetivosxmicro, bibliografia, microcurriculo, microxEstado, microxSemestre);
//		}catch(ExcepcionesDAO e){
//			logger.error("Error al intentar Guardar el registro de Microcurriculo.");
//		}
//	}

	
	@Override
	public void guardarMicroxlotes(TbMicMicrocurriculo microcurriculo,
			TbMicMicroxestado microxEstado, 
			TbMicMicroxsemestre microxSemestre,
			List<TbMicTema> temas, 
			List<TbMicSubtema> subtemas,
			List<TbMicTemaxunidad> temasxunidad, 
			List<TbMicAutor> autores,
			List<TbMicUnidad> unidades, 
			List<TbMicUnidadxmicro> unidadesxmicro,
			List<TbMicObjetivo> objetivos,
			List<TbMicObjetivoxmicro> objetivosxmicro,
			List<TbMicBibliografia> bibliografia,
			List<TbMicBiblioxunidad> biblioxunidad,
			List<TbMicAutorxbiblio> autorxbiblio,
			List<TbMicEvaluacion> evaluaciones,
			List<TbMicEvaluacionxmicro> evaluacionxMicro)
			throws ExcepcionesLogica {
		
		String idMicro;
		TbMicMicrocurriculo consulta = null;
		
//		System.out.println("GUARDAR MICROCURRICULO NGC");
//		for(TbMicEvaluacion evalua : evaluaciones){
//			System.out.print(evalua.getNbIdevaluacion()+"  ");
//			System.out.print(evalua.getVrDescripcion()+"  ");
//			System.out.print(evalua.getVrModusuario()+"  ");
//			System.out.println(evalua.getDtModfecha());
//		}
		
		try{			
			idMicro = microcurriculo.getVrIdmicrocurriculo();
			consulta = microcurriculoDao.obtenerMicrocurriculo(idMicro);
			if (consulta == null){
				try {
					guardarMicrocurriculoDao.guardarMicroxlotes(microcurriculo, microxEstado, microxSemestre, 
							temas, subtemas, temasxunidad, autores, unidades, unidadesxmicro, objetivos, 
							objetivosxmicro, bibliografia, biblioxunidad, autorxbiblio, evaluaciones, 
							evaluacionxMicro);
				} catch (ExcepcionesDAO e) {
					throw new ExcepcionesLogica("Error al intentar Guardar el registro de Microcurriculo."+e.getMessage());
				}
			}else{
				throw new ExcepcionesLogica("El Microcurriculo ya existe.");
			}
		}catch(ExcepcionesDAO e){
			logger.error("Error al intentar Obtener la informacion del registro de Microcurriculo.");
		}
				
	}

	
	
	

	
	@Override
	public void guardarMicroMiniLote(TbMicMicrocurriculo microcurriculo,
			TbMicMicroxestado microxEstado, TbMicMicroxsemestre microxSemestre,
			List<TbMicObjetivo> listaObjetivos,
			List<TbMicObjetivoxmicro> listaObjetivosxMicro)
			throws ExcepcionesLogica {
		
		TbMicMicrocurriculo micro = null;
		
		try {
			micro = microcurriculoDao.obtenerMicrocurriculo(microcurriculo.getVrIdmicrocurriculo());
		} catch (ExcepcionesDAO e1) {
			
		}
		
		if (micro == null){
			//Se debe guardar un nuevo microcurriculo.
			try{
				guardarMicrocurriculoDao.guardarMicroMiniLote(microcurriculo, microxEstado, microxSemestre, listaObjetivos, listaObjetivosxMicro);	
			}catch(ExcepcionesDAO e){
				System.out.println("");
			}
			
		} else {
			//Se debe actualizar el microcurriculo existente.
			
		
		}
		
	}

	
}
