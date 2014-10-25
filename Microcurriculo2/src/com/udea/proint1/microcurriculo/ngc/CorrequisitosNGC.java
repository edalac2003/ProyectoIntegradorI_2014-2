package com.udea.proint1.microcurriculo.ngc;

import java.util.Date;
import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbAdmCorrequisitos;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface CorrequisitosNGC {
	
	public void guardarCorrequisito(int idCorrequisito, String idMateria1, String idMateria2, int idUsuario, Date modFecha) throws ExcepcionesLogica;
	
	public void actualizarCorrequisito(String idMateria1, String idMateria2, int idUsuario, Date modFecha) throws ExcepcionesLogica;
	
	public List<TbAdmCorrequisitos> listarCorrequisitos() throws ExcepcionesLogica;
	
	public TbAdmCorrequisitos obtenerCorrequisito(int id) throws ExcepcionesLogica;
}
