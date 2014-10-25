package com.udea.proint1.microcurriculo.ngc;

import java.util.Date;
import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbMicSubtemas;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface SubtemasNGC {
	
	public TbMicSubtemas obtenerSubtemas(int idSubtema) throws ExcepcionesLogica;
	public void guardarSubtemas (int idSubtema, int idTema, String descripcion, String usuario, Date fecha) throws ExcepcionesLogica;
    public void actualizarSubtemas (int idTema, String descripcion, String usuario, Date fecha) throws ExcepcionesLogica;
    public List<TbMicSubtemas> listarSubtemas () throws ExcepcionesLogica;

}
