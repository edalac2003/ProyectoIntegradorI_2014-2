package com.udea.proint1.microcurriculo.dao;

import java.util.List;

import com.udea.proint1.microcurriculo.dto.TbMicTemas;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;

public interface TemasDAO {
	
	public void guardarTema(TbMicTemas tema) throws ExcepcionesDAO;
	
	public void guardarTema(List<TbMicTemas> listaTema) throws ExcepcionesDAO;
	
	public void modificarTema(TbMicTemas tema) throws ExcepcionesDAO;
	
	public TbMicTemas obtenerTema(int idTema) throws ExcepcionesDAO;
	
	public TbMicTemas obtenerTemaxNombre(String nombre) throws ExcepcionesDAO;
	
	public List<TbMicTemas> listarTemas() throws ExcepcionesDAO;
	
	public int contarRegistros() throws ExcepcionesDAO;
	

}

