package com.udea.proint1.microcurriculo.ngc;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbMicBiblioxunidad;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface BiblioxunidadNGC {
	

	public TbMicBiblioxunidad obtenerMateriasxpensum (int id) throws ExcepcionesLogica;
	public void guardarBiblioxunidad (TbMicBiblioxunidad biblioxUnidad) throws ExcepcionesLogica;
    public void actualizarBiblioxunidad (TbMicBiblioxunidad biblioxUnidad) throws ExcepcionesLogica;
    public List<TbMicBiblioxunidad> listarBiblioxunidad () throws ExcepcionesLogica;

}
