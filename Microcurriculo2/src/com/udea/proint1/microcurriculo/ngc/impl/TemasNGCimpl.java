package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.Date;
import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbMicTemas;
import com.udea.proint1.microcurriculo.ngc.TemasNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class TemasNGCimpl implements TemasNGC {
	
	public class TemasNGCimpl implements TemasNGC {
		
		private static Logger log=Logger.getLogger(TemasNGCImpl.class);
		
		TemasDAO temasDao;
		
		public TemasDAO getTemasDAO() {
			return temasDao;
		}

		public void setTemasDao(TemasDAO temasDao) {
			this.temasDao = temasDao;
		}

	@Override
	public TbMicTemas obtenerTemas(int idTema) throws ExcepcionesLogica {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void guardarTemas(int idTema, String descripcion, String usuario,
			Date fecha) throws ExcepcionesLogica {
		// TODO Auto-generated method stub

	}

	@Override
	public void actualizarTema(String descripcion, String usuario, Date fecha)
			throws ExcepcionesLogica {
		// TODO Auto-generated method stub

	}

	@Override
	public List<TbMicTemas> listarTemas() throws ExcepcionesLogica {
		// TODO Auto-generated method stub
		return null;
	}

}
