package com.udea.proint1.microcurriculo.dao;

import java.util.List;

import org.zkoss.zul.Listcell;

import com.udea.proint1.microcurriculo.dto.TbMicBiblioxunidad;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public interface BiblioxUnidadDAO {
	
	public void guardarBiblioxUnidad(TbMicBiblioxunidad biblioxUnidad) throws ExcepcionesDAO;
	
	public void modificarBiblioxUnidad(TbMicBiblioxunidad biblioxUnidad) throws ExcepcionesDAO;
	
	public TbMicBiblioxunidad obtenerBiblioxUnidad(int idUnidad, int idBibliografia) throws ExcepcionesDAO;
	
	public List<TbMicBiblioxunidad> listadoBiblioxUnidad() throws ExcepcionesDAO;
	
	public List<TbMicBiblioxunidad> listadoBiblioxUnidad(int idUnidad) throws ExcepcionesDAO;
	
	public int contarRegistros() throws ExcepcionesDAO;

}
