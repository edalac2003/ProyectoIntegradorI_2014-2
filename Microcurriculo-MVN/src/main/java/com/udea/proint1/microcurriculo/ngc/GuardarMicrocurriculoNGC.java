package com.udea.proint1.microcurriculo.ngc;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbMicBibliografia;
import com.udea.proint1.microcurriculo.dto.TbMicBiblioxunidad;
import com.udea.proint1.microcurriculo.dto.TbMicEvaluacion;
import com.udea.proint1.microcurriculo.dto.TbMicEvaluacionxmicro;
import com.udea.proint1.microcurriculo.dto.TbMicMicrocurriculo;
import com.udea.proint1.microcurriculo.dto.TbMicMicroxestado;
import com.udea.proint1.microcurriculo.dto.TbMicObjetivo;
import com.udea.proint1.microcurriculo.dto.TbMicObjetivoxmicro;
import com.udea.proint1.microcurriculo.dto.TbMicSubtema;
import com.udea.proint1.microcurriculo.dto.TbMicSubtemaxtema;
import com.udea.proint1.microcurriculo.dto.TbMicTema;
import com.udea.proint1.microcurriculo.dto.TbMicTemaxunidad;
import com.udea.proint1.microcurriculo.dto.TbMicUnidad;
import com.udea.proint1.microcurriculo.dto.TbMicUnidadxmicro;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface GuardarMicrocurriculoNGC {
	
	public void guardarMicroxlotes(TbMicMicrocurriculo microcurriculo,
			TbMicMicroxestado microxEstado, 
			List<TbMicTema> temas,
			List<TbMicSubtema> subtemas,
			List<TbMicSubtemaxtema> subtemaxTema,
			List<TbMicTemaxunidad> temasxunidad,		 
			List<TbMicUnidad> unidades,
			List<TbMicUnidadxmicro> unidadesxmicro, 
			List<TbMicObjetivo> objetivos, 
			List<TbMicObjetivoxmicro> objetivosxmicro, 
			List<TbMicBibliografia> bibliografia,
			List<TbMicBiblioxunidad> biblioxunidad,
			List<TbMicEvaluacion> evaluaciones,
			List<TbMicEvaluacionxmicro> evaluacionxMicro) throws ExcepcionesLogica;	
}
