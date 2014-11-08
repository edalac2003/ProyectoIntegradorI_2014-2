package com.udea.proint1.microcurriculo.ngc;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbMicMicroxsemestre;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface MicroxsemestreNGC {

	public void guardarMicroxsemestre(TbMicMicroxsemestre microxSemestre) throws ExcepcionesLogica;
	
	public void actualizarMicroxsemestre(TbMicMicroxsemestre microxSemestre) throws ExcepcionesLogica;
	
	public TbMicMicroxsemestre obtenerMicroxsemestre(int id) throws ExcepcionesLogica;
	
	public List<TbMicMicroxsemestre> listarMicroxsemestre() throws ExcepcionesLogica;
	
	public int ContarMicrosxsemestre() throws ExcepcionesLogica;
}
