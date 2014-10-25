package com.udea.proint1.microcurriculo.ngc;

import java.util.Date;
import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbAdmUsuarios;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface UsuariosNGC {
	
	public TbAdmUsuarios obtenerEstados (int id) throws ExcepcionesLogica;
	public void guardarUsuarios (int id, int idPersona, String login, String password, int estado, String usuario, Date fecha) throws ExcepcionesLogica;
    public void actualizarUsuarios (int idPersona, String login, String password, int estado, String usuario, Date fecha) throws ExcepcionesLogica;
    public List<TbAdmUsuarios> listarUsuarios () throws ExcepcionesLogica;

}
