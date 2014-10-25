package com.udea.proint1.microcurriculo.dao;

import com.udea.proint1.microcurriculo.dto.TbAdmCiudades;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public interface CiudadesDAO {
	
	public TbAdmCiudades obtenerCiudad(int idCiudad) throws ExcepcionesDAO;
	
}
