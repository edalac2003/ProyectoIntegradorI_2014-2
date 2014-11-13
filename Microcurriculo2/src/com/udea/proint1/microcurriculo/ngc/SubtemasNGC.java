package com.udea.proint1.microcurriculo.ngc;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbMicSubtemas;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface SubtemasNGC {
	
	public TbMicSubtemas obtenerSubtemas(int idSubtema) throws ExcepcionesLogica;
	public void guardarSubtemas (TbMicSubtemas subtema) throws ExcepcionesLogica;
    public void actualizarSubtemas (TbMicSubtemas subtema) throws ExcepcionesLogica;
    public List<TbMicSubtemas> listarSubtemas () throws ExcepcionesLogica;
    
    public int contarRegistros() throws ExcepcionesLogica;

}
