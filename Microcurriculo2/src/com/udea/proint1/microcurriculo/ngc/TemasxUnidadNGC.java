package com.udea.proint1.microcurriculo.ngc;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbMicTemasxunidad;
import com.udea.proint1.microcurriculo.dto.TbMicUnidades;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface TemasxUnidadNGC {
	
	public TbMicTemasxunidad obtenerTemasxUnidad(int id) throws ExcepcionesLogica;
	
	public void guardarTemasxUnidad (TbMicTemasxunidad temasxUnidad) throws ExcepcionesLogica;
	
    public void actualizarTemaxUnidad (TbMicTemasxunidad temasxUnidad) throws ExcepcionesLogica;
    
    public List<TbMicTemasxunidad> listarTemasxUnidad () throws ExcepcionesLogica;
    
    public int contarRegistros() throws ExcepcionesLogica;
    
    public List<TbMicTemasxunidad> ListarTemasxUnidadxUnidad(int idUnidad) throws ExcepcionesLogica;

}
