package com.udea.proint1.microcurriculo.ngc;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbMicUnidades;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface UnidadesNGC {

	public TbMicUnidades obtenerUnicades(int idUnidad) throws ExcepcionesLogica;
	public void guardarUnidades (TbMicUnidades unidad) throws ExcepcionesLogica;
    public void actualizarUnidades (TbMicUnidades unidad) throws ExcepcionesLogica;
    public List<TbMicUnidades> listarUnidades() throws ExcepcionesLogica;
    public int numeroRegistros() throws ExcepcionesLogica;
}
