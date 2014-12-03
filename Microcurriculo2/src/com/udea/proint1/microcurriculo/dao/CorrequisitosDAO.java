package com.udea.proint1.microcurriculo.dao;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbAdmCorrequisitos;
import com.udea.proint1.microcurriculo.dto.TbAdmMaterias;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public interface CorrequisitosDAO {
	
	public void guardarCorrequisito(TbAdmCorrequisitos correquisitos) throws ExcepcionesDAO;
	
	public void actualizarCorrequisito(TbAdmCorrequisitos correquisitos) throws ExcepcionesDAO;
	
	public TbAdmCorrequisitos obtenerCorrequisitos(int id) throws ExcepcionesDAO;
	
	public List<TbAdmCorrequisitos> listarCorrequisitos() throws ExcepcionesDAO;
	
	public List<TbAdmCorrequisitos> listarCorrequisitosxMateria(TbAdmMaterias materia) throws ExcepcionesDAO;
}
