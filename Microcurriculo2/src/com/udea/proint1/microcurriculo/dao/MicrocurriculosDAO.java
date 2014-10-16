package com.udea.proint1.microcurriculo.dao;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.Microcurriculos;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public interface MicrocurriculosDAO {

	public void guardarMicrocurriculo(Microcurriculos microcurriculo) throws ExcepcionesDAO;
	
	public Microcurriculos obtenerMicrocurriculo(String IdMicrocurriculo) throws ExcepcionesDAO;
	
	public List<Microcurriculos> listarMicrocurriculos() throws ExcepcionesDAO;
	
	public void modificarMicrocurriculo (String idMicrocurriculo) throws ExcepcionesDAO;
	
	
}
