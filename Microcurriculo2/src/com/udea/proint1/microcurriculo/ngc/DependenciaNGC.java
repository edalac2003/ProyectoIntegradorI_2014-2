package com.udea.proint1.microcurriculo.ngc;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbAdmDependencia;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface DependenciaNGC {
	
	public void guardarDependencia(TbAdmDependencia dependencia) throws ExcepcionesLogica;
	
	public void actualizarDependencia(TbAdmDependencia dependencia) throws ExcepcionesLogica;

	public TbAdmDependencia obtenerDependencia(String id) throws ExcepcionesLogica;
	
	public List<TbAdmDependencia> listarDependencias() throws ExcepcionesLogica;

}
