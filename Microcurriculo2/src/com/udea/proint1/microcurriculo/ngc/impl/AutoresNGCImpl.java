package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbMicAutores;
import com.udea.proint1.microcurriculo.ngc.AutoresNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class AutoresNGCImpl implements AutoresNGC {
	
	private static Logger log=Logger.getLogger(CiudadesNGCImpl.class);
	
	AutoresDao autoresDao;
	
	

	public void setAutoresDao(AutoresDao autoresDao) {
		this.autoresDao = autoresDao;
	}

	public AutoresNGCImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public TbMicAutores obtenerEstados(int idAutor) throws ExcepcionesLogica {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void guardarAutores(TbMicAutores autor) throws ExcepcionesLogica {
		// TODO Auto-generated method stub

	}

	@Override
	public void actualizarAutores(TbMicAutores autor) throws ExcepcionesLogica {
		// TODO Auto-generated method stub

	}

	@Override
	public List<TbMicAutores> listarAutores() throws ExcepcionesLogica {
		// TODO Auto-generated method stub
		return null;
	}

}
