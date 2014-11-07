package com.udea.proint1.microcurriculo.ngc;

import java.util.List;

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
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public interface GuardarMicrocurriculoNGC {
	
	public void guardarMicroxlotes(List<TbMicTemas> temas, List<TbMicTemasxunidad> temasxunidad,
			List<TbMicAutores> autores, List<TbMicSubtemas> subtemas, List<TbMicUnidades> unidades,
			List<TbMicUnidadesxmicro> unidadesxmicro, List<TbMicBiblioxunidad> biblioxunidad,
			List<TbMicAutorxbiblio> autorxbiblio, List<TbMicObjetivos> objetivos, 
			List<TbMicObjetivosxmicro> objetivosxmicro, List<TbMicBibliografia> bibliografia,
			TbMicMicrocurriculos microcurriculo,TbMicMicroxestado microxEstado, 
			TbMicMicroxsemestre microxSemestre) throws ExcepcionesDAO;

}
