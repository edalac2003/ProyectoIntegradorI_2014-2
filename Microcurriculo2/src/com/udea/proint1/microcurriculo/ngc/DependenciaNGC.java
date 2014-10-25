package com.udea.proint1.microcurriculo.ngc;

import java.util.Date;
import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbAdmDependencia;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface DependenciaNGC {
	
	public void guardarDependencia(String id, String idUnidad, String nombre, String Usuario, Date modFecha) throws ExcepcionesLogica;
	
	public void actualizarDependencia(String idUnidad, String nombre, String Usuario, Date modFecha) throws ExcepcionesLogica;

	public TbAdmDependencia obtenerDependencia(String id) throws ExcepcionesLogica;
	
	public List<TbAdmDependencia> actualizarDependencia() throws ExcepcionesLogica;

}
