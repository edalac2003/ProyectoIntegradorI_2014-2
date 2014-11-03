package com.udea.proint1.microcurriculo.ngc;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbAdmCorrequisitos;
import com.udea.proint1.microcurriculo.dto.TbAdmMaterias;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface CorrequisitosNGC {
	
	public void guardarCorrequisito(TbAdmCorrequisitos correquisito) throws ExcepcionesLogica;
	
	public void actualizarCorrequisito(TbAdmCorrequisitos correquisito) throws ExcepcionesLogica;
	
	public List<TbAdmCorrequisitos> listarCorrequisitos() throws ExcepcionesLogica;
	
	public TbAdmCorrequisitos obtenerCorrequisito(int id) throws ExcepcionesLogica;
	
	public List<TbAdmCorrequisitos> listarCorrequisitosxMatera(TbAdmMaterias materia) throws ExcepcionesLogica;
}
