package com.udea.proint1.microcurriculo.dao;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbAdmCiudades;
import com.udea.proint1.microcurriculo.dto.TbAdmPaises;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public interface PaisesDAO {
	
	public TbAdmPaises obtenerPais(int idPais) throws ExcepcionesDAO;

	public List<TbAdmPaises> listarPaises() throws ExcepcionesDAO;
}
