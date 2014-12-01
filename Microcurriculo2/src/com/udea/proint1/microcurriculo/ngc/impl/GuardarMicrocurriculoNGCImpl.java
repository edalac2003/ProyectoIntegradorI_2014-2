package com.udea.proint1.microcurriculo.ngc.impl;


import java.util.List;

import org.apache.log4j.Logger;

import com.udea.proint1.microcurriculo.ctrl.ValidarDatosCtrl;
import com.udea.proint1.microcurriculo.dao.GuardarMicrocurriculoDAO;
import com.udea.proint1.microcurriculo.dao.MicrocurriculosDAO;
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
import com.udea.proint1.microcurriculo.ngc.GuardarMicrocurriculoNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;




public class GuardarMicrocurriculoNGCImpl implements GuardarMicrocurriculoNGC {

	private static Logger logger = Logger.getLogger(ValidarDatosCtrl.class);
	
	MicrocurriculosDAO microcurriculosDao;
	GuardarMicrocurriculoDAO guardarMicrocurriculoDao;
	
	public void setMicrocurriculosDao(MicrocurriculosDAO microcurriculosDao) {
		this.microcurriculosDao = microcurriculosDao;
	}
	
	public void setGuardarMicrocurriculoDao(GuardarMicrocurriculoDAO guardarMicrocurriculoDao) {
		this.guardarMicrocurriculoDao = guardarMicrocurriculoDao;
	}


	@Override
	public void guardarMicroxlotes(List<TbMicTemas> temas,
			List<TbMicTemasxunidad> temasxunidad, List<TbMicAutores> autores,
			List<TbMicSubtemas> subtemas, List<TbMicUnidades> unidades,
			List<TbMicUnidadesxmicro> unidadesxmicro,
			List<TbMicBiblioxunidad> biblioxunidad,
			List<TbMicAutorxbiblio> autorxbiblio,
			List<TbMicObjetivos> objetivos,
			List<TbMicObjetivosxmicro> objetivosxmicro,
			List<TbMicBibliografia> bibliografia,
			TbMicMicrocurriculos microcurriculo,
			TbMicMicroxestado microxEstado, TbMicMicroxsemestre microxSemestre)
			throws ExcepcionesLogica {
		
		String idMicro;
		TbMicMicrocurriculos consulta = null;
		
		try{			
			idMicro = microcurriculo.getVrIdmicrocurriculo();
			consulta = microcurriculosDao.obtenerMicrocurriculo(idMicro);
			//System.out.println("El valor del Microcurriculo en Guardar x Lote : " + microConsulta);
			
			System.out.println("Estoy listo para llamar el metodo guardar DAO.");
//			if(microcurriculo != null){
//				//SI YA EXISTE, ACTUALICELO!!!!
//				new ExcepcionesLogica("El microcurriculo a guardar ya existe");
//			} 
//			guardarMicrocurriculoDao.guardarMicroxlotes(temas, temasxunidad, autores, subtemas, unidades, unidadesxmicro, biblioxunidad, 
//					autorxbiblio, objetivos, objetivosxmicro, bibliografia, microcurriculo, microxEstado, microxSemestre);
		}catch(ExcepcionesDAO e){
			logger.error("Error al intentar Guardar el registro de Microcurriculo.");
		}
	}




	@Override
	public void guardarMicroMiniLote(TbMicMicrocurriculos microcurriculo,
			TbMicMicroxestado microxEstado, TbMicMicroxsemestre microxSemestre,
			List<TbMicObjetivos> listaObjetivos,
			List<TbMicObjetivosxmicro> listaObjetivosxMicro)
			throws ExcepcionesLogica {
		
		TbMicMicrocurriculos micro = null;
		
		try {
			micro = microcurriculosDao.obtenerMicrocurriculo(microcurriculo.getVrIdmicrocurriculo());
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
