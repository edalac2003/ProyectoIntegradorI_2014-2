package com.udea.proint1.microcurriculo.dao;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbMicMateriasxpensum;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public interface MateriasxPensumDAO {
	
	public void guardarMateriasxPensum(TbMicMateriasxpensum materiasxPensum) throws ExcepcionesDAO;
	
	public TbMicMateriasxpensum obtenerMateriasxPensum(int id) throws ExcepcionesDAO;
	
	public List<TbMicMateriasxpensum> listarMateriasxPensum() throws ExcepcionesDAO;
	
	public void actualizarMateriasxPensum(TbMicMateriasxpensum materiasxPensum) throws ExcepcionesDAO;
}
