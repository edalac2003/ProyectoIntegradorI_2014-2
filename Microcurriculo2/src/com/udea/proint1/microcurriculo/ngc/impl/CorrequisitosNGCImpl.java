package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.List;

import com.udea.proint1.microcurriculo.dao.hibernate.CorrequisitosDAOHibernate;
import com.udea.proint1.microcurriculo.dto.TbAdmCorrequisitos;
import com.udea.proint1.microcurriculo.ngc.CorrequisitosNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class CorrequisitosNGCImpl implements CorrequisitosNGC {

	CorrequisitosDAO correquisitosDao;
	
	public CorrequisitosNGCImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void guardarCorrequisito(TbAdmCorrequisitos correquisito)
			throws ExcepcionesLogica {

	}

	@Override
	public void actualizarCorrequisito(TbAdmCorrequisitos correquisito) throws ExcepcionesLogica {
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
