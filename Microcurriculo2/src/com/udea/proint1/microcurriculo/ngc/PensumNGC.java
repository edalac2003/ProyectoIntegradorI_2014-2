package com.udea.proint1.microcurriculo.ngc;

import java.util.Date;
import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbMicPensum;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface PensumNGC {
	
	public TbMicPensum obtenerPensum (int idPensum) throws ExcepcionesLogica;
	public void guardarPensum (int idPensum, String descripcion, Date fechaInicio , Date fechaFin, String usuario, Date fecha) throws ExcepcionesLogica;
    public void actualizarPensum (int idTema, String descripcion, String usuario, Date fecha) throws ExcepcionesLogica;
    public List<TbMicPensum> listarPensum () throws ExcepcionesLogica;

}
