package com.udea.proint1.microcurriculo.ngc;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbMicEstados;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface EstadosNGC {
	
	public TbMicEstados obtenerEstados (int idEstado) throws ExcepcionesLogica;
	public void guardarEstados (TbMicEstados estado) throws ExcepcionesLogica;
    public void actualizarEstados (TbMicEstados estado) throws ExcepcionesLogica;
    public List<TbMicEstados> listarEstados () throws ExcepcionesLogica;

}
