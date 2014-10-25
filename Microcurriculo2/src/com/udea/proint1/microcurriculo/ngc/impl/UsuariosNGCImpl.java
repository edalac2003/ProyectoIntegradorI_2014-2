package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.Date;
import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbAdmUsuarios;
import com.udea.proint1.microcurriculo.ngc.UsuariosNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class UsuariosNGCImpl implements UsuariosNGC {
	
	public class UsuariosNGCimpl implements UsuariosNGC {

		private static Logger log=Logger.getLogger(UsuariosNGCImpl.class);
			
			UsuariosDAO usuariosDao;
			
			public UsuariosDAO getUsuariosDAO() {
				return usuariosDao;
			}

			public void setusuariosDao(UsuariosDAO usuariosDao) {
				this.usuariosDao = usuariosDao;

	@Override
	public TbAdmUsuarios obtenerEstados(int id) throws ExcepcionesLogica {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void guardarUsuarios(int id, int idPersona, String login,
			String password, int estado, String usuario, Date fecha)
			throws ExcepcionesLogica {
		// TODO Auto-generated method stub

	}

	@Override
	public void actualizarUsuarios(int idPersona, String login,
			String password, int estado, String usuario, Date fecha)
			throws ExcepcionesLogica {
		// TODO Auto-generated method stub

	}

	@Override
	public List<TbAdmUsuarios> listarUsuarios() throws ExcepcionesLogica {
		// TODO Auto-generated method stub
		return null;
	}

}
