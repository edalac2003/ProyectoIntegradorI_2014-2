package com.udea.proint1.microcurriculo.ngc;

import java.util.Date;
import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbMicObjetivosxmicro;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface ObjetivosxmicroNGC {
	
	public TbMicObjetivosxmicro obtenerObjetivosxmicro (int id) throws ExcepcionesLogica;
	public void guardarObjetivosxmicro (int id, int idObjetivo, String idMicrocurriculos, String usuario, Date fecha) throws ExcepcionesLogica;
    public void actualizarObjetivosxmicro (int idObjetivo, String idMicrocurriculos, String usuario, Date fecha) throws ExcepcionesLogica;
    public List<TbMicObjetivosxmicro> listarObjetivosxmicro () throws ExcepcionesLogica;

}
