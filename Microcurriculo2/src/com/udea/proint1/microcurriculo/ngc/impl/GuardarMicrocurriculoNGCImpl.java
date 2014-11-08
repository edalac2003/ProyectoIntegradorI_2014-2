package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.List;

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

	MicrocurriculosDAO microcurriculosDao;
	
	GuardarMicrocurriculoDAO guardarMicroDao;
	
	public GuardarMicrocurriculoNGCImpl() {
		// TODO Auto-generated constructor stub
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
			throws ExcepcionesDAO {
		String idMicro;
		TbMicMicrocurriculos microConsulta;
		
		try{
			
			idMicro = microcurriculo.getVrIdmicrocurriculo();
			microConsulta = microcurriculosDao.obtenerMicrocurriculo(idMicro);
			if(microcurriculo != null){
				new ExcepcionesLogica("El microcurriculo a guardar ya existe");
			}
			guardarMicroDao.guardarMicroxlotes(temas, temasxunidad, autores, subtemas, unidades, unidadesxmicro, biblioxunidad, autorxbiblio, 
					objetivos, objetivosxmicro, bibliografia, microcurriculo, microxEstado, microxSemestre);
			
		}catch(ExcepcionesDAO e){
			
		}

	}

}
