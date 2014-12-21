package com.udea.proint1.microcurriculo.dao;

import java.util.List;

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

public interface GuardarMicrocurriculoDAO {
	
//	public void guardarMicroxlotes(List<TbMicTema> temas, List<TbMicTemaxunidad> temasxunidad,
//			List<TbMicAutor> autores, List<TbMicSubtema> subtemas, List<TbMicUnidad> unidades,
//			List<TbMicUnidadxmicro> unidadesxmicro, List<TbMicBiblioxunidad> biblioxunidad,
//			List<TbMicAutorxbiblio> autorxbiblio, List<TbMicObjetivo> objetivos, 
//			List<TbMicObjetivoxmicro> objetivosxmicro, List<TbMicBibliografia> bibliografia,
//			TbMicMicrocurriculo microcurriculo,TbMicMicroxestado microxEstado, 
//			TbMicMicroxsemestre microxSemestre) throws ExcepcionesDAO;

	
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
			List<TbMicEvaluacionxmicro> evaluacionxMicro) throws ExcepcionesDAO;	
	
	public void guardarMicroMiniLote(TbMicMicrocurriculo microcurriculo, TbMicMicroxestado microxEstado, TbMicMicroxsemestre microxSemestre,
			List<TbMicObjetivo> listaObjetivos, List<TbMicObjetivoxmicro> listaObjetivosxMicro) throws ExcepcionesDAO;

}
