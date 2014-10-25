package com.udea.proint1.microcurriculo.ngc;

import java.util.Date;
import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbAdmPersona;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public interface PersonaNGC {
	
	public void obtenerPersona(String id, int idTipoPersona, int idCiudad, int TipoIdentificacion,
			String nombres, String apellidos, String email, String telefono, int estado, String usuario, Date modFecha) throws ExcepcionesLogica;

	public void actualizarPersona(int idTipoPersona, int idCiudad, int TipoIdentificacion,
			String nombres, String apellidos, String email, String telefono, int estado, String usuario, Date modFecha) throws ExcepcionesLogica;

	public TbAdmPersona obtenerPersona(String id)throws ExcepcionesLogica;
	
	public List<TbAdmPersona> listarPersonas() throws ExcepcionesLogica;

}
