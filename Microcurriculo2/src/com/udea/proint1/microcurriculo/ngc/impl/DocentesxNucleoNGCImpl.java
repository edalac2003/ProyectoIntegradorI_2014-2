package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.udea.proint1.microcurriculo.dto.TbAdmDocentesxnucleo;
import com.udea.proint1.microcurriculo.ngc.DocentesxNucleoNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class DocentesxNucleoNGCImpl implements DocentesxNucleoNGC {
	
	private static Logger log=Logger.getLogger(DocentesxNucleoNGCImpl.class);


	public DocentesxNucleoNGCImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void guardarDocentexNucleo(int id, String idNucleo,
			String idPersona, String usuario, Date modFecha)
			throws ExcepcionesLogica {
		// TODO Auto-generated method stub

	}

	@Override
	public void actualizarDocentexNucleo(String idNucleo, String idPersona,
			String usuario, Date modFecha) throws ExcepcionesLogica {
		// TODO Auto-generated method stub

	}

	@Override
	public List<TbAdmDocentesxnucleo> listarDocentesxNucleo()
			throws ExcepcionesLogica {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TbAdmDocentesxnucleo obtenerDocentexNucleo(int id)
			throws ExcepcionesLogica {
		// TODO Auto-generated method stub
		return null;
	}

}
