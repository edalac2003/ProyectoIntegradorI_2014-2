package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.udea.proint1.microcurriculo.dto.TbMicTemas;
import com.udea.proint1.microcurriculo.ngc.TemasNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;
	
	public class TemasNGCImpl implements TemasNGC {
		
		private static Logger log=Logger.getLogger(TemasNGCImpl.class);
		
		TemasDAO temasDao;

		public void setTemasDao(TemasDAO temasDao) {
			this.temasDao = temasDao;
		}

	@Override
	public TbMicTemas obtenerTemas(int idTema) throws ExcepcionesLogica {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void guardarTemas(TbMicTemas tema) throws ExcepcionesLogica {
		// TODO Auto-generated method stub

	}

	@Override
	public void actualizarTema(TbMicTemas tema) throws ExcepcionesLogica {
		// TODO Auto-generated method stub

	}

	@Override
	public List<TbMicTemas> listarTemas() throws ExcepcionesLogica {
		// TODO Auto-generated method stub
		return null;
	}

}
