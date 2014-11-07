package com.udea.proint1.microcurriculo.dao;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbMicMicroxsemestre;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public interface MicroxSemestreDAO {
	
	public void guardarMicroxsemestre(TbMicMicroxsemestre microxSemestre) throws ExcepcionesDAO;
	
	public void actualizarMicroxsemestre(TbMicMicroxsemestre microxSemestre) throws ExcepcionesDAO;
	
	public TbMicMicroxsemestre obtenerMicroxsemestre(int id) throws ExcepcionesDAO;
	
	public List<TbMicMicroxsemestre> listarMicroxsemestre() throws ExcepcionesDAO;

}
