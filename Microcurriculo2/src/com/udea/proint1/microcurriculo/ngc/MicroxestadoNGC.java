package com.udea.proint1.microcurriculo.ngc;

import java.util.Date;
import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbMicMicroxestado;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface MicroxestadoNGC {
	
	public TbMicMicroxestado obtenerMicroxestado (int id) throws ExcepcionesLogica;
	public void guardarMicroxestado (int id, int idEstado, String idMicrocurriculo, String usuario, Date fecha) throws ExcepcionesLogica;
    public void actualizarMicroxestado (int idEstado, String idMicrocurriculo, String usuario, Date fecha) throws ExcepcionesLogica;
    public List<TbMicMicroxestado> listarMicroxestado () throws ExcepcionesLogica;

}
