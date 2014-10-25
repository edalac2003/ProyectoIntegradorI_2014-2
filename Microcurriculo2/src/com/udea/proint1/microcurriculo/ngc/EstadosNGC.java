package com.udea.proint1.microcurriculo.ngc;

import java.util.Date;
import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbMicEstados;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface EstadosNGC {
	
	public TbMicEstados obtenerEstados (int idEstado) throws ExcepcionesLogica;
	public void guardarEstados (int idEstado, String descripcion, String usuario, Date fecha) throws ExcepcionesLogica;
    public void actualizarEstados (String descripcion, String usuario, Date fecha) throws ExcepcionesLogica;
    public List<TbMicEstados> listarEstados () throws ExcepcionesLogica;

}
