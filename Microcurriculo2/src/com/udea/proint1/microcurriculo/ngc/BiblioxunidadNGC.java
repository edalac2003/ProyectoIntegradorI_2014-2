package com.udea.proint1.microcurriculo.ngc;

import java.util.Date;
import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbMicBiblioxunidad;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface BiblioxunidadNGC {
	

	public TbMicBiblioxunidad obtenerMateriasxpensum (int id) throws ExcepcionesLogica;
	public void guardarBiblioxunidad (int id, int idBibliografia, int idUnidad, String usuario, Date fecha) throws ExcepcionesLogica;
    public void actualizarBiblioxunidad (int idBibliografia, int idUnidad, String usuario, Date fecha) throws ExcepcionesLogica;
    public List<TbMicBiblioxunidad> listarBiblioxunidad () throws ExcepcionesLogica;

}
