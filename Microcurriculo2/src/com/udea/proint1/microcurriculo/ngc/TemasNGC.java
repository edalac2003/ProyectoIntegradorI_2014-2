package com.udea.proint1.microcurriculo.ngc;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbMicTemas;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface TemasNGC {
	
	public TbMicTemas obtenerTemas(int idTema) throws ExcepcionesLogica;
	public void guardarTemas (TbMicTemas tema) throws ExcepcionesLogica;
    public void actualizarTema (TbMicTemas tema) throws ExcepcionesLogica;
    public List<TbMicTemas> listarTemas () throws ExcepcionesLogica;
    public int contarRegistros() throws ExcepcionesLogica;

}
