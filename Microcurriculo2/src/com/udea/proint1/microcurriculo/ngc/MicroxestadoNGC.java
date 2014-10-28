package com.udea.proint1.microcurriculo.ngc;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbMicMicroxestado;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface MicroxestadoNGC {
	
	public TbMicMicroxestado obtenerMicroxestado (int id) throws ExcepcionesLogica;
	public void guardarMicroxestado (TbMicMicroxestado microxEstado) throws ExcepcionesLogica;
    public void actualizarMicroxestado (TbMicMicroxestado microxestado) throws ExcepcionesLogica;
    public List<TbMicMicroxestado> listarMicroxestado () throws ExcepcionesLogica;

}
