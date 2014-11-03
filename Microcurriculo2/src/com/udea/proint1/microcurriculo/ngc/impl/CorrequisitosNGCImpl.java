package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.udea.proint1.microcurriculo.dao.CorrequisitosDAO;
import com.udea.proint1.microcurriculo.dao.MateriasDAO;
import com.udea.proint1.microcurriculo.dto.TbAdmCorrequisitos;
import com.udea.proint1.microcurriculo.dto.TbAdmMaterias;
import com.udea.proint1.microcurriculo.ngc.CorrequisitosNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class CorrequisitosNGCImpl implements CorrequisitosNGC {
	
	private static Logger log=Logger.getLogger(CorrequisitosNGCImpl.class);	

	CorrequisitosDAO correquisitosDao;
	MateriasDAO materiasDao;
	
	public void setCorrequisitosDao(CorrequisitosDAO correquisitosDao) {
		this.correquisitosDao = correquisitosDao;
	}

	public void setMateriasDao(MateriasDAO materiasDao) {
		this.materiasDao = materiasDao;
	}

	public CorrequisitosNGCImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void guardarCorrequisito(TbAdmCorrequisitos correquisito)
			throws ExcepcionesLogica {

	}

	@Override
	public void actualizarCorrequisito(TbAdmCorrequisitos correquisito) throws ExcepcionesLogica {
		// TODO Auto-generated method stub

	}

	@Override
	public List<TbAdmCorrequisitos> listarCorrequisitos()
			throws ExcepcionesLogica {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TbAdmCorrequisitos obtenerCorrequisito(int id) throws ExcepcionesLogica {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<TbAdmCorrequisitos> listarCorrequisitosxMateria(String id) throws ExcepcionesLogica{
		
		List<TbAdmCorrequisitos> listaCorrequisitos = null;
		
		TbAdmMaterias materia= null;
		
		try {
			materia = materiasDao.obtenerMateria(id);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo obtenerMateria de la clase materiasDao: "+ e);
		}
		
		if(materia == null){
			throw new ExcepcionesLogica("NO existe materia a consultar"); 
		}
		
		try {
			listaCorrequisitos = correquisitosDao.listarCorrequisitosxmateria(materia);
		} catch (ExcepcionesDAO e) {
			log.error("falló al invocar el metodo listarCorrequisitosxmateria de la clase correquisitosDao: "+ e);
		}
		
		/*
		 * Confirmamos si el objeto retornado tiene elementos en él.
		 */
		return listaCorrequisitos;
	}

}
