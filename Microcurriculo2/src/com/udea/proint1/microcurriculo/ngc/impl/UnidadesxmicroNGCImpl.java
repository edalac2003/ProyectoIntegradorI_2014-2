package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.Date;
import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbAdmUsuarios;
import com.udea.proint1.microcurriculo.dto.TbMicUnidadesxmicro;
import com.udea.proint1.microcurriculo.ngc.UsuariosNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class UnidadesxmicroNGCImpl implements UnidadesxmicroNGC {

private static Logger log=Logger.getLogger(UnidadesxmicroNGCImpl.class);
	
	UnidadesxmicroDAO unidadesxmicroDao;
	
	public UnidadesxmicroDAO getUnidadesxmicroDAO() {
		return unidadesxmicroDao;
	}

	public void setunidadesxmicroDao(UnidadesxmicroDAO unidadesxmicroDao) {
		this.unidadesxmicroDao = unidadesxmicroDao;

	@Override
	public TbAdmUsuarios obtenerEstados(int id) throws ExcepcionesLogica {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void guardarUsuarios(TbMicUnidadesxmicro unidadesxMicro)
			throws ExcepcionesLogica {
		// TODO Auto-generated method stub

	}

	@Override
	public void actualizarUsuarios(TbAdmUsuarios usuario)
			throws ExcepcionesLogica {
		// TODO Auto-generated method stub

	}

	@Override
	public List<TbAdmUsuarios> listarUsuarios() throws ExcepcionesLogica {
		// TODO Auto-generated method stub
		return null;
	}

}