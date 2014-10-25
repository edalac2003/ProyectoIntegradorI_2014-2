package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.List;

import com.udea.proint1.microcurriculo.dao.BibliografiaDAO;
import com.udea.proint1.microcurriculo.dto.TbMicBibliografia;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class BibliografiasDAOHibernate implements BibliografiaDAO {

	public BibliografiasDAOHibernate() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void guardarBibliografia(TbMicBibliografia bibliografia)
			throws ExcepcionesDAO {
		// TODO Auto-generated method stub

	}

	@Override
	public void modificarBibliografia(TbMicBibliografia bibliografia)
			throws ExcepcionesDAO {
		// TODO Auto-generated method stub

	}

	@Override
	public List<TbMicBibliografia> listarBibliografiaPorMicrocurriculo(String idMicrocurriculo) throws ExcepcionesDAO {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TbMicBibliografia> listarBibliografiaPorTipo(
			String idMicrocurriculo, char tipo) throws ExcepcionesDAO {
		// TODO Auto-generated method stub
		return null;
	}

}
