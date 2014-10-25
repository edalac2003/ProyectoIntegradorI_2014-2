package com.udea.proint1.microcurriculo.dao;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbAdmCiudades;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface CiudadesDAO {
	
	public TbAdmCiudades obtenerCiudad(int idCiudad) throws ExcepcionesDAO;
	
	public List<TbAdmCiudades> listarCiudades() throws ExcepcionesDAO;
	
}
