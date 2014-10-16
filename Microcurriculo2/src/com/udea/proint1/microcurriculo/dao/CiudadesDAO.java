package com.udea.proint1.microcurriculo.dao;

import com.udea.proint1.microcurriculo.dto.Ciudades;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public interface CiudadesDAO {
	
	public Ciudades obtenerCiudad(int idCiudad) throws ExcepcionesDAO;

}
