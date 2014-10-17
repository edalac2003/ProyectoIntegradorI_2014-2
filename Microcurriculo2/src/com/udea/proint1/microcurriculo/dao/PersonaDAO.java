package com.udea.proint1.microcurriculo.dao;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.Persona;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public interface PersonaDAO {

	public void guardarPersona(Persona persona) throws ExcepcionesDAO;
	
	public void modificarPersona(Persona persona) throws ExcepcionesDAO;
	
	public Persona obtenerPersona(String idPersona) throws ExcepcionesDAO;
	
	public Persona obtenerPersonaPorTipo(String idPersona, int tipoPersona) throws ExcepcionesDAO;
	
	public List<Persona> listarPersonas() throws ExcepcionesDAO;
	
	public List<Persona> listarDocentePorNucleo(String idNucleo) throws ExcepcionesDAO;
	
}
