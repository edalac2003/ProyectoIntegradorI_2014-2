package com.udea.proint1.microcurriculo.ngc;

import java.util.Date;
import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbMicMicroxsemestre;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface MicroxsemestreNGC {

	public TbMicMicroxsemestre obtenerMicroxsemestre (int id) throws ExcepcionesLogica;
	public void guardarMicroxsemestre (int id, String idMicrocurriculo, String idSemestre, String usuario, Date fecha) throws ExcepcionesLogica;
    public void actualizarMicroxsemestre (String idMicrocurriculo, String idSemestre, String usuario, Date fecha) throws ExcepcionesLogica;
    public List<TbMicMicroxsemestre> listarMicroxsemestre () throws ExcepcionesLogica;
}
