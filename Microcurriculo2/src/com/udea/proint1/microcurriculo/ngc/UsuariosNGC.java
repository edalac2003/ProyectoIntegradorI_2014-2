package com.udea.proint1.microcurriculo.ngc;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbAdmUsuarios;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface UsuariosNGC {

	public void guardarUsuarios(TbAdmUsuarios usuario) throws ExcepcionesLogica;
	
	public TbAdmUsuarios obtenerUsuarios(int id) throws ExcepcionesLogica;
	
	public List<TbAdmUsuarios> listarUsuarios() throws ExcepcionesLogica;
	
	public void actualizarUsuarios(TbAdmUsuarios usuario) throws ExcepcionesLogica;
	
}
