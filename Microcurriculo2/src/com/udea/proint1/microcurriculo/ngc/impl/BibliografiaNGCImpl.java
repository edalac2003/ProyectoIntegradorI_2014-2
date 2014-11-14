package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.List;

import com.udea.proint1.microcurriculo.dao.BibliografiaDAO;
import com.udea.proint1.microcurriculo.dto.TbMicBibliografia;
import com.udea.proint1.microcurriculo.ngc.BibliografiaNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class BibliografiaNGCImpl implements BibliografiaNGC {
	
	BibliografiaDAO bibliografiaDao;
	
	public void setBibliografiaDao(BibliografiaDAO bibliografiaDao) {
		this.bibliografiaDao = bibliografiaDao;
	}

	public BibliografiaNGCImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void guardarBibliografia(TbMicBibliografia bibliografia)
			throws ExcepcionesLogica {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modificarBibliografia(TbMicBibliografia bibliografia)
			throws ExcepcionesLogica {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<TbMicBibliografia> listarBibliografia(String idMicrocurriculo)
			throws ExcepcionesLogica {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TbMicBibliografia> listarBibliografia(char tipo)
			throws ExcepcionesLogica {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int contarRegistros() throws ExcepcionesLogica {
		int registro = 0;
		
		try {
			registro = bibliografiaDao.contarRegistros();
		} catch (ExcepcionesDAO e) {
			throw new ExcepcionesLogica();
		}
		
		return registro;
	}

	
}
