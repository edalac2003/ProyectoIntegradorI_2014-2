package com.udea.proint1.microcurriculo.ngc;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbMicObjetivosxmicro;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface ObjetivosxMicroNGC {
	
	public void guardarObjetivosxMicro(TbMicObjetivosxmicro objetivoxMicro) throws ExcepcionesLogica;
	
	public void modificarObjetivoxMicro(TbMicObjetivosxmicro objetivoxMicro) throws ExcepcionesLogica;
	
	public TbMicObjetivosxmicro obtenerObjetivoxMicro(String idMicrocurriculo, int idObjetivo) throws ExcepcionesLogica;
	
	public List<TbMicObjetivosxmicro> listarObjetivosxMicro() throws ExcepcionesLogica;
	
	public List<TbMicObjetivosxmicro> listarObjetivosxMicro(String idMicrocurriculo) throws ExcepcionesLogica;
	
	public int contarRegistros() throws ExcepcionesLogica;

}
