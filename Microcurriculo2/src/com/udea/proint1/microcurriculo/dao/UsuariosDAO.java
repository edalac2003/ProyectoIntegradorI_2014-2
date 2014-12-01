package com.udea.proint1.microcurriculo.dao;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbAdmUsuarios;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public interface UsuariosDAO {

	public void guardarUsuarios(TbAdmUsuarios usuario) throws ExcepcionesDAO;
	
	public TbAdmUsuarios obtenerUsuarios(int id) throws ExcepcionesDAO;
	
	public List<TbAdmUsuarios> listarUsuarios() throws ExcepcionesDAO;
	
	public void actualizarUsuarios(TbAdmUsuarios usurios) throws ExcepcionesDAO;
}
