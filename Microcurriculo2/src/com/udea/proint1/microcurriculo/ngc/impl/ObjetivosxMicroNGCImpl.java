package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.List;

import com.udea.proint1.microcurriculo.dao.ObjetivosxMicroDAO;
import com.udea.proint1.microcurriculo.dto.TbMicObjetivosxmicro;
import com.udea.proint1.microcurriculo.ngc.ObjetivosxMicroNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class ObjetivosxMicroNGCImpl implements ObjetivosxMicroNGC {

	ObjetivosxMicroDAO objetivosxMicroDao;
	
		
	public void setObjetivosxMicroDao(ObjetivosxMicroDAO objetivosxMicroDao) {
		this.objetivosxMicroDao = objetivosxMicroDao;
	}

	@Override
	public void guardarObjetivosxMicro(TbMicObjetivosxmicro objetivoxMicro)
			throws ExcepcionesLogica {
		// TODO Auto-generated method stub

	}

	@Override
	public void modificarObjetivoxMicro(TbMicObjetivosxmicro objetivoxMicro)
			throws ExcepcionesLogica {
		// TODO Auto-generated method stub

	}

	@Override
	public TbMicObjetivosxmicro obtenerObjetivoxMicro(String idMicrocurriculo,
			int idObjetivo) throws ExcepcionesLogica {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TbMicObjetivosxmicro> listarObjetivosxMicro()
			throws ExcepcionesLogica {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TbMicObjetivosxmicro> listarObjetivosxMicro(
			String idMicrocurriculo) throws ExcepcionesLogica {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int contarRegistros() throws ExcepcionesLogica {
		int registro = 0;
		
		try {
			registro = objetivosxMicroDao.contarRegistros();
		} catch (ExcepcionesDAO e) {
			throw new ExcepcionesLogica("Se presentaron error al Obtener el numero de Registros de la Tabla Objetivos x Microcurriculo.");
		}		
		
		return registro;
	}

}
