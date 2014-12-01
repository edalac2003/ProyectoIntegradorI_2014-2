package com.udea.proint1.microcurriculo.dao;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbAdmDocentesxnucleo;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public interface DocentesxNucleoDAO {

	public void guardarDocentesxNucleo(TbAdmDocentesxnucleo docentesxNucleo) throws ExcepcionesDAO;
	
	public TbAdmDocentesxnucleo obtenerDocentesxNucleo(int id) throws ExcepcionesDAO;
	
	public List<TbAdmDocentesxnucleo> listarDocentesxNucleo() throws ExcepcionesDAO;
	
	public void actualizarDocentesxNucleo(TbAdmDocentesxnucleo docentesxNucleo) throws ExcepcionesDAO;
}
