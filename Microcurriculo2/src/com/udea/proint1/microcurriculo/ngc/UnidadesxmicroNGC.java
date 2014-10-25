package com.udea.proint1.microcurriculo.ngc;

import java.util.Date;
import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbMicUnidadesxmicro;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface UnidadesxmicroNGC {

	 public TbMicUnidadesxmicro obtenerUnicadesxmicro(int id) throws ExcepcionesLogica;
	 public void guardarUnidadesxmicro (int id, int idUnidad, String idMicrocurriculo, String usuario, Date fecha  ) throws ExcepcionesLogica;
     public void actualizarUnidadesxmicro (int idUnidad, String idMicrocurriculo, String usuario, Date fecha) throws ExcepcionesLogica;
     public List<TbMicUnidadesxmicro> listarUnidadesxmicro() throws ExcepcionesLogica;
}
