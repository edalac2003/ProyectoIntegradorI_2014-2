package com.udea.proint1.microcurriculo.dao.hibernate;

import java.util.List;

import com.udea.proint1.microcurriculo.dao.BibliografiaDAO;
import com.udea.proint1.microcurriculo.dto.Bibliografia;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public class BibliografiasDAOHibernate implements BibliografiaDAO {

	public BibliografiasDAOHibernate() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void guardarBibliografia(Bibliografia bibliografia)
			throws ExcepcionesDAO {
		// TODO Auto-generated method stub

	}

	@Override
	public void modificarBibliografia(Bibliografia bibliografia)
			throws ExcepcionesDAO {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Bibliografia> listarBibliografiaPorMicrocurriculo(
			String idMicrocurriculo) throws ExcepcionesDAO {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Bibliografia> listarBibliografiaPorTipo(
			String idMicrocurriculo, char tipo) throws ExcepcionesDAO {
		// TODO Auto-generated method stub
		return null;
	}

}
