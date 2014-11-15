package com.udea.proint1.microcurriculo.ngc.impl;

import java.util.List;

import org.hibernate.Session;

import com.udea.proint1.microcurriculo.dao.ObjetivosDAO;
import com.udea.proint1.microcurriculo.dto.TbMicObjetivos;
import com.udea.proint1.microcurriculo.ngc.ObjetivosNGC;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesDAO;
import com.udea.proint1.microcurriculo.util.exception.ExcepcionesLogica;

public class ObjetivosNGCImpl implements ObjetivosNGC {

	ObjetivosDAO objetivosDao;
	
	public void setObjetivosDao(ObjetivosDAO objetivosDao) {
		this.objetivosDao = objetivosDao;
	}

	public ObjetivosNGCImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public TbMicObjetivos obtenerSubtemas(int idObjetivo)
			throws ExcepcionesLogica {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void guardarObjetivos(TbMicObjetivos objetivo) throws ExcepcionesLogica {
		TbMicObjetivos objetivosTMP = null;
		
		if (objetivo != null){
			
			try {
				objetivosTMP = objetivosDao.obtenerObjetivo(objetivo.getNbIdobjetivo());		
			} catch (ExcepcionesDAO e) {
				throw new ExcepcionesLogica("No fue posible comprobar la existencia del Obejtivo.");
			}
			if (objetivosTMP == null){
				try {
					objetivosDao.guardarObjetivo(objetivo);
				} catch (ExcepcionesDAO e) {
					throw new ExcepcionesLogica("Se presentaron problemas al momento de intentar Guardar el registor <OBJETIVO>");
				}
			}else {
				throw new ExcepcionesLogica("El objeto de tipo <Objetivo> ya se Encuentra en la Base de Datos.");
			}
		} else {
			throw new ExcepcionesLogica("EL Objeto <Objetivo> está vacio.");
		}
	}

		
	@Override
	public void guardarObjetivos(List<TbMicObjetivos> listaObjetivo) throws ExcepcionesLogica {
		if (listaObjetivo != null){
			for(TbMicObjetivos objetivo:listaObjetivo){
				guardarObjetivos(objetivo);
			}
		} else{
			throw new ExcepcionesLogica("El objeto <Lista Objetivos> no tiene información válida.");
		}
	}

	
	@Override
	public void actualizarObjetivos(TbMicObjetivos objetivo)
			throws ExcepcionesLogica {
		// TODO Auto-generated method stub

	}

	@Override
	public List<TbMicObjetivos> listarObjetivos() throws ExcepcionesLogica {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int numeroRegistros() throws ExcepcionesLogica {
		int numeroRegistro = 0;
		try {
			numeroRegistro = objetivosDao.numeroRegistros();
		} catch (ExcepcionesDAO e) {
			e.printStackTrace();
		}
		
		return numeroRegistro;
	}

}
