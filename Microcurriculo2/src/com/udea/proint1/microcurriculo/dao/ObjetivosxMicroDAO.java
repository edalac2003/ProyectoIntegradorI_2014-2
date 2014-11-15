package com.udea.proint1.microcurriculo.dao;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbMicMicrocurriculos;
import com.udea.proint1.microcurriculo.dto.TbMicObjetivos;
import com.udea.proint1.microcurriculo.dto.TbMicObjetivosxmicro;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public interface ObjetivosxMicroDAO {
	
	public void guardarObjetivosxMicro(TbMicObjetivosxmicro objetivoxMicro) throws ExcepcionesDAO;
	
	public void guardarObjetivosxMicro(List<TbMicObjetivosxmicro> listaObjetivoxMicro) throws ExcepcionesDAO;
	
	public void modificarObjetivoxMicro(TbMicObjetivosxmicro objetivoxMicro) throws ExcepcionesDAO;
	
	public TbMicObjetivosxmicro obtenerObjetivoxMicro(String idMicrocurriculo, int idObjetivo) throws ExcepcionesDAO;
	
	public TbMicObjetivosxmicro obtenerObjetivoxMicro(int idObjetivo) throws ExcepcionesDAO;
	
	public List<TbMicObjetivosxmicro> listarObjetivosxMicro() throws ExcepcionesDAO;
	
	public List<TbMicObjetivosxmicro> listarObjetivosxMicro(String idMicrocurriculo) throws ExcepcionesDAO;
	
	public int contarRegistros() throws ExcepcionesDAO;
	
}
