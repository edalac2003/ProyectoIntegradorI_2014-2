package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.udea.proint1.microcurriculo.dao.EstadosDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmMaterias;
import com.udea.proint1.microcurriculo.dto.TbMicEstados;
import com.udea.proint1.microcurriculo.ngc.EstadosNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class EstadosNGCImpl implements EstadosNGC {

	private static Logger logger = Logger.getLogger(EstadosNGCImpl.class);
	
	EstadosDAO estadosDao;
	
	
	public void setEstadosDao(EstadosDAO estadosDao) {
		this.estadosDao = estadosDao;
	}

	public EstadosNGCImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public TbMicEstados obtenerEstados(int idEstado) throws ExcepcionesLogica {
		TbMicEstados estado = null;
		
		try {
			estado = estadosDao.obtenerEstado(idEstado);
		} catch (ExcepcionesDAO e) {
			logger.error("Se presentaron errores para Encontrar el Estado Solicitado.");
		}
		
		if (estado != null){
			return estado;
		} else {
			logger.error("Registro no hallado.  Se devolver� nulo.");
			return null;
		}
		
		
	}

	@Override
	public void guardarEstados(TbMicEstados estado) throws ExcepcionesLogica {
		// TODO Auto-generated method stub

	}

	@Override
	public void actualizarEstados(TbMicEstados estado) throws ExcepcionesLogica {
		// TODO Auto-generated method stub

	}

	@Override
	public List<TbMicEstados> listarEstados() throws ExcepcionesLogica {
		List<TbMicEstados> listaEstados = null;
		try {
			listaEstados = estadosDao.listarEstados();
		} catch (ExcepcionesDAO e) {
			logger.error("falló al invocar el metodo listarEstados de la clase estadosDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(listaEstados == null){
			throw new ExcepcionesLogica("No se encontraron estados en la tabla TbMicEstados");
		}else{
			return listaEstados;
		}
	}

}
