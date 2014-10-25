package com.udea.proint1.microcurriculo.ngc;

import java.util.Date;
import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbMicTemasxunidad;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface TemasxUnidadNGC {
	
	public TbMicTemasxunidad obtenerTemasxUnidad(int id) throws ExcepcionesLogica;
	public void guardarTemasxUnidad (int id, int idUnidad, int idTemas, int semanasRequeridas, String usuario, Date fecha) throws ExcepcionesLogica;
    public void actualizarTemaxUnidad (int idUnidad, int idTemas, int semanasRequeridas, String usuario, Date fecha) throws ExcepcionesLogica;
    public List<TbMicTemasxunidad> listarTemasxUnidad () throws ExcepcionesLogica;

}
