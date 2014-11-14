package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.List;

import com.udea.proint1.microcurriculo.dao.BiblioxUnidadDAO;
import com.udea.proint1.microcurriculo.dto.TbMicBiblioxunidad;
import com.udea.proint1.microcurriculo.ngc.BiblioxunidadNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class BiblioxUnidadNGCImpl implements BiblioxunidadNGC {

	BiblioxUnidadDAO biblioxUnidadDao;
	
	
	public void setBiblioxUnidadDao(BiblioxUnidadDAO biblioxUnidadDao) {
		this.biblioxUnidadDao = biblioxUnidadDao;
	}

	public BiblioxUnidadNGCImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void guardarBiblioxUnidad(TbMicBiblioxunidad biblioxUnidad)
			throws ExcepcionesLogica {
		// TODO Auto-generated method stub

	}

	@Override
	public void modificarBiblioxUnidad(TbMicBiblioxunidad biblioxUnidad)
			throws ExcepcionesLogica {
		// TODO Auto-generated method stub

	}

	@Override
	public TbMicBiblioxunidad obtenerBiblioxUnidad(int idUnidad,
			int idBibliografia) throws ExcepcionesLogica {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TbMicBiblioxunidad> listadoBiblioxUnidad()
			throws ExcepcionesLogica {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TbMicBiblioxunidad> listadoBiblioxUnidad(int idUnidad)
			throws ExcepcionesLogica {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int contarRegistros() throws ExcepcionesLogica {
		int registro = 0;
		
		try {
			registro = biblioxUnidadDao.contarRegistros();
		} catch (ExcepcionesDAO e) {
			throw new ExcepcionesLogica();
		}
		
		return registro;
	}

}
