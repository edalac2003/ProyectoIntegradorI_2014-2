<<<<<<< HEAD
package com.udea.proint1.microcurriculo.dao;

import java.util.List;

import mapeos.Temas;

import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public interface TemasDAO {
	
	public void guardarTema(Temas tema) throws ExcepcionesDAO;
	
	public List<Temas> listarTemas() throws ExcepcionesDAO;
	
	public Temas obtenerTema(int idTema) throws ExcepcionesDAO;
	
	public void actualizarTema(Temas tema) throws ExcepcionesDAO;

}
=======
package com.udea.proint1.microcurriculo.dao;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.Temas;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public interface TemasDAO {
	
	public void guardarTema(Temas tema) throws ExcepcionesDAO;
	
	public void modificarTema(Temas tema) throws ExcepcionesDAO;
	
	public Temas obtenerTema(int idTema) throws ExcepcionesDAO;
	
	public List<Temas> listarTemas() throws ExcepcionesDAO;
	

}
>>>>>>> branch 'master' of https://github.com/edalac2003/ProyectoIntegradorI_2014-2
