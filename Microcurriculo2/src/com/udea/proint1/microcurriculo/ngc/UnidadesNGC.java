package com.udea.proint1.microcurriculo.ngc;

import java.util.Date;
import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbMicUnidades;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface UnidadesNGC {

	public TbMicUnidades obtenerUnicades(int idUnidad) throws ExcepcionesLogica;
	public void guardarUnidades (int idUnidad, String nombre, String usuario, Date fecha) throws ExcepcionesLogica;
    public void actualizarUnidades (String nombre, String usuario, Date fecha) throws ExcepcionesLogica;
    public List<TbMicUnidades> listarUnidades() throws ExcepcionesLogica;
}
