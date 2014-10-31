package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.udea.proint1.microcurriculo.dao.DepartamentosDAO;
import com.udea.proint1.microcurriculo.dao.PaisesDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmDepartamentos;
import com.udea.proint1.microcurriculo.ngc.DepartamentosNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class DepartamentosNGCImpl implements DepartamentosNGC {
	
	private static Logger log=Logger.getLogger(DepartamentosNGCImpl.class);
	
	DepartamentosDAO departamentosDao;
	PaisesDAO paisesDao;

	public void setDepartamentosDao(DepartamentosDAO departamentosDao) {
		this.departamentosDao = departamentosDao;
	}

	public void setPaisesDao(PaisesDAO paisesDao) {
		this.paisesDao = paisesDao;
	}

	public DepartamentosNGCImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<TbAdmDepartamentos> listarDepartamentos() throws ExcepcionesLogica {
		List<TbAdmDepartamentos> listaDepartamentos = null;
		try {
			listaDepartamentos = departamentosDao.listarDepartamentos();
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo listarDepartamentos de la clase departamentosDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(listaDepartamentos == null){
			//si está vacio tira una excepción
			throw new ExcepcionesLogica("No se encontraron departamentos en la tabla TbAdmDepartamentos");
		}else{
			//si no esta vacio retorna los departamentos
			return listaDepartamentos;
		}
	}

	@Override
	public TbAdmDepartamentos obtenerDepartamentos(int id) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el dato id no sea vacio
		 */
		if(id==0){
			throw new ExcepcionesLogica("No se ha ingresado una identificación de departamento,está vacia");
		}
		TbAdmDepartamentos departamento = null;
		
		try {
			//le pedimos a la clase Dao que nos traiga la Departamento con dicho id
			departamento = departamentosDao.obtenerDepartamento(id);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerDepartamento de la clase departamentosDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(departamento == null){
			//si está vacio tira una excepción
			throw new ExcepcionesLogica("No se encontró departamento con el id "+ id);
		}else{
			//si no esta vacio retorna la Departamento
			return departamento;
		}
	}

}
