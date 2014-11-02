package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.udea.proint1.microcurriculo.dao.CiudadesDAO;
import com.udea.proint1.microcurriculo.dao.DepartamentosDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmCiudades;
import com.udea.proint1.microcurriculo.ngc.CiudadesNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class CiudadesNGCImpl implements CiudadesNGC {

	private static Logger log = Logger.getLogger(CiudadesNGCImpl.class);
	
	CiudadesDAO ciudadesDao;
	DepartamentosDAO departamentoDao;

	public void setCiudadesDao(CiudadesDAO ciudadesDao) {
		this.ciudadesDao = ciudadesDao;
	}

	public void setDepartamentoDao(DepartamentosDAO departamentoDao) {
		this.departamentoDao = departamentoDao;
	}

	public CiudadesNGCImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public TbAdmCiudades obtenerCiudad(int id) throws ExcepcionesLogica {
		/*
		 * Comprobamos que el dato id no sea vacio
		 */
		if(id==0){
			throw new ExcepcionesLogica("No se ha ingresado una identificación de ciudad,está vacia");
		}
		TbAdmCiudades ciudad = null;
		
		try {
			//le pedimos a la clase Dao que nos traiga la ciudad con dicho id
			ciudad = ciudadesDao.obtenerCiudad(id);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerCiudad de la clase ciudadesDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(ciudad == null){
			//si está vacio tira una excepción
			throw new ExcepcionesLogica("No se encontró ciudad con el id "+ id);
		}else{
			//si no esta vacio retorna la ciudad
			return ciudad;
		}
	}

	@Override
	public List<TbAdmCiudades> listarCiudades() throws ExcepcionesLogica {
		List<TbAdmCiudades> listaCiudades = null;
		try {
			listaCiudades = ciudadesDao.listarCiudades();
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo listarCiudades de la clase ciudadesDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		if(listaCiudades == null){
			//si está vacio tira una excepción
			throw new ExcepcionesLogica("No se encontraron ciudades en la tabla TbAdmCiudades");
		}else{
			//si no esta vacio retorna las ciudadades
			return listaCiudades;
		}
	}

}
