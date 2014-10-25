package com.udea.proint1.microcurriculo.ngc;

import java.util.Date;
import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbMicTemas;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface TemasNGC {
	
	public TbMicTemas obtenerTemas(int idTema) throws ExcepcionesLogica;
	public void guardarTemas (int idTema, String descripcion, String usuario, Date fecha) throws ExcepcionesLogica;
    public void actualizarTema (String descripcion, String usuario, Date fecha) throws ExcepcionesLogica;
    public List<TbMicTemas> listarTemas () throws ExcepcionesLogica;

}
