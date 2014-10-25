package com.udea.proint1.microcurriculo.ngc;

import java.util.Date;
import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbAdmTipopersona;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface TipoPersonaNGC {
	
	public void guardarTipoPersona(int id, String descripcion, String usuario, Date modFecha) throws ExcepcionesLogica;
	
	public void actualizarTipoPersona(String descripcion, String usuario, Date modFecha) throws ExcepcionesLogica;
	
	public List<TbAdmTipopersona> listarTipoPersona() throws ExcepcionesLogica;
	
	public TbAdmTipopersona obtenertipoPersona() throws ExcepcionesLogica;
}
