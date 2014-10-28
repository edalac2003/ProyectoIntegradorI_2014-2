package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.udea.proint1.microcurriculo.dto.TbMicSubtemas;
import com.udea.proint1.microcurriculo.ngc.SubtemasNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class SubtemasNGCImpl implements SubtemasNGC {
		
		private static Logger log=Logger.getLogger(SubtemasNGCImpl.class);
		
		SubtemasDAO subtemasDao;
		
		public SubtemasDAO getSubtemasDAO() {
			return subtemasDao;
		}

		public void setsubtemasDao(SubtemasDAO subtemasDao) {
			this.subtemasDao = subtemasDao;
		}
	@Override
	public TbMicSubtemas obtenerSubtemas(int idSubtema)
			throws ExcepcionesLogica {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void guardarSubtemas(int idSubtema, int idTema, String descripcion,
			String usuario, Date fecha) throws ExcepcionesLogica {
		// TODO Auto-generated method stub

	}

	@Override
	public void actualizarSubtemas(int idTema, String descripcion,
			String usuario, Date fecha) throws ExcepcionesLogica {
		// TODO Auto-generated method stub

	}

	@Override
	public List<TbMicSubtemas> listarSubtemas() throws ExcepcionesLogica {
		// TODO Auto-generated method stub
		return null;
	}

}
