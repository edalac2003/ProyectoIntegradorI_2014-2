package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.List;

import com.udea.proint1.microcurriculo.dao.UnidadesXMicroDAO;
import com.udea.proint1.microcurriculo.dto.TbMicUnidadesxmicro;
import com.udea.proint1.microcurriculo.ngc.UnidadesxMicroNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class UnidadesxMicroNGCImpl implements UnidadesxMicroNGC {
	
	UnidadesXMicroDAO unidadesxMicroDao;
	
	public void setUnidadesxMicroDao(UnidadesXMicroDAO unidadesxMicroDao) {
		this.unidadesxMicroDao = unidadesxMicroDao;
	}

	public UnidadesxMicroNGCImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void guardarUnidadXmicro(TbMicUnidadesxmicro unidadXmicro)
			throws ExcepcionesLogica {
		// TODO Auto-generated method stub

	}

	@Override
	public void modificarUnidadXmicro(TbMicUnidadesxmicro unidadXmicro)
			throws ExcepcionesLogica {
		// TODO Auto-generated method stub

	}

	@Override
	public TbMicUnidadesxmicro obtenerUnidadXmicro(String idMicrocurriculo,
			int idUnidad) throws ExcepcionesLogica {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TbMicUnidadesxmicro> listarUnidadesXmicro(
			String idMicrocurriculo) throws ExcepcionesLogica {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TbMicUnidadesxmicro> listarTodoUnidadesXmicro()
			throws ExcepcionesLogica {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int contarRegistros() throws ExcepcionesLogica {
		int registro = 0;
		
		try {
			registro = unidadesxMicroDao.contarRegistros();
		} catch (ExcepcionesDAO e) {
			throw new ExcepcionesLogica("Se produjeron Errores al Obtener el numero de Registros de la Tabla Unidades x Microcurriculo.");
		}
				
		return 0;
	}
	
	

}
