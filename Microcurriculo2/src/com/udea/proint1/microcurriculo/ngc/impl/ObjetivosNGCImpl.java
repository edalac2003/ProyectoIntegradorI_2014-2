package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.List;

import com.udea.proint1.microcurriculo.dao.ObjetivosDAO;
import com.udea.proint1.microcurriculo.dto.TbMicObjetivos;
import com.udea.proint1.microcurriculo.ngc.ObjetivosNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class ObjetivosNGCImpl implements ObjetivosNGC {

	ObjetivosDAO objetivosDao;
	
	public void setObjetivosDao(ObjetivosDAO objetivosDao) {
		this.objetivosDao = objetivosDao;
	}

	public ObjetivosNGCImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public TbMicObjetivos obtenerSubtemas(int idObjetivo)
			throws ExcepcionesLogica {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void guardarObjetivos(TbMicObjetivos objetivo)
			throws ExcepcionesLogica {
		// TODO Auto-generated method stub

	}

	@Override
	public void actualizarObjetivos(TbMicObjetivos objetivo)
			throws ExcepcionesLogica {
		// TODO Auto-generated method stub

	}

	@Override
	public List<TbMicObjetivos> listarObjetivos() throws ExcepcionesLogica {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int numeroRegistros() throws ExcepcionesLogica {
		int numeroRegistro = 0;
		try {
			numeroRegistro = objetivosDao.numeroRegistros();
		} catch (ExcepcionesDAO e) {
			e.printStackTrace();
		}
		
		return numeroRegistro;
	}

}
