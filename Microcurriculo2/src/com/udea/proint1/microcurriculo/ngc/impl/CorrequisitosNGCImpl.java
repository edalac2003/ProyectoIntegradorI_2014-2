package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.Date;
import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbAdmCorrequisitos;
import com.udea.proint1.microcurriculo.ngc.CorrequisitosNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class CorrequisitosNGCImpl implements CorrequisitosNGC {

	CorrequisitosDAO correquisitosDao;
	
	public CorrequisitosNGCImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void guardarCorrequisito(int idCorrequisito, String idMateria1,
			String idMateria2, int idUsuario, Date modFecha)
			throws ExcepcionesLogica {
		if(idCorrequisito == 0){
			throw new ExcepcionesLogica("No se ingresó el id del nuevo microcurriculo");
		}
		

	}

	@Override
	public void actualizarCorrequisito(String idMateria1, String idMateria2,
			int idUsuario, Date modFecha) throws ExcepcionesLogica {
		// TODO Auto-generated method stub

	}

	@Override
	public List<TbAdmCorrequisitos> listarCorrequisitos()
			throws ExcepcionesLogica {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TbAdmCorrequisitos obtenerCorrequisito(int id)
			throws ExcepcionesLogica {
		// TODO Auto-generated method stub
		return null;
	}

}
