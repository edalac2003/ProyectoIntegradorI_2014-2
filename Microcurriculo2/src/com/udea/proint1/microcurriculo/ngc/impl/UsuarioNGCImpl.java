package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.udea.proint1.microcurriculo.dao.UsuariosDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmUsuarios;
import com.udea.proint1.microcurriculo.dto.TbMicBiblioxunidad;
import com.udea.proint1.microcurriculo.ngc.UsuariosNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class UsuarioNGCImpl implements UsuariosNGC {

	private static Logger log=Logger.getLogger(UsuarioNGCImpl.class);
	
	UsuariosDAO usuariosDao;
	
	public void setUsuariosDao(UsuariosDAO usuariosDao) {
		this.usuariosDao = usuariosDao;
	}

	@Override
	public void guardarUsuarios(TbAdmUsuarios usuario) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no est� vacio
		 */
		if(usuario == null){
			throw new ExcepcionesLogica("El objeto usuario est� vacio");
		}
		try {
			int id = usuario.getNbId();
			TbAdmUsuarios usuarioConsulta = usuariosDao.obtenerUsuarios(id);
		
			if(usuarioConsulta != null){
				throw new ExcepcionesLogica("El usuario a insertar ya existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("fall� al invocar el metodo obtenerUsuarios de la clase usuariosDao: "+ e);
		}
		
		try {
			
			usuariosDao.guardarUsuarios(usuario);
		
		} catch (ExcepcionesDAO e) {
			log.error("fall� al invocar el metodo guardarUsuarios de la clase usuariosDao: "+ e);
		}
	}

	@Override
	public TbAdmUsuarios obtenerUsuarios(int id) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el dato id no sea vacio
		 */
		if(id == 0){
			throw new ExcepcionesLogica("No se ha ingresado una identificación de usuario, está vacia");
		}
		TbAdmUsuarios usuario = null;
		
		try {
			//le pedimos a la clase Dao que nos traiga la ciudad con dicho id
			usuario = usuariosDao.obtenerUsuarios(id);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerUsuarios de la clase usuariosDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(usuario == null){
			//si está vacio tira una excepción
			throw new ExcepcionesLogica("No se encontró usuario con el id "+ id);
		}else{
			//si no esta vacio retorna la ciudad
			return usuario;
		}
	}

	@Override
	public List<TbAdmUsuarios> listarUsuarios() throws ExcepcionesLogica {
		List<TbAdmUsuarios> listaUsuarios = null;
		try {
			listaUsuarios = usuariosDao.listarUsuarios();
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo listarUsuarios de la clase usuariosDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(listaUsuarios == null){
			throw new ExcepcionesLogica("No se encontraron usuarios en la tabla TbAdmUsuarios");
		}else{
			return listaUsuarios;
		}
	}

	@Override
	public void actualizarUsuarios(TbAdmUsuarios usuario)
			throws ExcepcionesLogica {
		/*
		 * Comprobamos que el objeto id no esté vacio
		 */
		if(usuario == null){
			throw new ExcepcionesLogica("El objeto usuario está vacio");
		}
		try {
			int id = usuario.getNbId();
			TbAdmUsuarios usuarioConsulta = usuariosDao.obtenerUsuarios(id);
		
			if(usuarioConsulta == null){
				throw new ExcepcionesLogica("El Usuario a actualizar no existe");
			}
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerUsuarios de la clase usuariosDao: "+ e);
		}
		
		try {
			
			usuariosDao.actualizarUsuarios(usuario);
		
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo actualizarUsuarios de la clase usuariosDao: "+ e);
		}
	}

}
